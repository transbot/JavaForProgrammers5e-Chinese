// 图18.7: WeatherApp.java
// 使用OpenWeatherMap API以及结构化并发和
// 作用域值获取多个城市的天气
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.ScopedValue;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Collectors;

// 用于映射当前天气JSON数据的记录类
@JsonIgnoreProperties(ignoreUnknown = true)
record WeatherData(Weather[] weather, Main main, long dt, 
   int timezone, String name) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Weather(String main, String description) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Main(double temp) {}

// 用于映射天气预报JSON数据的记录类
@JsonIgnoreProperties(ignoreUnknown = true)
record ForecastResponse(List<ForecastEntry> list) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record ForecastEntry(long dt, Main main, Weather[] weather) {}

public class WeatherApp {
   // 加载OpenWeatherMap API密钥
   private static final String API_KEY = 
      System.getenv("OPENWEATHERMAP_API_KEY");

   // 用于发起Web服务请求的HttpClient
   private static final HttpClient HTTP_CLIENT = 
      HttpClient.newHttpClient(); 

   // 用于为指定城市启动每组请求
   private static final ScopedValue<String> CITY = 
      ScopedValue.newInstance();

   public static void main(String[] args) throws Exception {
      // 检查命令行参数是否有效
      if (args.length == 0) {
         System.out.println("用法: WeatherApp <英文城市名1> <英文城市名2> ...");
         System.exit(1);
      }

      // 模拟服务器处理每个请求的线程
      try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
         for (String city : args) {
            executor.submit(
               // 设置ScopedValue的值然后执行任务；
               // 任务及其子任务将有权访问该ScopedValue
               () -> ScopedValue.where(CITY, city).run(
                  // 任务：获取并打印城市天气信息
                  () -> {
                     try {
                        System.out.printf("%n%n%s的天气:\n%s\n", 
                           city, getWeather());
                     }
                     catch (Exception ex) {
                        System.err.printf(
                           "获取%s的天气时出错: %s\n", 
                           city, ex.getMessage());
                     }
                  } // 结束嵌套Lambda表达式
               ) // 结束ScopedValue.run方法调用
            ); // 结束executor.submit方法调用
         } // 结束for循环
      } // 结束try-with-resources语句
   }

   // 使用结构化并发请求当前天气和预报
   public static String getWeather() throws Exception {
      // URL编码城市参数
      String encodedCity = 
         URLEncoder.encode(CITY.get(), StandardCharsets.UTF_8);
      
      // 构建API URL
      String currentWeatherUrl = String.format(
         "https://api.openweathermap.org/data/2.5/weather?q=%s" +
         "&units=metric&appid=%s", encodedCity, API_KEY);
      String forecastUrl = String.format(
         "https://api.openweathermap.org/data/2.5/forecast?q=%s" +
         "&units=metric&appid=%s", encodedCity, API_KEY);
      
      // 使用StructuredTaskScope管理并发任务
      try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
         var currentWeatherTask = scope.fork(
            () -> requestData(currentWeatherUrl, WeatherData.class));
         var forecastTask = scope.fork( 
            () -> requestData(forecastUrl, ForecastResponse.class));
         
         scope.join(); // 等待响应完成
         scope.throwIfFailed(); // 如果任务失败则抛出异常

         // 任务成功完成，获取结果
         WeatherData weatherData = currentWeatherTask.get();
         ForecastResponse forecastResponse = forecastTask.get();

         // 格式化并返回输出
         return formatWeatherOutput(weatherData, forecastResponse);
      }
   }
   
   // 从OpenWeatherMap API检索JSON数据的通用方法
   private static <T> T requestData(String url, Class<T> type) 
      throws Exception {
      // 构建OpenWeatherMap Web服务请求
      HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(url)).GET().build();
      
      // 发送HTTP请求并获取响应
      HttpResponse<String> response = HTTP_CLIENT.send(request, 
         HttpResponse.BodyHandlers.ofString());
      
      // 检查请求是否成功，否则抛出异常
      if (response.statusCode() != 200) {
         throw new Exception(String.format(
            "错误: HTTP状态码%d\n", response.statusCode()));
      }

      // 使用Jackson库将JSON响应
      // 反序列化为指定的type
      return new ObjectMapper().readValue(response.body(), type);
   }
   
   // 格式化天气输出以便显示
   private static String formatWeatherOutput( 
      WeatherData weatherData, ForecastResponse forecastResponse) {
      
      // 当前温度
      double tempC = weatherData.main().temp();
      double tempF = (tempC * 9 / 5) + 32;
      
      // 日期格式化器
      DateTimeFormatter dateFormatter = 
         DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            .withZone(ZoneId.ofOffset("UTC", 
               ZoneOffset.ofTotalSeconds(weatherData.timezone())));
      
      // 5天/3小时天气预报（包含天气描述和温度）
      String forecastInfo = forecastResponse.list().stream().limit(16)
         .map(f -> {
            double tempCForecast = f.main().temp();
            double tempFForecast = (tempCForecast * 9 / 5) + 32;
            return String.format(
               "%s: %s; 温度: %.1f C (%.1f F)",
               dateFormatter.format(Instant.ofEpochSecond(f.dt())),
               f.weather()[0].main(), tempCForecast, tempFForecast);
         })
         .collect(Collectors.joining("\n"));
      
      return """
         %s当前天气状况: %s
         温度: %.1f C (%.1f F)
         
         预报:
         %s""".formatted(weatherData.name(), 
            weatherData.weather()[0].description(), 
            tempC, tempF, forecastInfo);
   }
}


/**************************************************************************
 * (C) Copyright 1992-2025 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/