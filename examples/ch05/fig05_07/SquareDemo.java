// 图5.7: SquareDemo.java
// 使用square方法来演示方法调用栈
// 和激活记录

public class SquareDemo {
   public static void main(String[] args) {
      int y = 10; // 待求平方的值（main中的局部变量）

      int result = square(y); // 计算y的平方并存入result
   }

   // 返回一个整数的平方值
   public static int square(int x) {
      return x * x; // 计算平方并返回结果
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
