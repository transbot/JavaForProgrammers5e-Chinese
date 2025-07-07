// 图9.7: SalariedEmployee.java
// SalariedEmployee具体类扩展了抽象类Employee
import java.math.BigDecimal;

public class SalariedEmployee extends Employee {
   private BigDecimal salary; // 固定周薪

   // 构造函数
   public SalariedEmployee(String name, BigDecimal salary) {
      super(name); 

      // 如果周薪无效则抛出异常
      if (salary.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("工资必须 >= 0.0");
      }   

      this.salary = salary;                                    
   } 

   // 设置周薪金额
   public void setSalary(BigDecimal salary) {
      if (salary.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("工资必须 >= 0.0");
      }

      this.salary = salary;
   } 

   // 返回周薪金额
   public BigDecimal getSalary() {return salary;}

   // 计算实际收入
   @Override
   public BigDecimal calculateEarnings() {return getSalary();}

   // 返回SalariedEmployee对象的字符串表示形式
   @Override // 表示该方法重写了超类的方法
   public String toString() {                                           
      return String.format("%s%n周薪: $%s", 
         super.toString(), getSalary());
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
