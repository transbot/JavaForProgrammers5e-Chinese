// 图11.5: ReadJSONFile.java
// 使用Jackson开源库从JSON文件读取数据
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// 表示账户的record类
record Account(int accountNumber, String name, double balance) {}

public class ReadJSONFile {
   public static void main(String[] args) {
      // 用户Documents文件夹中的clients.json文件路径
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.json");

      var mapper = new ObjectMapper(); // 执行反序列化

      try {
         // 从JSON文件读取账户数据
         List<Account> accounts = mapper.readValue(
            filePath.toFile(), new TypeReference<List<Account>>() {});

         // 显示账户数据
         System.out.printf(
            "%-8s%-10s%-7s%n", "账户", "姓名", "余额");

         for (var account : accounts) {
            System.out.printf("%-10d%-10s%-10.2f%n", 
               account.accountNumber(), account.name(), 
               account.balance());
         }
      } 
      catch (IOException e) {
         System.err.printf(
            "读取JSON文件出错: %s%n", e.getMessage());
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
