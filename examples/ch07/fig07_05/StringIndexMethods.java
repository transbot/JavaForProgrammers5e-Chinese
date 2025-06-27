// 图7.5: StringIndexMethods.java
// 使用字符串查找方法indexOf和lastIndexOf

public class StringIndexMethods {
   public static void main(String[] args) {
      String numbers = "零壹贰叁肆伍陆柒捌玖拾佰仟零壹贰叁肆伍陆柒捌玖拾佰仟";

      // 使用indexOf方法查找字符
      System.out.printf(
         "'贰'位于索引位置%d%n", numbers.indexOf('贰'));
      System.out.printf(
         "'零'从索引1开始查找，位于索引位置%d%n", numbers.indexOf('零', 1));
      System.out.printf(
         "'$'位于索引位置%d%n%n", numbers.indexOf('$'));

      // 使用lastIndexOf方法查找字符
      System.out.printf("最后一个'贰'位于索引位置%d%n",
         numbers.lastIndexOf('贰'));
      System.out.printf("从索引15开始反向查找，最后一个'零'位于索引位置%d%n",
         numbers.lastIndexOf('零', 15));
      System.out.printf("最后一个'$'位于索引位置%d%n%n",
         numbers.lastIndexOf('$'));
     
      // 使用indexOf方法查找子串
      System.out.printf("\"壹贰叁\"位于索引位置%d%n", 
         numbers.indexOf("壹贰叁"));
      System.out.printf("\"壹贰叁\"从索引10开始查找，位于索引位置%d%n",
         numbers.indexOf("壹贰叁", 10));
      System.out.printf("\"佰仟万\"位于索引位置%d%n%n",
         numbers.indexOf("佰仟万"));

      // 使用lastIndexOf方法查找子串
      System.out.printf("最后一个\"壹贰叁\"位于索引位置%d%n",
         numbers.lastIndexOf("壹贰叁"));
      System.out.printf("从索引15开始反向查找，最后一个\"壹贰叁\"位于索引位置%d%n",
         numbers.lastIndexOf("壹贰叁", 15));
      System.out.printf("最后一个\"佰仟万\"位于索引位置%d%n",
         numbers.lastIndexOf("佰仟万"));
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
