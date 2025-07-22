// 图16.4: ColorChooserController.java
// “颜色选择器”应用程序的控制器
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ColorChooserController {
   // 用于与GUI组件交互的实例变量
   @FXML private Slider redSlider;
   @FXML private Slider greenSlider;
   @FXML private Slider blueSlider;
   @FXML private Slider alphaSlider;
   @FXML private TextField redTextField;  
   @FXML private TextField greenTextField;
   @FXML private TextField blueTextField; 
   @FXML private TextField alphaTextField;
   @FXML private Rectangle colorRectangle;

   // 用于管理应用程序状态的实例变量
   private int red = 0;
   private int green = 0;
   private int blue = 0;
   private double alpha = 1.0;
   
   @FXML
   private void initialize() {
      // 将TextField值绑定到对应的Slider值
      redTextField.textProperty().bind(              
         redSlider.valueProperty().asString("%.0f"));
      greenTextField.textProperty().bind(
         greenSlider.valueProperty().asString("%.0f"));
      blueTextField.textProperty().bind(
         blueSlider.valueProperty().asString("%.0f"));
      alphaTextField.textProperty().bind(
         alphaSlider.valueProperty().asString("%.2f"));
      
      // 根据Slider的变化来设置矩形填充色的侦听器
      redSlider.valueProperty().addListener(                              
         (ov, oldValue, newValue) -> {                        
            red = newValue.intValue();                                 
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
         }
      );                                                                  
      greenSlider.valueProperty().addListener(
         (ov, oldValue, newValue) -> {                        
            green = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
         }
      );                                                                  
      blueSlider.valueProperty().addListener(
         (ov, oldValue, newValue) -> {                        
            blue = newValue.intValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
         }
      );                                                                  
      alphaSlider.valueProperty().addListener(
         (ov, oldValue, newValue) -> {                        
            alpha = newValue.doubleValue();
            colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
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
