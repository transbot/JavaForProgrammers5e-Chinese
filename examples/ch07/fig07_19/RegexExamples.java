// 图7.19: RegexExamples.java
// 将整个字符串与正则表达式进行匹配
public class RegexExamples {
   public static void main(String[] args) {
      // 完全匹配字面字符模式
      System.out.println("匹配模式：02215");
      System.out.printf("02215: %b; 51220: %b%n%n",
         "02215".matches("02215"), "51220".matches("02215"));

      // 完全匹配五位数字
      System.out.println("匹配模式：\\d{5}");
      System.out.printf("02215: %b; 9876: %b%n%n",
         "02215".matches("\\d{5}"), "9876".matches("\\d{5}"));

      // 匹配以大写字母开头的单词
      System.out.println("匹配模式：[A-Z][a-z]*");
      System.out.printf("Angel: %b; tina: %b%n%n",
         "Angel".matches("[A-Z][a-z]*"), "tina".matches("[A-Z][a-z]*"));

      // 匹配任意非小写字母的字符
      System.out.println("匹配模式：[^a-z]");
      System.out.printf("A: %b; a: %b%n%n",
         "A".matches("[^a-z]"), "a".matches("[^a-z]"));

      // 在自定义字符类中匹配元字符字面值
      System.out.println("匹配模式：[*+$]");
      System.out.printf("*: %b; !: %b%n%n",
         "*".matches("[*+$]"), "!".matches("[*+$]"));

      // 匹配大写字母后跟至少一个小写字母
      System.out.println("匹配模式：[A-Z][a-z]+");
      System.out.printf("Angel: %b; T: %b%n%n",
         "Angel".matches("[A-Z][a-z]+"), "T".matches("[A-Z][a-z]+"));

      // 匹配子表达式出现零次或一次
      System.out.println("匹配模式：labell?ed");
      System.out.printf("labelled: %b; labeled: %b; labellled: %b%n%n",
         "labelled".matches("labell?ed"), "labeled".matches("labell?ed"),
         "labellled".matches("labell?ed"));

      // 匹配子表达式出现n(3)次或更多次
      System.out.println("匹配模式：\\d{3,}");
      System.out.printf("123: %b; 1234567890: %b; 12: %b%n%n",
         "123".matches("\\d{3,}"), "1234567890".matches("\\d{3,}"),
         "12".matches("\\d{3,}"));

      // 匹配子表达式出现n到m次(包含3~6次)
      System.out.println("匹配模式：\\d{3,6}");
      System.out.printf("123: %b; 123456: %b; 1234567: %b; 12: %b%n",
         "123".matches("\\d{3,6}"), "123456".matches("\\d{3,6}"),
         "1234567".matches("\\d{3,6}"), "12".matches("\\d{3,6}"));
   }
}

/*
 **************************************************************************
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
 **************************************************************************
*/

