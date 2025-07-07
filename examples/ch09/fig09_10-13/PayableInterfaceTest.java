// 图9.13: PayableInterfaceTest.java
// Payable接口测试程序多态地
// 处理发票和员工对象
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PayableInterfaceTest {
   public static void main(String[] args) {
      // 创建包含4个元素的Payable数组payableObjects
      Payable[] payableObjects = {
         new Invoice("01234", "座椅", 2, new BigDecimal("375.00")),
         new Invoice("56789", "轮胎", 4, new BigDecimal("79.95")),
         new SalariedEmployee("纪晓芙", new BigDecimal("1200.00")),
         new SalariedEmployee("谢逊", new BigDecimal("800.00"))
      };

      System.out.println(
         "多态地处理发票和员工的应付金额:\n"); 

      // 泛化地处理payableObjects数组中的每个元素
      for (Payable currentPayable : payableObjects) {
         // 输出currentPayable及其对应的应付款
         System.out.printf("%s:%n%s %n应付金额: $%s%n%n", 
            currentPayable.getClass().getName(),
            currentPayable.toString(), // 可以隐式调用
            currentPayable.calculatePayment().setScale(
               2, RoundingMode.HALF_EVEN)); 
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
