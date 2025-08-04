// 图20.5: AddressBookController.java
// AddressBook应用程序的控制器
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AddressBookController {
   @FXML private ListView<Person> listView; // 显示联系人姓名
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField emailTextField;
   @FXML private TextField phoneTextField;
   @FXML private TextField findByLastNameTextField;

   // 与数据库交互
   private final PersonQueries personQueries = new PersonQueries();

   //  存储一个Person对象列表，这些对象来自一次数据库查询
   private final ObservableList<Person> contactList = 
      FXCollections.observableArrayList();
   
   // 填充listView，并设置一个侦听器来响应选择事件
   public void initialize() {
      // ListView中的选择发生变化时，显示所选联系人的信息
      listView.getSelectionModel().selectedItemProperty().addListener(
         (observableValue, oldValue, newValue) -> {
            displayContact(newValue);
         }
      );     

      listView.setItems(contactList); // 绑定到contactList
      getAllEntries(); // 填充用于更新listView的contactList
   }

   // 从数据库获取记录项来填充contactList
   private void getAllEntries() {
      contactList.setAll(personQueries.getAllPeople());
      selectFirstEntry();
   }

   // 选择listView中的第一条记录
   private void selectFirstEntry() {
      listView.getSelectionModel().selectFirst();
   }

   // 显示联系信息
   private void displayContact(Person person) {
      if (person != null) {
         firstNameTextField.setText(person.first());
         lastNameTextField.setText(person.last());
         emailTextField.setText(person.email());
         phoneTextField.setText(person.phone());
      }
      else {
         firstNameTextField.clear();
         lastNameTextField.clear();
         emailTextField.clear();
         phoneTextField.clear();
      }
   }

   // 添加一条新记录
   @FXML
   void addEntryButtonPressed(ActionEvent event) {
      int result = personQueries.addPerson(                        
         firstNameTextField.getText(), lastNameTextField.getText(),
         emailTextField.getText(), phoneTextField.getText());      
      
      if (result == 1) {
         displayAlert(AlertType.INFORMATION, "已添加记录", 
            "已经成功添加了新记录。");
      }
      else {
         displayAlert(AlertType.ERROR, "未添加记录", 
            "添加记录失败，请检查输入数据是否正确。");
      }
      
      getAllEntries();
   }

   // 查找具有指定姓氏的记录
   @FXML
   void findButtonPressed(ActionEvent event) {
      List<Person> people = personQueries.getPeopleByLastName(
         findByLastNameTextField.getText() + "%");            

      if (people.size() > 0) { // 显示所有记录
         contactList.setAll(people);
         selectFirstEntry();
      }
      else {
         displayAlert(AlertType.INFORMATION, "未找到指定姓氏", 
            "没有找到与指定姓氏匹配的记录。");
      }
   }

   // 查看所有记录
   @FXML
   void browseAllButtonPressed(ActionEvent event) {
      getAllEntries();
   }

   // 显示一个Alert对话框
   private void displayAlert(
      AlertType type, String title, String message) {
      var alert = new Alert(type);
      alert.setTitle(title);
      alert.setContentText(message);
      alert.showAndWait();
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
