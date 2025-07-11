// 图11.8: CreateCSVFile.java
// 使用Jackson开源库将数据写入CSV文件
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// 表示账户的record类
record Account(int accountNumber, String name, double balance) {}

public class CreateCSVFile {
   public static void main(String[] args) {
      // 要写入的账户数据
      List<Account> accounts = List.of(
         new Account(100, "张无忌", 24.98),
         new Account(200, "赵敏", 345.67),
         new Account(300, "周芷若", 0.00),
         new Account(400, "殷离", -42.16),
         new Account(500, "小昭", 224.62)
      );

      // 用户Documents文件夹中的clients.csv文件路径
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.csv");

      // 创建Jackson CsvMapper和Schema对象
      var mapper = new CsvMapper(); 
      CsvSchema schema = 
         mapper.schemaFor(Account.class) // 确定CSV文件中的字段
            .withHeader(); // clients.csv的第一行是字段名

      try {
         // ObjectWriter使用指定schema将数据写入CSV文件
         ObjectWriter writer = mapper.writer(schema);
         writer.writeValue(filePath.toFile(), accounts);
         System.out.printf(
            "CSV文件已创建于: %s%n", filePath.toAbsolutePath());
      } 
      catch (IOException e) {
         System.err.printf(
            "写入CSV文件时出错: %s%n", e.getMessage());
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