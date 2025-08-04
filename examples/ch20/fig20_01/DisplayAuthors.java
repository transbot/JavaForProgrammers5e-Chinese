// 图20.1: DisplayAuthors.java
// 显示authors表的内容
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DisplayAuthors {
   public static void main(String args[]) {
      // 指定books.db的位置
      // 在本地文件系统中，它应该位于当前目录（..）的上一级目录（即examples/ch20）
      Path dbPath = Path.of("..", "books.db");
      
      final String url = "jdbc:sqlite:" + dbPath.toUri();
      final String query = "SELECT id, first, last FROM authors";

      // 使用try-with-resources语句连接并查询数据库
      try (
         Connection connection = DriverManager.getConnection(url);
         Statement statement = connection.createStatement();       
         ResultSet resultSet = statement.executeQuery(query)) {
      
         // 获取ResultSet的元数据
         ResultSetMetaData metaData = resultSet.getMetaData();
         int numberOfColumns = metaData.getColumnCount();     
         
         System.out.printf("books数据库的authors表的内容:%n%n");

         // 显示ResultSet中的列名
         for (int i = 1; i <= numberOfColumns; i++) {
            System.out.printf("%-11s", metaData.getColumnName(i));
         }
         System.out.println();
         
         // 显示查询结果
         while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
               System.out.printf("%-11s", resultSet.getObject(i));
            }
            System.out.println();
         } 
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
      }                                                   
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

 