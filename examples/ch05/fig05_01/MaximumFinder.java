// 图5.1: MaximumFinder.java
// 接收三个double参数的自定义maximum方法
import java.util.Scanner;

public class MaximumFinder {
   public static void main(String[] args) {
      // 创建一个Scanner对象从用户获取输入
      var input = new Scanner(System.in);

      // 提示输入三个浮点值
      System.out.print(
         "连续输入三个浮点值，以空格分隔: ");
      double number1 = input.nextDouble(); // 读入第一个double
      double number2 = input.nextDouble(); // 读入第二个double
      double number3 = input.nextDouble(); // 读入第三个double

      // 判断最大值
      double result = maximum(number1, number2, number3); 

      // 显示最大值
      System.out.printf("最大值是: %.2f%n", result);
   } 

   // 返回三个double实参中最大的那一个
   public static double maximum(double x, double y, double z) {   
      double maximumValue = x; // 最开始假定x最大
   
      // 判断y是否大于maximumValue
      if (y > maximumValue) {                                     
         maximumValue = y;                                        
      }
   
      // 判断z是否大于maximumValue
      if (z > maximumValue) {                                     
         maximumValue = z;                                        
      }
   
      return maximumValue;                                        
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
