// 图4.4: Interest.java
// 使用for进行复利计算

public class Interest {
   public static void main(String[] args) {
      double principal = 1000.00; // 本金
      double rate = 0.05; // 利率

      // 显示列标题
      System.out.printf("%s%16s%n", "年份", "存款总额");

      // 计算未来10年的每年存款总额
      for (int year = 1; year <= 10; ++year) {                  
         // 计算指定年份的新存款总额
         double amount = principal * Math.pow(1.0 + rate, year);
                                                                
         // 显示年份和对应存款总额  
         System.out.printf("%4d%20.2f%n", year, amount);       
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
