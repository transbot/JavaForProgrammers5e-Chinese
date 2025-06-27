// 图7.8: StringMiscellaneous2.java
// String的replace、toLowerCase、toUpperCase、trim和toCharArray方法

public class StringMiscellaneous2 {
   public static void main(String[] args) {
      String s1 = "hello";
      String s2 = "GOODBYE";
      String s3 = "   我前后都有空白   ";

      System.out.printf("s1: \"%s\"%ns2: \"%s\"%ns3: \"%s\"", s1, s2, s3);

      // 测试replace方法      
      System.out.printf(
         "%n%n将s1中的'l'替换为'L': %s%n%n", s1.replace('l', 'L'));

      // 测试toLowerCase和toUpperCase方法
      System.out.printf("s1.toUpperCase() = %s%n", s1.toUpperCase());
      System.out.printf("s2.toLowerCase() = %s%n%n", s2.toLowerCase());

      // 测试strip方法（去除首尾空白）
      System.out.printf("去除首尾空白后的s3 = \"%s\"%n%n", s3.strip());

      // 测试toCharArray方法
      char[] charArray = s1.toCharArray();
      System.out.print("s1转换为字符数组 = ");

      for (char character : charArray) {
         System.out.printf("%c ", character);
      } 

      System.out.println();
   } 
}

/**************************************************************************
 * (C) Copyright 1992-2025  by Deitel & Associates, Inc. and               *
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
