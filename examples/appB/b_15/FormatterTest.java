// 图B.15: FormatterTest.java
// 使用Formatter类格式化输出
import java.util.Formatter;

public class FormatterTest {
   public static void main(String[] args) {
      // 创建一个Formatter对象并格式化输出
      Formatter formatter = new Formatter();           
      formatter.format("%d = %#o = %#X", 10, 10, 10);

      System.out.println(formatter.toString()); 
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
