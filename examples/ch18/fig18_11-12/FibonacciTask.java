   // 图18.11: FibonacciTask.java
   // 用于在后台计算斐波那契数的Task子类
   import javafx.concurrent.Task;

   public class FibonacciTask extends Task<Long> {
      private final int n; // 要计算的斐波那契数

      // 构造函数
      public FibonacciTask(int n) {
         this.n = n;
      } 

      // 应在工作线程中运行的耗时代码
      @Override
      protected Long call() {
         updateMessage("正在计算...");
         long result = fibonacci(n);
         updateMessage("计算完成。"); 
         return result;
      } 

      // 计算第n个斐波那契数（将在22.4节解释这个方法）
      public long fibonacci(long number) {
         if (number == 0 || number == 1) {
            return number;
         }
         else {
            return fibonacci(number - 1) + fibonacci(number - 2);
         }
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