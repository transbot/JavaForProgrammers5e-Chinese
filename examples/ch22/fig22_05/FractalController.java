// 图22.5: FractalController.java
// 递归绘制Lo羽毛分形
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;         
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;   
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class FractalController {
   // 常量定义
   private static final int MIN_LEVEL = 0;   // 最小分形层级
   private static final int MAX_LEVEL = 15;  // 最大分形层级

   // 引用GUI组件的实例变量
   @FXML private Canvas canvas;           // 绘制分形的画布
   @FXML private ColorPicker colorPicker; // 颜色选择器
   @FXML private Label levelLabel;        // 显示当前层级的标签

   // 其他实例变量
   private Color currentColor = Color.BLUE; // 当前绘制颜色
   private int level = MIN_LEVEL;           // 初始分形层级
   private GraphicsContext gc;              // 用于在画布上绘制的图形上下文

   // 控制器初始化方法
   public void initialize() {
      levelLabel.setText("Level: " + level);  // 设置初始层级文本
      colorPicker.setValue(currentColor);      // 初始设置为蓝色      
      gc = canvas.getGraphicsContext2D();     // 获取图形上下文
      drawFractal();                          // 绘制分形
   }
   
   // 当用户选择新颜色时设置当前颜色
   @FXML
   void colorSelected(ActionEvent event) {
      currentColor = colorPicker.getValue();  // 获取新颜色
      drawFractal();                          // 重新绘制分形
   }

   // 降低层级并重新绘制分形
   @FXML
   void decreaseLevelButtonPressed(ActionEvent event) {
      if (level > MIN_LEVEL) {                // 确保不低于最小层级
         --level;                             // 层级递减
         levelLabel.setText("Level: " + level); // 更新层级显示
         drawFractal();                       // 重新绘制
      }
   }

   // 增加层级并重新绘制分形
   @FXML
   void increaseLevelButtonPressed(ActionEvent event) {
      if (level < MAX_LEVEL) {                // 确保不超过最大层级
         ++level;                             // 层级递增
         levelLabel.setText("Level: " + level); // 更新层级显示
         drawFractal();                       // 重新绘制
      }
   }

   // 清除画布，设置绘制颜色并绘制分形
   private void drawFractal() {
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // 清空画布
      gc.setStroke(currentColor);                                // 设置绘制颜色
      drawFractal(level, 40, 40, 350, 350);          // 调用递归绘制方法
   }

   // 递归绘制分形
   public void drawFractal(int level, int xA, int yA, int xB, int yB) {
      // 基本情况：绘制连接两个给定点的直线
      if (level == 0) {
         gc.strokeLine(xA, yA, xB, yB);
      }
      else { // 递归步骤：计算新点，绘制下一层级
         // 计算(xA, yA)和(xB, yB)之间的中点
         int xC = (xA + xB) / 2;
         int yC = (yA + yB) / 2;

         // 计算第四个点(xD, yD)，该点与(xA, yA)
         // 和(xC, yC)形成一个直角在(xD, yD)的
         // 等腰直角三角形
         int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
         int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
         
         // 递归绘制分形
         drawFractal(level - 1, xD, yD, xA, yA); // 从D点到A点
         drawFractal(level - 1, xD, yD, xC, yC); // 从D点到C点
         drawFractal(level - 1, xD, yD, xB, yB); // 从D点到B点
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

