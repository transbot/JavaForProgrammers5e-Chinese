// 图8.2: AccountTest.java
// 创建并操作Account对象。
import java.util.Scanner; 

public class BetterAccountTest {
   public static void main(String[] args) {
      // 创建Scanner对象以获取用户输入
      var input = new Scanner(System.in);

      // 新建一个Account对象，并将对它的引用赋给myAccount变量
      var myAccount = new Account();                    

      // 显示初始name值（null）
      System.out.printf("初始姓名为：%s%n%n", myAccount.getName());

      // 提示用户输入姓名并读取
      System.out.println("请输入姓名：");
      String theName = input.nextLine(); // 读取一行文本
      myAccount.setName(theName);        // 将theName存入myAccount对象（改变其状态）
      System.out.println();              // 输出空行

      // 显示存储在myAccount对象中的姓名      
      System.out.printf("myAccount对象中的姓名是：%n%s%n",
         myAccount.getName());
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
