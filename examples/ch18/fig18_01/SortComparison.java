// 图18.1: SortComparison.java
// 比较Arrays类中sort方法与parallelSort方法的性能
import java.time.Duration;
import java.time.InstantSource;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SortComparison {
   public static void main(String[] args) {
      var clock = InstantSource.system(); // 系统时钟用于计时排序

      // 创建随机int数组并复制副本；
      // Arrays的parallelSetAll方法将随机初始化array1
      // 的任务分配给可用的处理器核心
      var array1 = new int[100_000_000];
      Arrays.parallelSetAll(array1, 
         i -> ThreadLocalRandom.current().nextInt());
      var array2 = array1.clone();

      // 使用传统的Arrays.sort方法对array1排序并计时 
      System.out.println("开始执行sort排序");
      var sortStart = clock.instant();
      Arrays.sort(array1);              
      var sortEnd = clock.instant();  

      // 显示计时结果
      double sortTime = Duration.between(sortStart, sortEnd).toMillis();
      System.out.printf("排序耗时: %.3f秒%n%n", sortTime / 1000.0);

      // 使用Arrays.parallelSort方法对array2排序并计时
      System.out.println("开始执行parallelSort排序");
      var parallelSortStart = clock.instant();
      Arrays.parallelSort(array2);              
      var parallelSortEnd = clock.instant();  

      // 显示计时结果
      double parallelSortTime = 
         Duration.between(parallelSortStart, parallelSortEnd).toMillis();
      System.out.printf("排序耗时: %.3f秒%n%n", 
         parallelSortTime / 1000.0);

      // 以百分比形式显示时间差异
      String percentage = NumberFormat.getPercentInstance().format( 
         (sortTime - parallelSortTime) / parallelSortTime);
      System.out.printf("sort比parallelSort多耗时%s%n", 
         percentage);
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