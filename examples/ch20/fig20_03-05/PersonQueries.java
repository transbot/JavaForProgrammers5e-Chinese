// 图20.4: PersonQueries.java
// AddressBook应用程序使用的PreparedStatement
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries {
   // addressbook.db的位置
   private static final String DATABASE_URL = "jdbc:sqlite:" + 
      // 文件就在当前目录中
      Path.of("addressbook.db");

   private Connection connection; // 管理连接
   private PreparedStatement selectAllPeople;       
   private PreparedStatement selectPeopleByLastName;
   private PreparedStatement insertNewPerson;
    
   // 构造函数
   public PersonQueries() {
      try {
         connection = DriverManager.getConnection(DATABASE_URL);

         // 创建查询来选择AddressBook中的所有记录
         selectAllPeople = connection.prepareStatement(             
            "SELECT * FROM addresses ORDER BY last, first");
         
         // 创建查询，选择姓氏以指定字符（汉字）
         // 开头的记录
         selectPeopleByLastName = connection.prepareStatement("""
            SELECT * FROM addresses WHERE last LIKE ? 
            ORDER BY last, first""");                  
         
         // 创建插入操作，向数据库添加一条新记录
         insertNewPerson = connection.prepareStatement("""
            INSERT INTO addresses (first, last, email, phone) 
            VALUES (?, ?, ?, ?)"""); 
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         System.exit(1);
      } 
   } 
   
   // 选择数据库中的所有人
   public List<Person> getAllPeople() {
      // executeQuery返回包含匹配记录的一个ResultSet
      try (ResultSet resultSet = selectAllPeople.executeQuery()) {
         List<Person> results = new ArrayList<>();
         
         while (resultSet.next()) {
            results.add(new Person(
               resultSet.getInt("id"),
               resultSet.getString("first"),
               resultSet.getString("last"),
               resultSet.getString("email"),
               resultSet.getString("phone")));
         } 

         return results;
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();         
      }
      
      return null;
   }
   
   // 选择指定姓氏的人
   public List<Person> getPeopleByLastName(String lastName) {
      try {
         selectPeopleByLastName.setString(1, lastName); // 设置姓氏
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return null;
      }

      // executeQuery返回包含匹配记录的一个ResultSet
      try (ResultSet resultSet = selectPeopleByLastName.executeQuery()) {
         List<Person> results = new ArrayList<>();

         while (resultSet.next()) {
            results.add(new Person(
               resultSet.getInt("id"),
               resultSet.getString("first"),
               resultSet.getString("last"),
               resultSet.getString("email"),
               resultSet.getString("phone")));
         } 

         return results;
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return null;
      } 
   }
   
   // 添加一条新记录
   public int addPerson(String first, String last, 
      String email, String phone) {
      
      // 插入新记录，返回发生更新的行数
      try {
         // 设置参数
         insertNewPerson.setString(1, first);
         insertNewPerson.setString(2, last);
         insertNewPerson.setString(3, email);
         insertNewPerson.setString(4, phone);

         return insertNewPerson.executeUpdate();
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return 0;
      }
   }
   
   // 关闭数据库连接
   public void close() {
      try {
         connection.close();
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

 