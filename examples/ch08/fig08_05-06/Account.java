// 图8.5: Account.java
// Account类包含BigDecimal类型的实例变量balance，
// 以及执行数据校验的构造函数和存款方法。
import java.math.BigDecimal;
 
public class Account {
   private String name; // 实例变量   
   private BigDecimal balance = BigDecimal.ZERO; // 实例变量

   // 接收两个参数的Account构造函数
   public Account(String name, BigDecimal balance) {
      this.name = name; // 将参数name的值赋给实例变量name

      // 验证余额是否大于0；如果不是，
      // 那么实例变量balance保持其默认初始值0。
      if (balance.compareTo(BigDecimal.ZERO) > 0) { // 余额是否有效？
         this.balance = balance; // 将其赋给实例变量balance
      }
   } 

   // 仅将有效金额存入余额的方法
   public void deposit(BigDecimal amount) {                      
      if (amount.compareTo(BigDecimal.ZERO) > 0) { // 金额是否有效？ 
         balance = balance.add(amount); // 将其加到余额上
      }
   }

   // 返回账户余额的方法
   public BigDecimal getBalance() {         
      return balance;                   
   }                                    

   // 设置姓名的方法
   public void setName(String name) {
      this.name = name; 
   } 

   // 返回姓名的方法
   public String getName() {
      return name;
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
