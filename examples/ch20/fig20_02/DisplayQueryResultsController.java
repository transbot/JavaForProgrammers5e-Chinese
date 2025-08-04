// 图20.2: DisplayQueryResultsController.java
// DisplayQueryResults应用程序的控制器
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Path;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class DisplayQueryResultsController {
   @FXML private TextArea queryTextArea;  // SQL查询输入文本区域
   @FXML private TableView<ObservableList<Object>> tableView;  // 结果显示表格视图

   // books.db数据库文件位置
   private static final String DATABASE_URL = "jdbc:sqlite:" + 
      // books.db位于当前目录（..）的上一级目录（即examples/ch20）
      Path.of("..", "books.db"); 

   // 默认查询：从authors表中检索所有数据
   private static final String DEFAULT_QUERY = "SELECT * FROM authors";

   private Connection connection;  // 数据库连接对象

   // initialize方法：显示默认查询，连接数据库并执行默认查询
   @FXML
   public void initialize() {
      queryTextArea.setText(DEFAULT_QUERY);  // 在文本区显示默认SQL查询

      try {         
         connection = DriverManager.getConnection(DATABASE_URL); // 建立数据库连接        
         executeQuery(DEFAULT_QUERY); // 执行默认查询
      } 
      catch (SQLException sqlException) {         
         displayAlert(AlertType.ERROR, "数据库错误", 
            sqlException.getMessage());
         System.exit(1); // 终止应用程序
      }
   }

   // “提交查询按钮”事件处理：执行用户输入的SQL查询
   @FXML
   void submitQueryButtonPressed(ActionEvent event) {
      executeQuery(queryTextArea.getText());  // 获取并执行文本区中的SQL查询
   }

   // 执行SQL查询并更新ObservableList<Object>
   // TableView使用后者填充它的行和列
   private void executeQuery(String query) {
      try (Statement statement = connection.createStatement();    // 创建SQL语句对象
           ResultSet resultSet = statement.executeQuery(query)) { // 执行查询来获取结果集
         tableView.getColumns().clear(); // 清除TableView当前列配置

         // 为当前ResultSet创建二维ObservableList
         ObservableList<ObservableList<Object>> data = 
            FXCollections.observableArrayList();

         // 使用ResultSetMetaData获取列标题
         // 并设置TableView的列
         ResultSetMetaData metaData = resultSet.getMetaData();
         int columnCount = metaData.getColumnCount();  // 获取结果集的列数

         for (int i = 1; i <= columnCount; i++) { // 为结果集的每一列创建表格列
            // 创建新表格列，使用元数据中的列名
            var column = new TableColumn<ObservableList<Object>, Object>(
               metaData.getColumnName(i));

            // 将列映射到每行数据中的对应索引
            final int columnIndex = i - 1;
            column.setCellValueFactory(param -> 
               new SimpleObjectProperty<>(
                  param.getValue().get(columnIndex)));

            // 自动调整列宽：等分表格宽度
            column.prefWidthProperty().bind(
               tableView.widthProperty().divide(columnCount));

            // 将列添加到TableView
            tableView.getColumns().add(column);
         }

         // 从ResultSet填充行数据
         while (resultSet.next()) {
            // 新建一个ObservableList来表示一行数据
            ObservableList<Object> row = 
               FXCollections.observableArrayList();

            // 用ResultSet中的数据填充行
            for (int i = 1; i <= columnCount; i++) {
               row.add(resultSet.getObject(i));  // 添加列值到行
            }

            // 将行添加到数据列表
            data.add(row);
         }

         // 将ObservableList设置为TableView的数据源
         tableView.setItems(data);
      } 
      catch (SQLException sqlException) {         
         displayAlert(AlertType.ERROR, "查询错误", // 查询错误处理
            sqlException.getMessage());
      }
   }

   // 显示一个Alert对话框
   private void displayAlert(
      AlertType type, String title, String message) {
      Alert alert = new Alert(type);  // 创建指定类型的警报
      alert.setTitle(title);          // 设置警报标题
      alert.setContentText(message);  // 设置警报内容
      alert.showAndWait();            // 显示警报并等待用户响应
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
