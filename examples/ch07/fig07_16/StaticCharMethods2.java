public class StaticCharMethods2 {
// 图7.16: StaticCharMethods2.java
// Character类的静态转换方法：数字与字符的相互转换
import java.util.Scanner;

public class StaticCharMethods2 {
   public static void main(String[] args) {
      var scanner = new Scanner(System.in);

      // 获取基数
      System.out.print("请输入一个基数(2-36): ");
      int radix = scanner.nextInt();

      // 获取用户选择
      System.out.println("""
         请选择操作:
            1 -- 将数字转换为字符
            2 -- 将字符转换为数字""");
      System.out.print("请输入选项: ");
      int choice = scanner.nextInt(); 

      // 处理用户请求
      switch (choice) {
         case 1 -> { // 将数字转换为字符
            System.out.print("请输入一个数字(0-" + (radix-1) + "): ");
            int digit = scanner.nextInt();
            System.out.printf("转换结果: %s%n",
               Character.forDigit(digit, radix));
         }
         case 2 -> { // 将字符转换为数字
            System.out.print("请输入一个字符: ");
            char character = scanner.next().charAt(0);
            System.out.printf("转换结果: %d%n",
               Character.digit(character, radix));
         }
         default -> System.out.println("无效选项!");
      };
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
