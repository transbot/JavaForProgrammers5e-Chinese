// 图17.10: TransitionAnimationsController.java
// 将过渡动画应用于Rectangle
import javafx.animation.FadeTransition;      
import javafx.animation.FillTransition;        
import javafx.animation.Interpolator;        
import javafx.animation.ParallelTransition;  
import javafx.animation.PathTransition;      
import javafx.animation.RotateTransition;    
import javafx.animation.ScaleTransition;     
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;    
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class TransitionAnimationsController {
   @FXML private Rectangle rectangle;
   
   // 配置并启动过渡动画
   @FXML
   private void startButtonPressed(ActionEvent event) {
      // 改变形状填充色的过渡动画
      var fillTransition = new FillTransition(Duration.seconds(1));
      fillTransition.setToValue(Color.CYAN);
      fillTransition.setCycleCount(2);
      
      // 每个偶数周期反向播放过渡以恢复原始状态
      fillTransition.setAutoReverse(true); 

      // 随时间改变形状描边颜色的过渡动画
      var strokeTransition = new StrokeTransition(Duration.seconds(1));
      strokeTransition.setToValue(Color.BLUE);
      strokeTransition.setCycleCount(2);
      strokeTransition.setAutoReverse(true);
      
      // 并行执行多个过渡动画
      var parallelTransition = 
         new ParallelTransition(fillTransition, strokeTransition);

      // 随时间改变节点透明度的过渡动画
      var fadeTransition = new FadeTransition(Duration.seconds(1));
      fadeTransition.setFromValue(1.0); // 不透明
      fadeTransition.setToValue(0.0);   // 透明
      fadeTransition.setCycleCount(2);
      fadeTransition.setAutoReverse(true);

      // 旋转节点的过渡动画
      var rotateTransition = new RotateTransition(Duration.seconds(1));
      rotateTransition.setByAngle(360.0);
      rotateTransition.setCycleCount(2);
      rotateTransition.setInterpolator(Interpolator.EASE_BOTH);
      rotateTransition.setAutoReverse(true);
      
      // 使节点沿路径平移（translate）的过渡动画
      var path = new Path(new MoveTo(45, 45), new LineTo(45, 0), 
         new LineTo(90, 0), new LineTo(90, 90), new LineTo(0, 90));
      var translateTransition = 
         new PathTransition(Duration.seconds(2), path);
      translateTransition.setCycleCount(2);
      translateTransition.setInterpolator(Interpolator.EASE_IN);
      translateTransition.setAutoReverse(true);
      
      // 缩放形状使其变大或变小的过渡动画
      var scaleTransition = new ScaleTransition(Duration.seconds(1));
      scaleTransition.setByX(0.75);
      scaleTransition.setByY(0.75);
      scaleTransition.setCycleCount(2);
      scaleTransition.setInterpolator(Interpolator.EASE_OUT);
      scaleTransition.setAutoReverse(true);

      // 该SequentialTransition将一系列过渡按顺序应用于节点
      var sequentialTransition = new SequentialTransition( 
         rectangle, parallelTransition, fadeTransition, 
         rotateTransition, translateTransition, scaleTransition);
      sequentialTransition.play(); // 播放过渡动画
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
