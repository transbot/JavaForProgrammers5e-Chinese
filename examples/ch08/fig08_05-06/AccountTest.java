// 图8.6: AccountTest.java
// 使用Account对象进行浮点数的输入和输出操作
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class AccountTest {
   public static void main(String[] args) {
      var account1 = new Account("Zhou Jing", new BigDecimal("50.00"));
      var account2 = new Account("Logan Brown", new BigDecimal("-7.53"));

      // 显示每个对象的初始余额
      System.out.printf("%s的余额: $%s%n", account1.getName(), 
         account1.getBalance().setScale(2, RoundingMode.HALF_EVEN));
      System.out.printf("%s的余额: $%s%n%n", account2.getName(), 
         account2.getBalance().setScale(2, RoundingMode.HALF_EVEN));
      
      // 创建Scanner对象以获取用户输入
      var input = new Scanner(System.in);

      System.out.print("请输入account1的存款金额: "); // 提示用户输入
      var depositAmount = input.nextBigDecimal(); // 获取用户输入
      System.out.printf("%n正在将%s加到account1的余额上%n%n", 
         depositAmount.setScale(2, RoundingMode.HALF_EVEN));
      account1.deposit(depositAmount); // 向account1存款

      // 显示当前余额
      System.out.printf("%s的余额: $%s%n", account1.getName(), 
         account1.getBalance().setScale(2, RoundingMode.HALF_EVEN));
      System.out.printf("%s的余额: $%s%n%n", account2.getName(), 
         account2.getBalance().setScale(2, RoundingMode.HALF_EVEN));

      System.out.print("请输入account2的存款金额: "); // 提示用户输入
      depositAmount = input.nextBigDecimal(); // 获取用户输入
      System.out.printf("%n正在将%s加到account2的余额上%n%n", 
         depositAmount.setScale(2, RoundingMode.HALF_EVEN));
      account2.deposit(depositAmount); // 向account2存款

      // 显示最终余额
      System.out.printf("%s的余额: $%s%n", account1.getName(), 
         account1.getBalance().setScale(2, RoundingMode.HALF_EVEN));
      System.out.printf("%s的余额: $%s%n%n", account2.getName(), 
         account2.getBalance().setScale(2, RoundingMode.HALF_EVEN));
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
