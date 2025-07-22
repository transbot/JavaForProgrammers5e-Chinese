// 图16.7: ImageTextCell.java
// 自定义ListView单元格工厂同时显示了图像和文本
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ImageTextCell extends ListCell<Book> {
   private VBox vbox = new VBox(8.0); // 控件间8像素间距
   private ImageView thumbImageView = new ImageView(); // 初始为空
   private Label label = new Label();

   // 构造函数负责配置VBox、ImageView和Label
   public ImageTextCell() {
      vbox.setAlignment(Pos.CENTER); // VBox内容水平居中

      thumbImageView.setPreserveRatio(true);
      thumbImageView.setFitHeight(100.0); // 缩略图高度100像素
      vbox.getChildren().add(thumbImageView); // 添加到VBox

      label.setWrapText(true); // 文本过宽时自动换行
      label.setTextAlignment(TextAlignment.CENTER); // 文本居中
      vbox.getChildren().add(label); // 添加到VBox

      setPrefWidth(USE_PREF_SIZE); // 使用首选宽度作为单元格宽度
   }

   // 用于配置每个自定义ListView单元格
   @Override 
   protected void updateItem(Book item, boolean empty) {
      // 必须调用以确保单元格正确显示
      super.updateItem(item, empty);

      if (empty || item == null) {
         setGraphic(null); // 不显示任何内容
      }
      else {
         // 设置ImageView的缩略图
         thumbImageView.setImage(new Image(item.thumbImage()));
         label.setText(item.title()); // 配置Label文本
         setGraphic(vbox); // 将自定义布局附加到ListView单元格
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
