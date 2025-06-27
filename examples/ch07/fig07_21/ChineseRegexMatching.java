// 图7.21: ChineseRegexMatching.java
// 使用Pattern和Matcher类处理中英文文本
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ChineseRegexMatching {
   public static void main(String[] args) {
      // 简单中文匹配
      String s1 = "Java编程非常有趣";
      System.out.printf("s1: %s%n%n", s1);
      System.out.println("在s1中查找:");

      Pattern pattern1 = Pattern.compile("编程");
      Matcher matcher1 = pattern1.matcher(s1);
      boolean found1 = matcher1.find();

      Pattern pattern2 = Pattern.compile("有趣");
      Matcher matcher2 = pattern2.matcher(s1);
      boolean found2 = matcher2.find();

      Pattern pattern3 = Pattern.compile("Python");
      Matcher matcher3 = pattern3.matcher(s1);
      boolean found3 = matcher3.find();

      System.out.printf("编程: %b; 有趣: %b; Python: %b%n%n",
         found1, found2, found3);

      // 英文姓名匹配（不区分大小写） - 还原原始逻辑
      String s2 = "GABRIELA ALVAREZ";
      System.out.printf("s2: %s%n%n", s2);
      System.out.println("在s2中不区分大小写查找Gabriela:");

      Pattern pattern4 = 
         Pattern.compile("Gabriela", Pattern.CASE_INSENSITIVE);
      Matcher matcher4 = pattern4.matcher(s2);

      if (matcher4.find()) {
         System.out.printf("找到Gabriela%n");
         System.out.printf("匹配文本: %s%n%n", matcher4.group());
      } 
      else {
         System.out.printf("未找到Gabriela%n");
      }

      // 提取所有电话号码
      String contact = 
         "联系人：张无忌，手机：13800138000，座机：0719-55551122";
      Pattern phonePattern = Pattern.compile(
         "(1[3-9]\\d{9}" +              // 11位手机号（13800138000）
         "|0\\d{2,3}-[1-9]\\d{6,7}" +   // 3~4位区号座机（010-12345678）
         "|(?:400|800)-\\d{3}-\\d{4}" + // 400/800客服号（400-123-4567）
         "|(?:95|96)\\d{3,4}" +         // 95/96服务号（95555/96110）
         "|1\\d{4})"                    // 5位政务服务热线（12345）
      );
      Matcher phoneMatcher = phonePattern.matcher(contact);

      System.out.printf("从以下联系方式中提取电话号码:%n%s%n", contact);
      while (phoneMatcher.find()) {
         System.out.printf("   %s%n", phoneMatcher.group());
      }
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