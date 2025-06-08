// 图3.5: UsingBigInteger.java
// 使用Java API BigInteger类的对象来
// 创建和操作超大整数
import java.math.BigInteger;

public class UsingBigInteger {
   public static void main(String[] args) {
      // 显示一个long能存储的最大值
      System.out.printf("long的最大值: %d%n%n", Long.MAX_VALUE);

      // 可以从字符串或整数来创建BigInteger类型的对象
      BigInteger value1 = 
         new BigInteger("100000000000000000000000000000"); // 30位整数
      BigInteger value2 = BigInteger.valueOf(9_223_372_036_854_775_807L);
      BigInteger value3 = BigInteger.valueOf(17); 

      System.out.println("初始值");
      System.out.printf("BigInteger value1: %s%n", value1);
      System.out.printf("BigInteger value2: %s%n", value2);
      System.out.printf("BigInteger value3: %s%n", value3);

      System.out.println("\n对大整数进行加法、减法和乘法运算");
      System.out.printf("     value1.add(value2): %s%n", 
         value1.add(value2));
      System.out.printf("value1.subtract(value2): %s%n", 
         value1.subtract(value2));
      System.out.printf("value1.multiply(value2): %s%n", 
         value1.multiply(value2));
      System.out.printf("value1.multiply(value3): %s%n", 
         value1.multiply(value3));
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
