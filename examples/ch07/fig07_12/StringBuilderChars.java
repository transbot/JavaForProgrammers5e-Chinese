// 图7.12: StringBuilderChars.java
// StringBuilder的charAt、setCharAt、getChars和reverse方法

public class StringBuilderChars {
   public static void main(String[] args) {
      var buffer = new StringBuilder("hello there");

      System.out.printf("buffer = %s%n", buffer.toString());
      System.out.printf("索引0处的字符: %s%n索引4处的字符: %s%n%n", 
         buffer.charAt(0), buffer.charAt(4));

      char[] charArray = new char[buffer.length()];
      buffer.getChars(0, buffer.length(), charArray, 0);
      System.out.print("字符数组内容: ");

      for (char character : charArray) {
         System.out.print(character);
      }

      buffer.setCharAt(0, 'H');
      buffer.setCharAt(6, 'T');
      System.out.printf("%n%n修改后的buffer = %s", buffer.toString());

      buffer.reverse();
      System.out.printf("%n%n反转后的buffer = %s%n", buffer.toString());
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
