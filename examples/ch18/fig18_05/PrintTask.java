// 图18.3: PrintTask.java
// PrintTask类随机休眠0~5秒
import java.util.random.RandomGenerator;

public class PrintTask implements Runnable {
   private static final RandomGenerator generator =
      RandomGenerator.getDefault();
   private final int sleepTime; // 线程随机休眠时间（毫秒）
   private final String taskName; 
    
   // 构造函数：指定任务名称，
   // 并随机生成0~5秒的休眠时间
   public PrintTask(String taskName) {
      this.taskName = taskName;
      sleepTime = generator.nextInt(5001); // 单位：毫秒
   } 

   // run方法包含线程将执行的代码
   @Override
   public void run() {
      try { // 使线程进入休眠状态
         System.out.printf("%s即将休眠%d毫秒。%n", 
            taskName, sleepTime);
         Thread.sleep(sleepTime); 
      }       
      catch (InterruptedException exception) {
         exception.printStackTrace();
         Thread.currentThread().interrupt(); // 重新设置线程中断状态
      } 
        
      // 打印任务完成信息
      System.out.printf("%s结束休眠%n", taskName); 
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