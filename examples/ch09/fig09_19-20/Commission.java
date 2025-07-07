// 图9.17: Commission.java
// Commission实现了CompensationModel接口
import java.math.BigDecimal;

public final class Commission implements CompensationModel {
   private BigDecimal grossSales;
   private BigDecimal commissionRate;

   // 构造函数 
   public Commission(BigDecimal grossSales, BigDecimal commissionRate) {
      // 销售额无效则抛出异常
      if (grossSales.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException("销售额必须 >= 0.0");
      }   

      // 提成比例无效则抛出异常
      if (commissionRate.compareTo(BigDecimal.ZERO) <= 0 || 
          commissionRate.compareTo(BigDecimal.ONE) >= 0) { 
         throw new IllegalArgumentException(
            "提成比例必须 > 0.0 且 < 1.0");
      }   

      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   }

   // 返回销售额
   public BigDecimal getGrossSales() {return grossSales;}

   // 返回提成比例
   public BigDecimal getCommissionRate() {return commissionRate;}

   // 重写CompensationModel的抽象方法calculateEarnings
   @Override
   public BigDecimal calculateEarnings() {
      return grossSales.multiply(commissionRate);
   }

   // 重写Object的toString方法  
   @Override
   public String toString() {
      return String.format("销售额: $%s; 提成比例: %s", 
         grossSales, commissionRate);
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
