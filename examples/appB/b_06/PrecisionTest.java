// 图B.6: PrecisionTest.java
// 为浮点数和字符串指定精度
public class PrecisionTest {
   public static void main(String[] args) {
      double f = 123.94536; 
      String s = "一二三四五六七八九十一二三四五"; 

      System.out.printf("使用浮点数精度%n");
      System.out.printf("\t%.3f%n\t%.3e%n\t%.3g%n%n", f, f, f);  
   
      System.out.printf("使用字符串精度%n");
      System.out.printf("\t%.11s%n", s);
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
