// 图11.3: ReadTextFile.java
// 使用Scanner读取文本文件
import java.nio.file.Path;
import java.util.Scanner;

public class ReadTextFile {
   public static void main(String[] args) {
      // 用户Documents文件夹中的clients.txt路径
      Path filePath = Path.of(System.getProperty("user.home"), 
         "Documents", "clients.txt");

      // 打开clients.txt，读取内容，然后关闭文件
      try (var input = new Scanner(filePath)) {         
         System.out.printf("%-8s%-10s%-7s%n", 
            "账户", "姓名", "余额");

         // 从文件读取记录
         while (input.hasNext()) { // 当还有更多内容可读时
            // 显示记录内容
            System.out.printf("%-10d%-10s%-10.2f%n", 
               input.nextInt(), input.next(), input.nextDouble());
         }
      } 
      catch (Exception e) {
         System.err.printf(
            "读取文件时出错: %s%n", e.getMessage());
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