// 图7.2: StringMiscellaneous.java
// 该程序演示了String类的length、
// charAt和getChars方法

public class StringMiscellaneous {
   public static void main(String[] args) {
      String s1 = "山魈让她等一等 星夜兼程的情人";
      char[] charArray = new char[7]; // 调整为7个字符的空间

      System.out.printf("s1: %s", s1);

      // 测试length方法
      System.out.printf("%n字符串s1的长度: %d", s1.length());

      // 使用charAt遍历s1的字符并显示反转结果
      System.out.printf("%n反转后的字符串: ");

      for (int count = s1.length() - 1; count >= 0; --count) {
         System.out.printf("%c ", s1.charAt(count));
      }

      // 从s1复制字符到charArray（提取"山魈让她等一等"）
      s1.getChars(0, 7, charArray, 0); // 提取前7个字符
      System.out.printf("%n字符数组内容: ");

      for (char character : charArray) {
         System.out.print(character);
      }

      System.out.println();
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
