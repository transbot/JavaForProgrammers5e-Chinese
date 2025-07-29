// 图18.5: VirtualThreadDemo.java
// 使用虚拟线程来执行多个Runnable任务
import java.util.concurrent.Executors;

public class VirtualThreadDemo {
   public static void main(String[] args) {
      // PrintTask构造函数为每个任务分配随机的休眠时间
      PrintTask task1 = new PrintTask("task1");
      PrintTask task2 = new PrintTask("task2");
      PrintTask task3 = new PrintTask("task3");
        
      System.out.println("正在启动Virtual-Thread-Per-Task Executor\n");

      // newVirtualThreadPerTaskExecutor返回的ExecutorService
      // 会用不同的虚拟线程运行每个任务。
      // 当try-with-resources语句块执行完毕时，会自动调用
      // ExecutorService的close方法。然后，程序等待虚拟线程结束
      try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
         // 启动三个PrintTask
         executor.execute(task1); // 启动task1	
         executor.execute(task2); // 启动task2
         executor.execute(task3); // 启动task3
      } 

      System.out.println("\nmain线程结束。");
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