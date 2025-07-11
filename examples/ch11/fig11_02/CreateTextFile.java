// 图11.2: CreateTextFile.java
// 使用Formatter类将数据写入顺序文本文件
import java.util.Formatter;               
import java.nio.file.Path;
import java.util.List;

// 表示账户的record类
record Account(int accountNumber, String name, double balance) {}

public class CreateTextFile {
   public static void main(String[] args) {
      // 要写入文本文件的账户数据
      List<Account> accounts = List.of(
         new Account(100, "张无忌", 24.98),
         new Account(200, "赵敏", 345.67),
         new Account(300, "周芷若", 0.00),
         new Account(400, "殷离", -42.16),
         new Account(500, "小昭", 224.62)
      );

      // 用户Documents文件夹中的clients.txt文件路径
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.txt");

      // 打开clients.txt，输出数据到文件，然后关闭文件
      try (var output = new Formatter(filePath.toString())) {
         // 将每个Account输出到文件
         for (var account : accounts) {
            output.format("%d %s %.2f%n", account.accountNumber(), 
               account.name(), account.balance());
         } 

         System.out.printf(
            "文本文件已创建于: %s%n", filePath.toAbsolutePath());
      }
      catch (Exception e) {
         System.err.printf(
            "写入文本文件时出错: %s%n", e.getMessage());
      } 
   } 
}



/*************************************************************************
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