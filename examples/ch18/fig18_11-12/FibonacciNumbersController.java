// 图18.12: FibonacciNumbersController.java
// 使用Task在JavaFX应用程序线程外部
// 执行长时间计算
import java.util.concurrent.Executors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FibonacciNumbersController {
   @FXML private TextField numberTextField;
   @FXML private Button goButton;
   @FXML private Label messageLabel;
   @FXML private Label fibonacciLabel;
   @FXML private Label nthLabel;
   @FXML private Label nthFibonacciLabel;

   private long n1 = 0;    // 初始化第0个斐波那契数
   private long n2 = 1;    // 初始化第1个斐波那契数
   private int number = 1; // 当前要显示的斐波那契数

   // 启动FibonacciTask并在后台计算
   @FXML
   void goButtonPressed(ActionEvent event) {
      // 获取要计算的斐波那契数
      try {
         int input = Integer.parseInt(numberTextField.getText());

         // 创建、配置和启动FibonacciTask
         FibonacciTask task = new FibonacciTask(input);

         // 在messageLabel中显示任务的消息
         messageLabel.textProperty().bind(task.messageProperty());

         // 任务启动后清除fibonacciLabel上的文本
         task.setOnRunning((succeededEvent) -> {
            goButton.setDisable(true);
            fibonacciLabel.setText(""); 
         });
         
         // 任务成功完成后设置fibonacciLabel上的文本
         task.setOnSucceeded((succeededEvent) -> {
            fibonacciLabel.setText(task.getValue().toString());
            goButton.setDisable(false);
         });

         // 启动一个FibonacciTask 
         var executor = Executors.newFixedThreadPool(1);
         executor.execute(task); // 启动任务
         executor.shutdown();    // 防止调度更多任务
      }
      catch (NumberFormatException e) {
         numberTextField.setText("请输入一个整数");
         numberTextField.selectAll();
         numberTextField.requestFocus();
      }
   }

   // 计算下一个斐波那契数
   @FXML
   void nextNumberButtonPressed(ActionEvent event) {
      // 显示下一个斐波那契数
      nthLabel.setText("第" + number + "个斐波那契数是: ");
      nthFibonacciLabel.setText(String.valueOf(n2));
      long temp = n1 + n2;
      n1 = n2;
      n2 = temp;
      ++number;
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
