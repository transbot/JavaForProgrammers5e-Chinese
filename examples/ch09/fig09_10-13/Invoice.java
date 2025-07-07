// 图9.11: Invoice.java
// 实现了Payable接口的Invoice类
import java.math.BigDecimal;

public class Invoice implements Payable {
   private final String partNumber;       // 零件编号
   private final String partDescription;  // 零件描述
   private final int quantity;            // 零件数量
   private final BigDecimal pricePerItem; // 零件单价

   // 构造函数
   public Invoice(String partNumber, String partDescription, int quantity,
      BigDecimal pricePerItem) {
      if (quantity < 0) { // 校验数量
         throw new IllegalArgumentException("数量必须 >= 0");
      }

      // 校验单价（pricePerItem）
      if (pricePerItem.compareTo(BigDecimal.ZERO) < 0) { 
         throw new IllegalArgumentException(
            "单价必须 >= 0");
      }

      this.quantity = quantity;
      this.partNumber = partNumber;
      this.partDescription = partDescription;
      this.pricePerItem = pricePerItem;
   } 

   // 各种取值方法
   public String getPartNumber() {return partNumber;}
   public String getPartDescription() {return partDescription;}
   public int getQuantity() {return quantity;}
   public BigDecimal getPricePerItem() {return pricePerItem;}

   // 返回Invoice对象的字符串表示形式
   @Override
   public String toString() {
      return String.format("%s: %s (%s)%n%s: %d%n%s: $%s", 
         "零件编号", getPartNumber(), getPartDescription(), 
         "数量", getQuantity(), "单价", getPricePerItem());
   } 

   // 实现Payable接口契约所要求的方法   
   @Override                                                           
   public BigDecimal calculatePayment() {                                  
      BigDecimal quantity = new BigDecimal(getQuantity());
      return quantity.multiply(getPricePerItem()); // 计算总价
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
