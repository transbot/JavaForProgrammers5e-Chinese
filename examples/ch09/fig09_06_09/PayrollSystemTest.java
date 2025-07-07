// 图9.9: PayrollSystemTest.java
// Employee层次结构测试程序
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayrollSystemTest {
   public static void main(String[] args) {
      // 创建子类对象
      var salariedEmployee = new SalariedEmployee("殷离 ", 
         new BigDecimal("1000.00"));       
      var commissionEmployee = new CommissionEmployee("郭襄", 
         new BigDecimal("10000.00"), new BigDecimal("0.06"));

      System.out.println("单独处理员工:");

      System.out.printf("%s%n实际收入: $%s%n%n", salariedEmployee, 
         salariedEmployee.calculateEarnings().setScale(
            2, RoundingMode.HALF_EVEN));
      System.out.printf("%s%n实际收入: $%s%n%n", commissionEmployee, 
         commissionEmployee.calculateEarnings().setScale(
            2, RoundingMode.HALF_EVEN));

      // 创建并初始化员工数组
      Employee[] employees = {salariedEmployee, commissionEmployee}; 
      if (currentEmployee instanceof SalariedEmployee) {
   // 将Employee引用向下转型为SalariedEmployee引用
   SalariedEmployee employee = (SalariedEmployee) currentEmployee;

   // ... if主体的其余部分 ...
}


      System.out.println("多态处理员工:");

      // 泛化地处理employees数组中的每个元素
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee); // 自动调用toString

         // 判断当前元素是否为周薪制员工（SalariedEmployee）
         if (currentEmployee instanceof SalariedEmployee employee) {
            employee.setSalary(
               employee.getSalary().multiply(new BigDecimal("1.10")));

            System.out.printf(
               "周薪提高10%%后为: $%s%n",              
               employee.getSalary().setScale(2, RoundingMode.HALF_EVEN));
         } 

         System.out.printf("实际收入: $%s%n%n", 
            currentEmployee.calculateEarnings().setScale(
               2, RoundingMode.HALF_EVEN));
      } 

      // 获取employees数组中每个对象的类型名称
      for (int j = 0; j < employees.length; ++j) {      
         System.out.printf("员工%d是一个%s%n", j,  
            employees[j].getClass().getName());         
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
