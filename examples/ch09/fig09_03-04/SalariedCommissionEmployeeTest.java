// 图9.4: SalariedCommissionEmployeeTest.java
// SalariedCommissionEmployee类的测试程序
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalariedCommissionEmployeeTest {
   public static void main(String[] args) {
      // 实例化SalariedCommissionEmployee对象
      var employee = new SalariedCommissionEmployee("郭襄", 
         new BigDecimal("500.00"), new BigDecimal("10000.00"), 
         new BigDecimal("0.04"));
      
      // 获取SalariedCommissionEmployee数据
      System.out.printf("""
         通过取值方法获得的员工信息:
         姓名: %s
         周薪: $%s
         销售额: $%s 
         提成比例: %s
         """, employee.getName(), employee.getSalary(), 
         employee.getGrossSales(), employee.getCommissionRate());

      // 更新销售额和提成比例
      employee.setGrossSales(new BigDecimal("8000.00")); 
      employee.setCommissionRate(new BigDecimal("0.1")); 
      
      // 显示更新后的员工信息和实际收入
      System.out.printf("%n%s:%n%s%n%n实际收入: $%s%n",
         "通过toString方法获得更新后的员工信息", employee,
         employee.calculateEarnings().setScale(
            2, RoundingMode.HALF_EVEN));
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
