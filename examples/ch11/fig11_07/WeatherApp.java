// 图11.7: WeatherApp.java
// 使用OpenWeatherMap Web服务获取指定城市的当前天气
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

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

// 用于JSON映射的record类
@JsonIgnoreProperties(ignoreUnknown = true)
record WeatherData(
   Weather[] weather,
   Main main,
   long dt, // 日期和时间
   int timezone,
   String name
) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Weather(
   String main,
   String description,
   String icon
) {}

@JsonIgnoreProperties(ignoreUnknown = true)
record Main(
   double temp,
   double feels_like,
   int pressure,
   int humidity
) {}

public class WeatherApp {
   public static void main(String[] args) throws Exception {
      // 检查命令行参数是否正确
      if (args.length != 1) {
         System.out.println("用法: WeatherApp <城市名(英文)>");
         System.exit(1);
      }

      String city = args[0]; // 从命令行参数获取城市名

      // 从环境变量OPENWEATHERMAP_API_KEY加载API密钥
      String apiKey = System.getenv("OPENWEATHERMAP_API_KEY");

      // 检查API密钥是否存在且已设置
      if (apiKey == null || apiKey.isBlank()) {
         System.out.println(
            "OPENWEATHERMAP_API_KEY环境变量未设置。");
         System.exit(1);
      }

      // 对城市（city）参数进行URL编码
      String encodedCity = 
         URLEncoder.encode(city, StandardCharsets.UTF_8);

      // 创建API URL字符串
      String apiUrl = String.format(
          "https://api.openweathermap.org/" + 
          "data/2.5/weather?q=%s&units=metric&appid=%s",
          encodedCity, apiKey);

      // 使用Java的HttpClient发送请求
      HttpClient client = HttpClient.newHttpClient();

      // 构建一个请求（request），HttpClient将用它
      // 调用OpenWeatherMap Web服务
      HttpRequest request = 
         HttpRequest.newBuilder()
            .uri(URI.create(apiUrl))
            .GET()
            .build();

      // 发送HTTP请求并获取响应
      HttpResponse<String> response = 
         client.send(request, HttpResponse.BodyHandlers.ofString());

      // 检查请求是否成功
      if (response.statusCode() != 200) {
         System.out.printf("错误: 收到HTTP状态码 %d\n", 
            response.statusCode());
         System.exit(1);
      }

      // 将JSON响应直接解析为WeatherData记录
      var mapper = new ObjectMapper();
      WeatherData weatherData = 
         mapper.readValue(response.body(), WeatherData.class);

      // 将温度转换为华氏度
      double tempCurrentF = (weatherData.main().temp() * 9 / 5) + 32;
      double feelsLikeF = 
         (weatherData.main().feels_like() * 9 / 5) + 32;

      // 生成图标URL
      String iconName = weatherData.weather()[0].icon();
      String iconUrl = String.format(
         "https://openweathermap.org/img/wn/%s@4x.png", iconName);

      // 根据响应格式化日期和时间
      Instant timestamp = Instant.ofEpochSecond(weatherData.dt());
      String formattedDateTime = 
         DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.ofOffset("UTC", 
               ZoneOffset.ofTotalSeconds(weatherData.timezone())))
            .format(timestamp);

      System.out.printf("%s的天气\n", weatherData.name());
      System.out.printf("日期和时间: %s\n", formattedDateTime);
      System.out.printf("温度: %.1f°C (%.1f°F)\n", 
         weatherData.main().temp(), tempCurrentF);
      System.out.printf("体感温度: %.1f°C (%.1f°F)\n", 
         weatherData.main().feels_like(), feelsLikeF);
      System.out.printf("气压: %d hPa\n", 
         weatherData.main().pressure());
      System.out.printf("湿度: %d%%\n", 
         weatherData.main().humidity());
      System.out.printf("天气状况: %s\n", 
         weatherData.weather()[0].description());
      System.out.printf("图标: %s\n", iconUrl);
   }
}




/*************************************************************************
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
