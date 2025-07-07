// 图9.20: PayrollSystemTest.java
// 使用多种CompensationModel来处理Employee
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayrollSystemTest {
   public static void main(String[] args) {
      // 创建不同的CompensationModel和Employee
      var salaried = new Salaried(new BigDecimal("1000.00"));
      var salariedEmployee = new Employee("殷离", salaried);

      var commission = new Commission(
         new BigDecimal("10000.00"), new BigDecimal("0.06"));
      var commissionEmployee = new Employee("郭襄", commission);

      // 创建并初始化Employee数组
      Employee[] employees = {salariedEmployee, commissionEmployee}; 

      // 打印每个Employee的信息和实际收入
      for (Employee employee : employees) {
         // 如果是Salaried模型，就加薪10%
         BigDecimal earnings = 
            switch (employee.getCompensationModel()) {
               case Salaried s -> {
                  BigDecimal newSalary = 
                     s.getSalary().multiply(new BigDecimal("1.10"));

                  // 注入新的CompensationModel
                  employee.setCompensationModel(new Salaried(
                     newSalary.setScale(2, RoundingMode.HALF_EVEN))); 
                  yield employee.calculateEarnings();
               }
               case Commission c -> c.calculateEarnings();
            };

         System.out.printf("%s%n实际收入: $%s%n%n", 
            employee, earnings.setScale(2, RoundingMode.HALF_EVEN));
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
