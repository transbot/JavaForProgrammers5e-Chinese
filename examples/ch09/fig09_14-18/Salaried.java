// 图9.16: Salaried.java
// Salaried实现了CompensationModel接口
import java.math.BigDecimal;

public final class Salaried implements CompensationModel {
   private BigDecimal salary;

   // 构造函数
   public Salaried(BigDecimal salary) {
      // 工资无效则抛出异常
      if (salary.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("工资必须 >= 0.0");
      }

      this.salary = salary;
   }

   // 返回工资
   public BigDecimal getSalary() {return salary;}

   // 重写CompensationModel的抽象方法calculateEarnings
   @Override
   public BigDecimal calculateEarnings() {return salary;}

   // 重写Object的toString方法
   @Override
   public String toString() {
      return String.format("工资: $%s", salary);
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
