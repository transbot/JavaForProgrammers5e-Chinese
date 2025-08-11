// 图B.14: ArgumentIndexTest.java
// 使用参数索引重新排序输出

public class ArgumentIndexTest {
   public static void main(String[] args) {
      System.out.printf(
         "未重新排序的参数列表: %s %s %s %s%n", 
         "第一", "第二", "第三", "第四");
      System.out.printf(
         "重新排序后的参数列表: %4$s %3$s %2$s %1$s%n", 
         "第一", "第二", "第三", "第四");
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
