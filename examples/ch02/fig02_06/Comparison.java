// 图2.6: Comparison.java
// 使用if语句、关系操作符和相等性
// 操作符比较两个整数
import java.util.Scanner; // 程序使用了Scanner类

public class Comparison {
   // main方法开始程序执行
   public static void main(String[] args) {
      // 创建一个Scanner对象从用户获取输入
      Scanner input = new Scanner(System.in);

      System.out.print("输入第一个整数: "); // 提示
      int number1 = input.nextInt(); // 从用户处读取第一个数

      System.out.print("输入第二个整数: "); // 提示
      int number2 = input.nextInt(); // 从用户处读取第二个数
      
      if (number1 == number2) {
         System.out.printf("%d == %d%n", number1, number2);
      }
      
      if (number1 != number2) {
         System.out.printf("%d != %d%n", number1, number2);
      }

      if (number1 < number2) {
         System.out.printf("%d < %d%n", number1, number2);
      }

      if (number1 > number2) {
         System.out.printf("%d > %d%n", number1, number2);
      }

      if (number1 <= number2) {
         System.out.printf("%d <= %d%n", number1, number2);
      }

      if (number1 >= number2) {
         System.out.printf("%d >= %d%n", number1, number2);
      }
   } // 结束main方法
} // 结束Comparison类


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
