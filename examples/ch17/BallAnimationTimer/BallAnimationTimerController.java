// 图17.13: BallAnimationTimerController.java
// 使用AnimationTimer的子类让一个圆在窗口中弹跳
import java.util.random.RandomGenerator;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BallAnimationTimerController {
   private final static RandomGenerator random = 
      RandomGenerator.getDefault();
   private int dx = random.nextInt(1, 6);
   private int dy = random.nextInt(1, 6);
   @FXML private Circle c;
   @FXML private Pane pane;
   
   @FXML
   private void initialize() {
      // 定义一个动画计时器
      AnimationTimer timer = new AnimationTimer() {
         int velocity = 60; // 用于缩放距离变化的基准速度           
         long previousTime = System.nanoTime(); // 应用程序启动后的时间戳

         // 指定如何为当前动画帧移动圆形
         @Override
         public void handle(long now) {
            double elapsedTime = (now - previousTime) / 1000000000.0;
            previousTime = now;                                      
            double scale = elapsedTime * velocity;                   

            Bounds bounds = pane.getBoundsInLocal();
            c.setLayoutX(c.getLayoutX() + dx * scale);
            c.setLayoutY(c.getLayoutY() + dy * scale);

            if (hitRightOrLeftEdge(bounds)) {
               dx *= -1;
            }

            if (hitTopOrBottom(bounds)) {
               dy *= -1;
            }
         }
      };
         
      timer.start();
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
