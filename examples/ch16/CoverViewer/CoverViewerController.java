// 图16.6: CoverViewerController.java
// “封面查看器”应用程序的控制器
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CoverViewerController {
   // 用于与GUI交互的实例变量
   @FXML private ListView<Book> booksListView;
   @FXML private ImageView coverImageView;

   // 存储Book对象列表
   private final ObservableList<Book> books = 
      FXCollections.observableArrayList();

   // 初始化控制器
   public void initialize() {
      // 填充ObservableList<Book>的内容
      books.add(new Book("Visual C#从入门到精通", 
         "/images/small/vcsharp.jpg", "/images/large/vcsharp.jpg"));
      books.add(new Book("学习C++20中文版",
         "/images/small/cpp20.jpg", "/images/large/cpp20.jpg"));
      books.add(new Book("CLR via C#",  
         "/images/small/clrviacsharp.jpg", "/images/large/clrviacsharp.jpg"));
      books.add(new Book("机器学习与人工智能实战",  
         "/images/small/appliedML.jpg", "/images/large/appliedML.jpg"));
      books.add(new Book("Windows核心编程", 
         "/images/small/windowsviacpp.jpg", "/images/large/windowsviacpp.jpg"));
      books.add(new Book("C# 12.0本质论", 
         "/images/small/EssentialCSharp.jpg", "/images/large/EssentialCSharp.jpg"));
      books.add(new Book("高质量需求", 
         "/images/small/SRE.jpg", "/images/large/SRE.jpg"));
      books.add(new Book("大模型编程实践与提示工程", 
         "/images/small/ProgrammingLLM.jpg", "/images/large/ProgrammingLLM.jpg"));
      booksListView.setItems(books); // 将booksListView绑定到books

      // 当ListView中的选择发生改变时，在ImageView中显示封面大图
      booksListView.getSelectionModel().selectedItemProperty().
         addListener(
            (ov, oldValue, newValue) -> {                        
               coverImageView.setImage(
                  new Image(newValue.largeImage()));
            }
         );                                                                  
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
