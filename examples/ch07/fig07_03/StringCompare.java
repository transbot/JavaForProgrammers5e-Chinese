// 图7.3: StringCompare.java
// 比较字符串和子串

public class StringCompare {
   public static void main(String[] args) {
      String s1 = new String("hello"); // s1是"hello"的一个副本
      String s2 = "goodbye";
      String s3 = "Happy Birthday";
      String s4 = "happy birthday";

      System.out.printf(
         "s1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n%n", s1, s2, s3, s4);

      // 测试相等性
      if (s1.equals("hello")) {  // true
         System.out.println("s1等于\"hello\"");
      }
      else {
         System.out.println("s1不等于\"hello\""); 
      }

      // 用==测试相等性
      if (s1 == "hello") { // false，两者不引用同一个对象
         System.out.println("s1与\"hello\"是同一个对象");
      }
      else {
         System.out.println("s1与\"hello\"不是同一个对象");
      }

      // 测试相等性（忽略大小写）
      if (s3.equalsIgnoreCase(s4)) { // true
         System.out.printf("\"%s\"在忽略大小写后等于\"%s\"%n", s3, s4);
      }
      else {
         System.out.println("s3不等于s4");
      }

      // 测试compareTo
      System.out.printf(
         "%ns1.compareTo(s2)的结果是%d", s1.compareTo(s2));
      System.out.printf(
         "%ns2.compareTo(s1)的结果是%d", s2.compareTo(s1));
      System.out.printf(
         "%ns1.compareTo(s1)的结果是%d", s1.compareTo(s1));
      System.out.printf(
         "%ns3.compareTo(s4)的结果是%d", s3.compareTo(s4));
      System.out.printf(
         "%ns4.compareTo(s3)的结果是%d%n%n", s4.compareTo(s3));

      // 测试regionMatches（大小写敏感）
      if (s3.regionMatches(0, s4, 0, 5)) {
         System.out.println("s3和s4的前5个字符匹配");
      }
      else {
         System.out.println(
            "s3和s4的前5个字符不匹配");
      }

      // 测试regionMatches（忽略大小写）
      if (s3.regionMatches(true, 0, s4, 0, 5)) {
         System.out.println(
            "在忽略大小写的情况下，s3和s4的前5个字符匹配\n");
      }
      else {
         System.out.println(
            "在忽略大小写的情况下，s3和s4的前5个字符也不匹配\n");
      }

      // 测试字符串是否只包含空白字符
      System.out.printf("\" \\t\\n\"是空白字符串吗？: %b%n", " \t\n".isBlank());
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
