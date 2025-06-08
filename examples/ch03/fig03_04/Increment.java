// 图3.4: Increment.java
// 前缀递增和后缀递增操作符

public class Increment {
   public static void main(String[] args) {
      // 演示后缀递增操作符
      int c = 5; 
      System.out.printf("后缀递增之前的c: %d%n", c); // 打印5
      System.out.printf("对c进行后缀递增: %d%n", c++); // 打印5
      System.out.printf("后缀递增之后的c: %d%n", c); // 打印6  

      System.out.println(); // skip a line

      // 演示前缀递增操作符
      c = 5; 
      System.out.printf("前缀递增之前的c: %d%n", c); // 打印5
      System.out.printf("对c进行前缀递增: %d%n", ++c); // 打印6
      System.out.printf("前缀递增之后的c: %d%n", c); // 打印6  
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
