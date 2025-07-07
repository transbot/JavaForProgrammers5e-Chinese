// 图9.1: SalariedEmployee.java
// SalariedEmployee类代表固定周薪制员工
import java.math.BigDecimal;

public class SalariedEmployee extends Object {
   private final String name; // 姓名                       
   private BigDecimal salary; // 固定周薪       

   // 有两个参数的构造函数                                
   public SalariedEmployee(String name, BigDecimal salary) {
      // 这里隐式调用了Object的默认构造函数   

      // 如果周薪无效则抛出异常
      if (salary.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("工资必须 >= 0.0");
      }   

      this.name = name;                                    
      this.salary = salary;                                    
   } 

   // 返回姓名
   public String getName() {return name;}

   // 设置周薪金额
   public void setSalary(BigDecimal salary) {
      if (salary.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("周薪必须 >= 0.0");
      }

      this.salary = salary;
   } 

   // 返回周薪金额
   public BigDecimal getSalary() {return salary;}

   // 计算实际收入
   public BigDecimal calculateEarnings() {return getSalary();}

   // 返回SalariedEmployee对象的字符串表示形式         
   @Override // 表示该方法重写了超类的方法
   public String toString() {                                           
      return String.format("姓名: %s%n周薪: $%s", 
         getName(), getSalary());
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
