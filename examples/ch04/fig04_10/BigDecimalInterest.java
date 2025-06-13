// 图4.10: BigDecimalInterest.java
// 使用BigDecimal对象进行复利计算
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalInterest {
   public static void main(String[] args) {
      // 从字符串创建BigDecimal对象
      BigDecimal principal = new BigDecimal("1000.00");  // 本金
      BigDecimal rate = new BigDecimal("0.05");  // 利率

      System.out.printf("本金: %7s%n", principal);
      System.out.printf("利率: %7s%n%n", rate);

      // 显示列标题
      System.out.printf("%s%16s   %s%n", 
         "年份", "舍入后的金额", "精确的存储值");

      // 计算未来10年的每年存款总额
      for (int year = 1; year <= 10; ++year) {
         BigDecimal amount = principal.multiply(
            BigDecimal.ONE.add(rate).pow(year));
         System.out.printf("%4d%17s        %s%n", year,
            amount.setScale(2, RoundingMode.HALF_EVEN), amount);
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
