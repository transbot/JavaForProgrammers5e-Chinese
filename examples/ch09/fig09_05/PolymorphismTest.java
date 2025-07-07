// 图9.5: PolymorphismTest.java
// 将超类和子类引用赋给
// 超类变量和子类变量
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PolymorphismTest {
   public static void main(String[] args) {
      // 将超类引用赋给超类变量
      var salariedEmployee = new SalariedEmployee("Sierra Dembo", 
         new BigDecimal("1000.00"));       

      // 将子类引用赋给子类变量
      var salariedCommissionEmployee = new SalariedCommissionEmployee(
         "郭襄", new BigDecimal("500.00"), 
         new BigDecimal("10000.00"), new BigDecimal("0.04"));

      // 使用超类变量调用超类对象的toString方法
      System.out.printf(""" 
         使用指向超类对象的超类引用调用SalariedEmployee的
         toString和calculateEarnings方法：
         %s
         实际地收入: $%s%n%n""", salariedEmployee,
         salariedEmployee.calculateEarnings().setScale(
            2, RoundingMode.HALF_EVEN));

      // 使用子类变量调用子类对象的toString方法      
      System.out.printf(""" 
         使用指向子类对象的子类引用调用SalariedCommissionEmployee的
         toString和calculateEarnings方法：
         %s
         实际收入: $%s%n%n""", salariedCommissionEmployee,
         salariedCommissionEmployee.calculateEarnings().setScale(
            2, RoundingMode.HALF_EVEN));

      // 使用超类变量调用子类对象的toString方法
      SalariedEmployee salariedEmployee2 = salariedCommissionEmployee;
      System.out.printf(""" 
         使用指向子类对象的超类引用调用SalariedCommissionEmployee的
         toString和calculateEarnings方法：
         %s
         收入: $%s%n""", salariedEmployee2,
         salariedEmployee2.calculateEarnings().setScale(
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
