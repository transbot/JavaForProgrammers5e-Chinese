// 图10.6: AssertTest.java
// 使用assert来判断值是否在范围内
import java.util.Scanner;

public class AssertTest {
   public static void main(String[] args) {
      var input = new Scanner(System.in);
      
      System.out.print("请输入0到10之间的数字: ");
      int number = input.nextInt();
      
      // 断言该值>=0且<=10
      assert (number >= 0 && number <= 10) : "输入错误: " + number;
      
      System.out.printf("您输入的是%d%n", number);
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
