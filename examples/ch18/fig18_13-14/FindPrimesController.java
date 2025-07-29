// 图18.14: FindPrimesController.java
// 一边查找素数一边显示，同时更新ProgressBar进度条
import java.util.concurrent.Executors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class FindPrimesController {
   @FXML private TextField inputTextField;
   @FXML private Button getPrimesButton;
   @FXML private ListView<Integer> primesListView;
   @FXML private Button cancelButton;
   @FXML private ProgressBar progressBar;
   @FXML private Label statusLabel;

   // 存储从PrimeCalculatorTask接收到的素数列表
   private ObservableList<Integer> primes = 
      FXCollections.observableArrayList();
   private PrimeCalculatorTask task; // 该任务查找素数

   // 将primesListView中的项绑定到名为primes的ObservableList
   @FXML
   public void initialize() {
      primesListView.setItems(primes);
   }

   // 开始在后台查找素数
   @FXML
   void getPrimesButtonPressed(ActionEvent event) {
      primes.clear();

      // 获取要查找最大数
      try {
         int input = Integer.parseInt(inputTextField.getText());
         task = new PrimeCalculatorTask(input); // 创建任务

         // 在statusLabel中显示任务的消息
         statusLabel.textProperty().bind(task.messageProperty());

         // 根据任务的progressProperty更新progressBar
         progressBar.progressProperty().bind(task.progressProperty());

         // 将中间结果存储到名为primes的ObservableList中
         task.valueProperty().addListener(
            (observable, oldValue, newValue) -> {
               if (newValue != 0) { // 任务终止会返回0，而0不是素数
                  primes.add(newValue);
                  primesListView.scrollTo(
                     primesListView.getItems().size());
               }
            });

         // 当任务开始时，
         // 禁用getPrimesButton按钮，并启用cancelButton按钮
         task.setOnRunning((succeededEvent) -> {
            getPrimesButton.setDisable(true);
            cancelButton.setDisable(false);
         });

         // 当任务成功完成后，
         // 启用getPrimesButton按钮并禁用cancelButton按钮
         task.setOnSucceeded((succeededEvent) -> {
            getPrimesButton.setDisable(false);
            cancelButton.setDisable(true);
         });

         // 启动PrimeCalculatorTask
         var executor = Executors.newVirtualThreadPerTaskExecutor();
         executor.execute(task); // 启动任务
         executor.shutdown();
      }
      catch (NumberFormatException e) {
         inputTextField.setText("请输入一个整数");
         inputTextField.selectAll();
         inputTextField.requestFocus();
      }  
   }

   // 单击“取消”按钮时取消任务
   @FXML
   void cancelButtonPressed(ActionEvent event) {
      if (task != null) {
         task.cancel(); // 终止任务
         getPrimesButton.setDisable(false);
         cancelButton.setDisable(true);
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
