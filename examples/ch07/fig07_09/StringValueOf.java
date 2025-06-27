// 图7.9: StringValueOf.java
// String的valueOf方法演示

public class StringValueOf { 
   public static void main(String[] args) {
      char[] charArray = {'邯', '郸', '梦', '啊', '古', '今', '同'};
      boolean booleanValue = true;
      char characterValue = 'Z';
      int integerValue = 7;
      long longValue = 10000000000L; // L后缀表示long类型  
      float floatValue = 2.5f;       // f 后缀表示2.5是float类型
      double doubleValue = 33.333;   // 无后缀，默认double类型
      Object objectRef = "hello";    // 将字符串赋给Object引用

      System.out.printf(
         "字符数组 = %s%n", String.valueOf(charArray));
      System.out.printf("部分字符数组 = %s%n", 
         String.valueOf(charArray, 4, 3));
      System.out.printf(
         "布尔值 = %s%n", String.valueOf(booleanValue));
      System.out.printf(
         "字符 = %s%n", String.valueOf(characterValue));
      System.out.printf("整数 = %s%n", String.valueOf(integerValue));
      System.out.printf("长整数 = %s%n", String.valueOf(longValue)); 
      System.out.printf("浮点数 = %s%n", String.valueOf(floatValue)); 
      System.out.printf(
         "双精度浮点数 = %s%n", String.valueOf(doubleValue)); 
      System.out.printf("对象 = %s%n", String.valueOf(objectRef));
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
