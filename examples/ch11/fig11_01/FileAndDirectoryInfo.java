// 图11.1: FileAndDirectoryInfo.java
// 使用File类获取文件和目录信息
import java.io.IOException;          
import java.nio.file.DirectoryStream;
import java.nio.file.Files;          
import java.nio.file.Path;           
import java.util.Scanner;

public class FileAndDirectoryInfo {
   public static void main(String[] args) throws IOException {
      var input = new Scanner(System.in);

      System.out.println("请输入文件或目录名称:");

      // 根据用户输入创建Path对象
      Path path = Path.of(input.nextLine()); 

      if (Files.exists(path)) { // 如果路径存在，就输出相关信息
         // 显示文件或目录信息
         System.out.printf("%n%s存在%n", path.getFileName());
         System.out.printf("%s目录%n", 
            Files.isDirectory(path) ? "是" : "不是");
         System.out.printf("%s绝对路径%n", 
            path.isAbsolute() ? "是" : "不是");
         System.out.printf("最后修改时间: %s%n", 
            Files.getLastModifiedTime(path));
         System.out.printf("大小: %s%n", Files.size(path));
         System.out.printf("路径: %s%n", path);
         System.out.printf("绝对路径: %s%n", path.toAbsolutePath());

         if (Files.isDirectory(path)) { // 如果是目录，就列出内容
            System.out.printf("%n目录内容:%n");
            
            // 用于遍历目录内容的对象
            DirectoryStream<Path> directoryStreamPath =               
               Files.newDirectoryStream(path);                    
   
            for (Path currentPath : directoryStreamPath) {
               System.out.println(currentPath);
            } 
         } 
      } 
      else { // 文件或目录不存在，输出错误消息
         System.out.printf("%s不存在%n", path);
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