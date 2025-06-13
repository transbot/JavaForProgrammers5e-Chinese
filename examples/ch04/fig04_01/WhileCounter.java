// 图4.1: WhileCounter.java
// 计数器控制的while循环

public class WhileCounter {
   public static void main(String[] args) {
      int counter = 1; // 声明并初始化控制变量

      while (counter <= 10) { // 循环继续条件
         System.out.printf("%d  ", counter);
         ++counter; // 递增控制变量
      }

      System.out.println(); 
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
