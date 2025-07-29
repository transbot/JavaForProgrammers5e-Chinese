// 图18.4: TaskExecutor.java
// 使用ExecutorService来执行多个Runnable任务
import java.util.concurrent.Executors;

public class TaskExecutor {
   public static void main(String[] args) {
      // 创建并命名每个Runnable任务
      var task1 = new PrintTask("task1");
      var task2 = new PrintTask("task2");
      var task3 = new PrintTask("task3");
        
      System.out.println("正在启动Executor\n");

      // 创建ExecutorService来执行任务：
      // 当try-with-resources语句块执行完毕时，
      // 会自动调用ExecutorService的close方法，
      // 这将阻止其接受新任务，并等待现有任务完成执行
      try (var executorService = Executors.newCachedThreadPool()) {
         // 启动三个PrintTask
         executorService.execute(task1); // 启动task1	
         executorService.execute(task2); // 启动task2
         executorService.execute(task3); // 启动task3
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