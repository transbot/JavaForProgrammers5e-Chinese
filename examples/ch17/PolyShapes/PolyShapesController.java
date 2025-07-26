// 图17.5: PolyShapesController.java
// 绘制折线、多边形和路径
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcTo;    
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;   
import javafx.scene.shape.Path;     
import javafx.scene.shape.Polygon;  
import javafx.scene.shape.Polyline; 

public class PolyShapesController {
   // 表示形状类型的枚举
   private enum ShapeType {POLYLINE, POLYGON, PATH};
   
   // 引用GUI组件的实例变量
   @FXML private RadioButton polylineRadioButton;
   @FXML private RadioButton polygonRadioButton;
   @FXML private RadioButton pathRadioButton;
   @FXML private ToggleGroup toggleGroup;
   @FXML private Polyline polyline;
   @FXML private Polygon polygon;  
   @FXML private Path path;        

   // 用于管理状态的实例变量
   private ShapeType shapeType = ShapeType.POLYLINE; 
   private boolean sweepFlag = true; // 用于Path中的圆弧方向控制
   
   // 为单选钮设置用户数据并显示折线对象
   @FXML 
   private void initialize() {
      // 控件上的用户数据可以是任何对象
      polylineRadioButton.setUserData(ShapeType.POLYLINE);
      polygonRadioButton.setUserData(ShapeType.POLYGON);
      pathRadioButton.setUserData(ShapeType.PATH);
      
      displayShape(); // 应用加载时设置折线可见
   }
   
   // 处理绘图区域的鼠标单击事件
   @FXML
   private void drawingAreaMouseClicked(MouseEvent e) {
      polyline.getPoints().addAll(e.getX(), e.getY());
      polygon.getPoints().addAll(e.getX(), e.getY()); 
    
      // 如果路径为空，移动到首次单击位置并闭合路径
      if (path.getElements().isEmpty()) {
         path.getElements().add(new MoveTo(e.getX(), e.getY()));
         path.getElements().add(new ClosePath());               
      }
      else { // 在ClosePath元素前插入新路径段
         // 创建圆弧并插入路径
         ArcTo arcTo = new ArcTo();    
         arcTo.setX(e.getX());         
         arcTo.setY(e.getY());         
         arcTo.setRadiusX(100.0);      
         arcTo.setRadiusY(100.0);      
         arcTo.setSweepFlag(sweepFlag);
         sweepFlag = !sweepFlag; // 切换圆弧方向标志
         path.getElements().add(path.getElements().size() - 1, arcTo);
      }
   }
   
   // 处理形状单选钮的选择事件
   @FXML
   private void shapeRadioButtonSelected(ActionEvent e) {
      // 每个单选钮的用户数据都是ShapeType枚举常量
      shapeType =                                                  
         (ShapeType) toggleGroup.getSelectedToggle().getUserData();
      displayShape(); // 显示当前选中的形状
   } 

   // 显示当前选中的形状
   private void displayShape() {
      polyline.setVisible(shapeType == ShapeType.POLYLINE);
      polygon.setVisible(shapeType == ShapeType.POLYGON);
      path.setVisible(shapeType == ShapeType.PATH);         
   } 
   
   // 重置所有形状
   @FXML
   private void clearButtonPressed(ActionEvent event) {
      polyline.getPoints().clear();
      polygon.getPoints().clear(); 
      path.getElements().clear();  
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
