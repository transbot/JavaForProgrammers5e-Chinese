// 图11.9: ReadCSVFile.java
// 使用Jackson开源库从CSV文件读取数据
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// 表示账户的record类
record Account(int accountNumber, String name, double balance) {}

public class ReadCSVFile {
   public static void main(String[] args) {
      // 用户Documents文件夹中的clients.csv路径
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.csv");

      var mapper = new CsvMapper(); // 读取CSV记录

      // 指定Jackson将每个CSV列映射到
      // record类Account的实例变量
      CsvSchema schema = 
         mapper.schemaFor(Account.class) // 字段映射到Account对象
               .withHeader(); // 第一行文本是字段名称

      // 读取CSV文件
      try {
         // MappingIterator提供将记录作为Account对象访问的功能
         MappingIterator<Account> iterator = 
            mapper.readerFor(Account.class).with(schema).readValues(
               filePath.toFile());

         List<Account> accounts = iterator.readAll();

         // 显示账户信息 
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
            "读取CSV文件时出错: %s%n", e.getMessage());
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
