// 图15.1: TipCalculator.java
// 加载并显示“小费计算器”GUI的主应用程序类
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {
   @Override
   public void start(Stage stage) throws Exception {
      Parent root = 
         FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

      Scene scene = new Scene(root); // 将场景图附加到场景
      stage.setTitle("小费计算器");   // 在窗口标题栏中显示
      stage.setScene(scene);         // 将场景附加到舞台
      stage.show();                  // 显示舞台
   }

   public static void main(String[] args) {
      // 创建TipCalculator对象并调用其start方法
      launch(args); 
   }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
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
