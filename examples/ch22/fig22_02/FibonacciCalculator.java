// 图22.2: FibonacciCalculator.java
// 递归方法fibonacci
import java.math.BigInteger;

public class FibonacciCalculator {
   private static BigInteger TWO = BigInteger.valueOf(2);

   // fibonacci方法的递归声明
   public static BigInteger fibonacci(BigInteger number) {        
      if (number.equals(BigInteger.ZERO) ||                     
          number.equals(BigInteger.ONE)) { // 基本情况
         return number;                                            
      }
      else { // 递归步骤
         return fibonacci(number.subtract(BigInteger.ONE)).add(
            fibonacci(number.subtract(TWO)));                  
      }
   }

   public static void main(String[] args) {
      // 显示第0~40个斐波那契数
      for (int counter = 0; counter <= 40; ++counter) {
         System.out.printf("第%d个斐波那契数是: %d%n", counter,
            fibonacci(BigInteger.valueOf(counter)));
      } 
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

