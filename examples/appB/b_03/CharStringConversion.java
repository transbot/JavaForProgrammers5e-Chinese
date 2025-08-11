// 图B.3: CharStringConversion.java
// 使用字符和字符串转换字符
public class CharStringConversion {
   public static void main(String[] args) {
      char character = 'A';  // 初始化char变量
      String string = "This is also a string";  // 初始化String变量
      Integer integer = 1234;  // 初始化Integer变量发生自动装箱

      System.out.printf("%c%n", character);
      System.out.printf("%s%n", "This is a string");
      System.out.printf("%s%n", string);
      System.out.printf("%S%n", string);
      System.out.printf("%s%n", integer); // 隐式调用toString
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
