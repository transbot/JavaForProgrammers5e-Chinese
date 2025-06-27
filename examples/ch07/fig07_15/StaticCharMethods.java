// 图7.15: StaticCharMethods.java
// 用于测试字符和转换大小写的Character静态方法。
import java.util.Scanner;

public class StaticCharMethods {
   public static void main(String[] args) {
      var scanner = new Scanner(System.in); // 创建Scanner对象以获取输入
      System.out.println("请输入一个字符并按Enter键:");
      String input = scanner.next(); 
      char c = input.charAt(0); // 获取输入的字符

      // 显示字符信息
      System.out.printf("是否为已定义字符: %b%n", Character.isDefined(c));
      System.out.printf("是否为数字: %b%n", Character.isDigit(c));
      System.out.printf("是否可作为Java标识符的首字符: %b%n",
         Character.isJavaIdentifierStart(c));
      System.out.printf("是否可作为Java标识符的一部分: %b%n",
         Character.isJavaIdentifierPart(c));
      System.out.printf("是否为字母: %b%n", Character.isLetter(c));
      System.out.printf(
         "是否为字母或数字: %b%n", Character.isLetterOrDigit(c));
      System.out.printf(
         "是否为小写字母: %b%n", Character.isLowerCase(c));
      System.out.printf(
         "是否为大写字母: %b%n", Character.isUpperCase(c));
      System.out.printf(
         "转换为大写: %c%n", Character.toUpperCase(c));
      System.out.printf(
         "转换为小写: %c%n", Character.toLowerCase(c));
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
