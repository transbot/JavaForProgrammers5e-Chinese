// 图18.2: StreamStatisticsComparison.java
// 比较顺序流与并行流操作的性能
import java.time.Duration;
import java.time.InstantSource;
import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.concurrent.ThreadLocalRandom;

public class StreamStatisticsComparison {
   public static void main(String[] args) {
      var clock = InstantSource.system(); // 获取系统时钟用于计时

      // 创建包含随机长整数的数组
      var values = new long[1_000_000_000];
      Arrays.parallelSetAll(values, 
         i -> ThreadLocalRandom.current().nextLong(1, 1001));
      
      // 单独执行各项计算
      var separateStart = clock.instant();                         
      long count = Arrays.stream(values).count();                    
      long sum = Arrays.stream(values).sum();                        
      long min = Arrays.stream(values).min().getAsLong();            
      long max = Arrays.stream(values).max().getAsLong();            
      double average = Arrays.stream(values).average().getAsDouble();
      var separateEnd = clock.instant();                           

      // 显示结果
      System.out.println("单独执行各项计算的结果");
      System.out.printf("    总数: %d%n", count);
      System.out.printf("    总和: %d%n", sum);
      System.out.printf("    最小值: %d%n", min);
      System.out.printf("    最大值: %d%n", max);
      System.out.printf("    平均值: %f%n", average);
      System.out.printf("总耗时(毫秒): %d%n%n", 
         Duration.between(separateStart, separateEnd).toMillis());

      // 顺序流统计操作计时
      System.out.println("顺序流统计计算中");
      var sequentialStart = clock.instant();                     
      LongSummaryStatistics results1 = 
         Arrays.stream(values).summaryStatistics();
      var sequentialEnd = clock.instant();                       

      // 显示结果
      displayStatistics(results1);
      System.out.printf("总耗时(毫秒): %d%n%n", 
         Duration.between(sequentialStart, sequentialEnd).toMillis());

      // 并行流统计操作计时
      System.out.println("并行流统计计算中");
      var parallelStart = clock.instant();                       
      LongSummaryStatistics results2 = 
         Arrays.stream(values).parallel().summaryStatistics();
      var parallelEnd = clock.instant();                         

      // 显示结果
      displayStatistics(results2);
      System.out.printf("总耗时(毫秒): %d%n%n", 
         Duration.between(parallelStart, parallelEnd).toMillis());
   }

   // 显示LongSummaryStatistics的统计值
   private static void displayStatistics(LongSummaryStatistics stats) {
      System.out.println("统计结果");
      System.out.printf("    总数: %d%n", stats.getCount());
      System.out.printf("    总和: %d%n", stats.getSum());
      System.out.printf("    最小值: %d%n", stats.getMin());
      System.out.printf("    最大值: %d%n", stats.getMax());
      System.out.printf("    平均值: %f%n", stats.getAverage());
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