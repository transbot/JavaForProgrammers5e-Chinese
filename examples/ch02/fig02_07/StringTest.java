// 图2.7: StringTest.java
// String类的驱动/测试程序
public class StringTest {
   public static void main(String[] args) {
      String s1 = "生日";
      String s2 = "快乐";
      String s3 = ""; // 创建一个空字符串

      // 显示三个字符串及其长度
      System.out.printf("s1: \"%s\"; 长度: %d%n", s1, s1.length());
      System.out.printf("s2: \"%s\"; 长度: %d%n", s2, s2.length());
      System.out.printf("s3: \"%s\"; 长度: %d%n%n", s3, s3.length());

      // 比较字符串
      System.out.println("字符串比较结果:");
      System.out.printf("s1.equals(\"生日\"): %b%n", s1.equals("生日"));
      System.out.printf("s2.equals(s1): %b%n%n", s2.equals(s1));

      // 测试String的isEmpty方法
      System.out.println("测试s3.isEmpty():");

      if (s3.isEmpty()) {
         System.out.println("s3为空；让我们向s3赋值");
         s3 = s1 + s2; // 连接（拼接）s1和s2，将结果赋给s3
         System.out.printf("s3: \"%s\"; 长度: %d%n%n", s3, s3.length());
      }

      // 测试字符串是否以"生"开头，或者是否以"乐"结尾
      System.out.printf("s1.startsWith(\"生\"): %b%n", 
         s1.startsWith("生"));
      System.out.printf("s2.startsWith(\"生\"): %b%n", 
         s2.startsWith("生"));
      System.out.printf("s1.endsWith(\"乐\"): %b%n", s1.endsWith("乐"));
      System.out.printf("s2.endsWith(\"乐\"): %b%n", s2.endsWith("乐"));
   } // 结束main方法
} // 结束StringTest类


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
