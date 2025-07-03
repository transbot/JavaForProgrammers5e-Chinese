// 图8.4: AccountTest.java
// 使用Account构造函数来初始化
// 每个新Account对象的name。

public class AccountTest {
   public static void main(String[] args) {
      // 创建两个Account对象
      var account1 = new Account("Zhou Jing");
      var account2 = new Account("Logan Brown"); 

      // 显示每个Account对象的初始name值
      System.out.printf("account1中的姓名是: %s%n", account1.getName());
      System.out.printf("account2中的姓名是: %s%n", account2.getName());
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
