// 图17.16: CanvasShapesController.java
// 在画布上绘图
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;

public class CanvasShapesController {
   // 引用了GUI组件的实例变量
   @FXML private Canvas drawingCanvas;       

   // 在画布上绘图
   @FXML
   public void initialize() {
      GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
      gc.setLineWidth(10); // 设置所有边框（描边）的宽度

      // 绘制红色直线
      gc.setStroke(Color.RED);
      gc.strokeLine(10, 10, 100, 100);

      // 绘制绿色直线（半透明）
      gc.setGlobalAlpha(0.5); // 50%透明度
      gc.setLineCap(StrokeLineCap.ROUND); // 设置圆形线帽
      gc.setStroke(Color.GREEN);
      gc.strokeLine(100, 10, 10, 100);

      gc.setGlobalAlpha(1.0); // 重置透明度为完全不透明

      // 绘制圆角矩形：红色边框+黄色填充
      gc.setStroke(Color.RED);
      gc.setFill(Color.YELLOW);
      gc.fillRoundRect(120, 10, 90, 90, 50, 50);   // 先填充
      gc.strokeRoundRect(120, 10, 90, 90, 50, 50); // 后描边

      // 绘制圆形：蓝色边框+红白径向渐变填充
      gc.setStroke(Color.BLUE);
      Stop[] stopsRadial = 
         {new Stop(0, Color.RED), new Stop(1, Color.WHITE)}; // 渐变颜色节点
      RadialGradient radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 
         0.6, true, CycleMethod.NO_CYCLE, stopsRadial);      // 创建径向渐变
      gc.setFill(radialGradient);
      gc.fillOval(230, 10, 90, 90);
      gc.strokeOval(230, 10, 90, 90);

      // 绘制椭圆：绿色边框+图像纹理填充
      gc.setStroke(Color.GREEN);
      gc.setFill(new ImagePattern(new Image("yellowflowers.png"))); // 使用图像填充
      gc.fillOval(340, 10, 200, 90);
      gc.strokeOval(340, 10, 200, 90);

      // 绘制圆弧：紫色边框+青白线性渐变填充
      gc.setStroke(Color.PURPLE);
      Stop[] stopsLinear = 
         {new Stop(0, Color.CYAN), new Stop(1, Color.WHITE)}; // 渐变颜色节点
      LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, 
         true, CycleMethod.NO_CYCLE, stopsLinear); // 创建线性渐变
      gc.setFill(linearGradient);
      gc.fillArc(560, 10, 90, 90, 45, 270, ArcType.ROUND);   // 填充圆弧
      gc.strokeArc(560, 10, 90, 90, 45, 270, ArcType.ROUND); // 描边圆弧
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
