// 图9.2: SalariedEmployeeTest.java
// SalariedEmployee类的测试程序  
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalariedEmployeeTest {
   public static void main(String[] args) {
      // 实例化SalariedEmployee对象
      var employee = new SalariedEmployee(
         "殷离", new BigDecimal("1000.00"));       
      
      // 获取SalariedEmployee数据
      System.out.println("通过取值方法获得的员工信息:");
      System.out.printf("姓名: %s%n周薪: $%s%n", employee.getName(),
         employee.getSalary().setScale(2, RoundingMode.HALF_EVEN));

      employee.setSalary(new BigDecimal("1200.00")); // 用赋值方法修改周薪
      
      // 计算并显示更新后的实际收入
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
