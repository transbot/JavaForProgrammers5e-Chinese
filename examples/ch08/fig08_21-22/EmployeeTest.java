// 图8.22: EmployeeTest.java
// 静态成员演示

public class EmployeeTest {
   public static void main(String[] args) {
      // 证明在创建Employee之前，count为0
      System.out.printf("实例化之前的Employee数量: %d%n",
         Employee.getCount());

      // 创建两个Employee，之后count应该变成2
      var e1 = new Employee("Anna", "Gruber");
      var e2 = new Employee("Teva", "Maihi");   
    
      // 证明创建两个Employee后count为2
      System.out.printf("%n实例化之后的Employee数量:%n");
      System.out.printf("通过e1.getCount(): %d%n", e1.getCount());
      System.out.printf("通过e2.getCount(): %d%n", e2.getCount());
      System.out.printf("通过Employee.getCount(): %d%n", 
         Employee.getCount());
   
      // 获取雇员姓名
      System.out.printf("%nEmployee 1: %s %s%nEmployee 2: %s %s%n",
         e1.getFirstName(), e1.getLastName(), 
         e2.getFirstName(), e2.getLastName());
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
