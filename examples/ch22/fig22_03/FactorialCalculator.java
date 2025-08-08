// 图22.3: FactorialCalculator.java
// 迭代方法factorial
import java.math.BigInteger;

public class FactorialCalculator {
   // factorial方法的迭代声明
   public static BigInteger factorial(int number) {
      var result = BigInteger.ONE;

      // 迭代地计算阶乘
      for (int i = number; i >= 1; --i) {
         result = result.multiply(BigInteger.valueOf(i));
      }

      return result;
   } 

   public static void main(String[] args) {
      // 计算0~10的阶乘
      for (int counter = 0; counter <= 10; ++counter) {
         System.out.printf("%d! = %s%n", counter, factorial(counter));
      } 

      // 计算20、30和40的阶乘
      System.out.printf("%n20!: %s%n30!: %s%n40!: %s%n", 
         factorial(20), factorial(30), factorial(40));
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

