// 图9.8: CommissionEmployee.java
// CommissionEmployee具体类扩展了抽象类Employee
import java.math.BigDecimal;

public class CommissionEmployee extends Employee {
   private BigDecimal grossSales;     // 销售额
   private BigDecimal commissionRate; // 提成比例

   // 构造函数
   public CommissionEmployee(String name, 
      BigDecimal grossSales, BigDecimal commissionRate) {
      super(name);

      // 如果销售额无效则抛出异常
      if (grossSales.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("销售额必须 >= 0.0");
      }   

      // 如果提成比例无效则抛出异常
      if (commissionRate.compareTo(BigDecimal.ZERO) <= 0 || 
          commissionRate.compareTo(BigDecimal.ONE) >= 0) { 
         throw new IllegalArgumentException(
            "提成比例必须 > 0.0 且 < 1.0");
      }   

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   } 

   // 设置销售额
   public void setGrossSales(BigDecimal grossSales) {
      if (grossSales.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("销售额必须 >= 0.0");
      }   

      this.grossSales = grossSales;                
   } 

   // 返回销售额
   public BigDecimal getGrossSales() {return grossSales;}

   // 设置提成比例
   public void setCommissionRate(BigDecimal commissionRate) {
      if (commissionRate.compareTo(BigDecimal.ZERO) <= 0 || 
          commissionRate.compareTo(BigDecimal.ONE) >= 0) { 
         throw new IllegalArgumentException(
            "提成比例必须 > 0.0 且 < 1.0");
      }   

      this.commissionRate = commissionRate;                
   } 

   // 返回提成比例
   public BigDecimal getCommissionRate() {return commissionRate;}

   // 计算实际收入
   @Override 
   public BigDecimal calculateEarnings() {
      return getGrossSales().multiply(getCommissionRate());
   }

   // return String representation of CommissionEmployee
   @Override
   public String toString() {
      return String.format("%s%n销售额: $%s%n提成比例: %s", 
         super.toString(), getGrossSales(), getCommissionRate()); 
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
