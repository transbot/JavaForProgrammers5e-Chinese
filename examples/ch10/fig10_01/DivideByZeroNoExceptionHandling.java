// 图10.1: DivideByZeroNoExceptionHandling.java
// 未进行异常处理的整数除法
import java.util.Scanner;

public class DivideByZeroNoExceptionHandling {
   // 当发生除零异常时抛出异常
   public static int quotient(int numerator, int denominator) {
      return numerator / denominator; // 可能发生除数为零的情况
   } 

   public static void main(String[] args) {
      var input = new Scanner(System.in); 

      System.out.print("请输入一个整数分子: ");
      int numerator = input.nextInt();
      System.out.print("请输入一个整数分母: ");
      int denominator = input.nextInt();

      int result = quotient(numerator, denominator);
      System.out.printf(
         "%n结果: %d / %d = %d%n", numerator, denominator, result);
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
