// 图18.6: PlatformAndVirtualThreads.java
// 平台线程与虚拟线程的性能对比
import java.time.Duration;
import java.time.InstantSource;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

public class PlatformAndVirtualThreads {
   // 执行并计时线程；计算1到任务数量的平方和
   private static void executeAndTimeThreads(int tasks, 
      String threadType, ExecutorService executor) throws Exception {
      var clock = InstantSource.system(); // 用于计时的系统时钟

      // 存储所有已启动任务的Future
      var futures = new ArrayList<Future<Long>>(tasks);

      System.out.printf(
         "正在%s上执行%d个任务...%n", threadType, tasks);
      var start = clock.instant();

      // try块结束时自动关闭ExecutorService；
      // 自动等待所有任务完成
      try (executor) {
         // 启动指定数量的任务
         LongStream.rangeClosed(1, tasks).forEach(value -> 
            futures.add(executor.submit(() -> {
               Thread.sleep(Duration.ofMillis(100 + (int)(Math.random() * 1900))); // 模拟阻塞操作
               return value * value; 
            }))
         );
      } 

      // 从Future中汇总结果
      long sum = 0;
      for (var future : futures) {
         sum += future.get(); 
      }

      var end = clock.instant();

      // 显示结果
      System.out.printf("执行时间: %.2f秒%n", 
         Duration.between(start, end).toMillis() / 1000.0);
      System.out.printf("1~%d的平方和: %d%n%n", tasks, sum);
   }
   
   public static void main(String[] args) throws Exception {
      // 检查命令行参数是否有效
      if (args.length != 1) {
         System.out.println("用法: PlatformAndVirtualThreads <任务数量>");
         System.exit(1);
      }

      // 获取要启动的线程数量
      final int TASKS = Integer.parseInt(args[0]); 

      // 使用固定线程池执行平台线程并计时
      executeAndTimeThreads(TASKS,  
         "平台线程（1000个线程的固定池）", 
         Executors.newFixedThreadPool(1000));

      // 使用缓存线程池执行平台线程并计时
      executeAndTimeThreads(TASKS, 
         "平台线程（缓存线程池）", 
         Executors.newCachedThreadPool());

      // 执行虚拟线程并计时
      executeAndTimeThreads(TASKS, 
         "虚拟线程", Executors.newVirtualThreadPerTaskExecutor());
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