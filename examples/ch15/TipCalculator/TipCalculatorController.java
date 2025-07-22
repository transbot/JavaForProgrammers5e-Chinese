// 图15.2: TipCalculatorController.java
// 用于处理calculateButton和tipPercentageSlider控件事件的控制器
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {    
   // 用于货币和百分比的格式化器
   private static final NumberFormat currency = 
      NumberFormat.getCurrencyInstance();
   private static final NumberFormat percent = 
      NumberFormat.getPercentInstance();
   
   private BigDecimal tipPercentage = new BigDecimal("0.15"); // 15%
   
   // 在FXML中定义并被控制器代码使用的GUI控件
   @FXML 
   private TextField amountTextField; 

   @FXML
   private Label tipPercentageLabel; 

   @FXML
   private Slider tipPercentageSlider;

   @FXML
   private TextField tipTextField;

   @FXML
   private TextField totalTextField;

   // 计算并显示小费和总额
   @FXML
   private void calculateButtonPressed(ActionEvent event) {
      try {
         BigDecimal amount = new BigDecimal(amountTextField.getText());
         BigDecimal tip = amount.multiply(tipPercentage);
         BigDecimal total = amount.add(tip);

         tipTextField.setText(currency.format(tip));
         totalTextField.setText(currency.format(total));
      }
      catch (NumberFormatException ex) {
         amountTextField.setText("输入金额无效");
         amountTextField.selectAll();
         amountTextField.requestFocus();
      }
   }

   // 如果存在，则由FXMLLoader调用以初始化控制器
   @FXML
   private void initialize() {
      // 0~4向下舍入，5~9向上舍入 
      currency.setRoundingMode(RoundingMode.HALF_EVEN);
      
      // 侦听tipPercentageSlider值的变化
      tipPercentageSlider.valueProperty().addListener( 
         (ov, oldValue, newValue) -> {
            tipPercentage =                                           
               BigDecimal.valueOf(newValue.intValue() / 100.0);       
            tipPercentageLabel.setText(percent.format(tipPercentage));
         }
      );
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
