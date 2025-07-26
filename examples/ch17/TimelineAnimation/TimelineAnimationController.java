// 图17.12: TimelineAnimationController.java
// 使用Timeline动画让一个圆在窗口中弹跳
import java.util.random.RandomGenerator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TimelineAnimationController {
   private final static RandomGenerator random = 
      RandomGenerator.getDefault();
   private int dx = random.nextInt(1, 6);
   private int dy = random.nextInt(1, 6);
   @FXML private Circle c;
   @FXML private Pane pane;

   @FXML
   private void initialize() {
      // 定义一个时间轴动画
      var timelineAnimation = new Timeline(
         new KeyFrame(Duration.millis(10), e -> {
            // 将圆移动dx和dy的距离
            c.setLayoutX(c.getLayoutX() + dx);
            c.setLayoutY(c.getLayoutY() + dy);
            Bounds bounds = pane.getBoundsInLocal();

            if (hitRightOrLeftEdge(bounds)) {
               dx *= -1;
            }

            if (hitTopOrBottom(bounds)) {
               dy *= -1;
            }
         }) // KeyFrame构造函数调用结束
      );

      // 设置时间轴动画无限循环运行
      timelineAnimation.setCycleCount(Timeline.INDEFINITE);
      timelineAnimation.play();
   }
   
   // 判断圆是否碰到窗口的左右边缘
   private boolean hitRightOrLeftEdge(Bounds bounds) {
      return (c.getLayoutX() <= (bounds.getMinX() + c.getRadius())) ||
         (c.getLayoutX() >= (bounds.getMaxX() - c.getRadius()));      
   }

   // 判断圆是否碰到窗口的上下边缘
   private boolean hitTopOrBottom(Bounds bounds) {
      return (c.getLayoutY() <= (bounds.getMinY() + c.getRadius())) ||
         (c.getLayoutY() >= (bounds.getMaxY() - c.getRadius()));      
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
