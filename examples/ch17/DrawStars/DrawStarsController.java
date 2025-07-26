// 图17.6: DrawStarsController.java
// 使用多边形和旋转变换创建一个星星圆
import java.util.random.RandomGenerator;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Transform;

public class DrawStarsController {
   private static final RandomGenerator random =
      RandomGenerator.getDefault();
   @FXML private Pane pane;
   
   @FXML
   private void initialize() {
      // 定义五角星（脑筋急转弯：一个五角星有几个点？）
      Double[] points = {205.0,150.0, 217.0,186.0, 259.0,186.0, 
         223.0,204.0, 233.0,246.0, 205.0,222.0, 177.0,246.0, 187.0,204.0, 
         151.0,186.0, 193.0,186.0};
      
      // 创建18个星星
      for (int count = 0; count < 18; ++count) {
         // 创建一个新的多边形，并将现有的点复制给它
         var newStar = new Polygon();
         newStar.getPoints().addAll(points); 

         // 创建随机颜色并设为newStar的填充
         newStar.setStroke(Color.GREY);
         newStar.setFill(Color.rgb(random.nextInt(256), 
            random.nextInt(256), random.nextInt(256), 
            random.nextDouble())); 

         // 向形状应用旋转
         newStar.getTransforms().add(
            Transform.rotate(count * 20, 150, 150));
         pane.getChildren().add(newStar);
      } 
   }   
}

/*************************************************************************
* (C) Copyright 1992-2017 by Deitel & Associates, Inc. and               *
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
