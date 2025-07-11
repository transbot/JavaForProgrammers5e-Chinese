// 图11.10: TitanicAnalysis.java
// 从CSV文件读取泰坦尼克号灾难数据集并进行分析
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TitanicAnalysis {
   // 表示数据集中每行字段的record类
   @JsonIgnoreProperties(ignoreUnknown = true)
   public record TitanicRecord(
      String survived,
      String sex,
      String age,
      String passengerClass
   ) {}

   public static void main(String[] args) throws Exception {
      var mapper = new CsvMapper(); // 读取CSV记录

      // 要求Jackson根据CSV列名，将每个
      // 列名都映射到一个对象
      CsvSchema schema = CsvSchema.emptySchema().withHeader(); 

      // 创建MappingIterator，它知道如何将
      // 文件记录读入TitanicRecord对象
      MappingIterator<TitanicRecord> iterator = 
         mapper.readerFor(TitanicRecord.class).with(schema).readValues(
            Path.of("TitanicSurvival.csv").toFile());

      // 将数据集加载到TitanicRecord对象列表中
      List<TitanicRecord> titanic = iterator.readAll();

      // 创建理表，用正确的类型代表每一列
      var survived = new ArrayList<String>();
      var sex = new ArrayList<String>();
      var age = new ArrayList<Double>();
      var pclass = new ArrayList<Integer>();

      // 填充列列表
      for (TitanicRecord record : titanic) {
         survived.add(record.survived());
         sex.add(record.sex());
         age.add(!record.age().isEmpty() ? 
            Double.parseDouble(record.age()) : Double.NaN);
         pclass.add(
            switch (record.passengerClass()) {
               case "1st" -> 1;
               case "2nd" -> 2;
               case "3rd" -> 3;
               default -> throw new IllegalArgumentException(
                  "未知舱位等级: " + record.passengerClass());
            }
         );
      }

      // 显示前5行数据
      System.out.printf("前5行数据:%n%-8s%-7s%-6s%s%n", 
         "幸存", "性别", "年龄", "舱位等级");
     
      for (int i = 0; i < 5; ++i) {
         System.out.printf("%-10s%-8s%-8.1f%d%n", 
            survived.get(i), sex.get(i), age.get(i), pclass.get(i));
      }

      // 显示最后5行数据
      System.out.printf("%n最后5行数据:%n%-8s%-7s%-6s%s%n", 
         "幸存", "性别", "年龄", "舱位等级");
      int count = titanic.size();
     
      for (int i = count - 5; i < count; ++i) {
         System.out.printf("%-10s%-8s%-8.1f%d%n", 
            survived.get(i), sex.get(i), age.get(i), pclass.get(i));
      }

      // 清理年龄列（移除NaN值）
      var cleanAge = new ArrayList<Double>();
      for (Double value : age) {
         if (!value.isNaN()) {
            cleanAge.add(value);
         }
      }

      // 清理后年龄列的描述性统计
      cleanAge.sort(null); // 帮助确定最小、最大和中位年龄
      int size = cleanAge.size(); 

      // 获取中位年龄
      double medianAge = (size % 2 == 0) ?
         (cleanAge.get(size / 2 - 1) + cleanAge.get(size / 2)) / 2.0 :
         cleanAge.get(size / 2);

      // 计算平均年龄
      double sum = 0.0;
     
      for (double value : cleanAge) {
         sum += value;
      }

      double averageAge = sum / size;

      // 显示年龄统计数据
      System.out.printf("%n年龄列的描述性统计:%n");
      System.out.printf("有年龄数据的乘客数: %d%n", size);
      System.out.printf("平均年龄: %.2f%n", averageAge);
      System.out.printf("最小年龄: %.2f%n", cleanAge.getFirst());
      System.out.printf("最大年龄: %.2f%n", cleanAge.getLast());
      System.out.printf("中位年龄: %.2f%n", medianAge);

      // 按舱位等级统计乘客数
      int[] counts = new int[4]; // 忽略元素0
     
      for (int value : pclass) {
         ++counts[value];
      }

      System.out.printf(
         "%n按舱位等级统计的乘客数:%n头等舱: %d%n二等舱: %d%n三等舱: %d%n", 
         counts[1], counts[2], counts[3]);

      // 按性别和舱位等级统计幸存者数量
      int survivorCount = 0;
      int[] survivorsBySex = new int[2];
      int[] survivorsByClass = new int[4]; // 忽略元素0

      for (int i = 0; i < survived.size(); ++i) {
         if (survived.get(i).equals("yes")) {
            ++survivorCount;

            if (sex.get(i).equals("女")) {
               ++survivorsBySex[0];
            } 
            else {
               ++survivorsBySex[1];
            }
           
            ++survivorsByClass[pclass.get(i)];
         }
      }

      // 计算并显示幸存者统计数据
      System.out.printf("%n幸存者数量: %d%n遇难者数量: %d%n", 
         survivorCount, survived.size() - survivorCount);
      System.out.printf("幸存者比例: %.2f%%%n", 
         100.0 * survivorCount / survived.size());
      System.out.printf("女性幸存者比例: %.2f%%%n", 
         100.0 * survivorsBySex[0] / survivorCount);
      System.out.printf("男性幸存者比例: %.2f%%%n", 
         100.0 * survivorsBySex[1] / survivorCount);
      System.out.printf("头等舱幸存者比例: %.2f%%%n", 
         100.0 * survivorsByClass[1] / survivorCount);
      System.out.printf("二等舱幸存者比例: %.2f%%%n", 
         100.0 * survivorsByClass[2] / survivorCount);
      System.out.printf("三等舱幸存者比例: %.2f%%%n", 
         100.0 * survivorsByClass[3] / survivorCount);
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