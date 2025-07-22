// 图16.9: FileChooserTestController.java
// 显示所选文件或文件夹的信息
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class FileChooserTestController {
   @FXML private BorderPane borderPane;
   @FXML private Button selectFileButton;
   @FXML private Button selectDirectoryButton;
   @FXML private TextArea textArea;

   // 处理selectFileButton的事件
   @FXML
   private void selectFileButtonPressed(ActionEvent e) {
      // 配置允许选择文件的对话框
      FileChooser fileChooser = new FileChooser();               
      fileChooser.setTitle("选择文件");

      // 显示应用程序启动时所在文件夹中的文件
      fileChooser.setInitialDirectory(new File(".")); 

      // 显示文件选择器
      File file = fileChooser.showOpenDialog(
         borderPane.getScene().getWindow());               

      // 处理选中的路径或显示消息
      if (file != null) {
         analyzePath(file.toPath());            
      }
      else {
         textArea.setText("选择文件或目录");
      }
   } 

   // 处理selectDirectoryButton的事件
   @FXML
   private void selectDirectoryButtonPressed(ActionEvent e) {
      // 配置允许选择目录的对话框
      DirectoryChooser directoryChooser = new DirectoryChooser();               
      directoryChooser.setTitle("选择目录");

      // 显示应用程序启动所在文件夹
      directoryChooser.setInitialDirectory(new File(".")); 

      // 显示目录选择器
      File file = directoryChooser.showDialog(
         borderPane.getScene().getWindow());               

      // 处理选中的路径或显示消息
      if (file != null) {
         analyzePath(file.toPath());            
      }
      else {
         textArea.setText("选择文件或目录");
      }
   } 

   // 显示用户指定的文件或目录信息
   public void analyzePath(Path path) {
      try {
         // 如果文件或目录存在，则显示其信息
         if (path != null && Files.exists(path)) {
            // 收集文件(或目录)信息
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("%s:%n", path.getFileName()));
            builder.append(String.format("%s目录%n", 
               Files.isDirectory(path) ? "是" : "不是"));
            builder.append(String.format("%s绝对路径%n", 
               path.isAbsolute() ? "是" : "不是"));
            builder.append(String.format("最后修改时间: %s%n", 
               Files.getLastModifiedTime(path)));
            builder.append(String.format("大小: %s%n", Files.size(path)));
            builder.append(String.format("路径: %s%n", path));
            builder.append(String.format("绝对路径: %s%n", 
               path.toAbsolutePath()));

            if (Files.isDirectory(path)) { // 输出目录内容
               builder.append(String.format("%n目录内容:%n"));
               
               // 用于遍历目录内容的对象
               DirectoryStream<Path> directoryStream = 
                  Files.newDirectoryStream(path);
      
               for (Path p : directoryStream) {
                  builder.append(String.format("%s%n", p));
               }
            }

            // 显示文件或目录信息
            textArea.setText(builder.toString()); 
         } 
         else { // 路径不存在
            textArea.setText("路径不存在");
         }   
      }
      catch (IOException ioException) {
         textArea.setText(ioException.toString());
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
