// 图11.4: CreateJSONFile.java
// 使用Jackson开源库将数据写入JSON文件
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// 表示账户的record类
record Account(int accountNumber, String name, double balance) {}

public class CreateJSONFile {
   public static void main(String[] args) {
      // 要写入JSON的账户数据
      List<Account> accounts = List.of(
         new Account(100, "张无忌", 24.98),
         new Account(200, "赵敏", 345.67),
         new Account(300, "周芷若", 0.00),
         new Account(400, "殷离", -42.16),
         new Account(500, "小昭", 224.62)
      );

      // 用户Documents文件夹中的clients.json文件路径      
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.json");

      var mapper = new ObjectMapper(); // 执行序列化

      try {
         // 将账户数据写入JSON文件
         mapper.writeValue(filePath.toFile(), accounts);
         System.out.printf(
            "JSON文件已创建于: %s%n", filePath.toAbsolutePath());
      } 
      catch (IOException e) {
         System.err.printf(
            "写入JSON文件时出错: %s%n", e.getMessage());
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