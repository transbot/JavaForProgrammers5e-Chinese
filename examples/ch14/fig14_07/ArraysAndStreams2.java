// 图14.7: ArraysAndStreams2.java
// 使用字符串数组演示Lambda表达式和流
import java.util.Arrays;

public class ArraysAndStreams2 {
   public static void main(String[] args) {
      String[] strings = 
         {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

      // 显示原始字符串
      System.out.printf("原始字符串：%s%n", Arrays.asList(strings));

      // 转换为大写的字符串
      System.out.printf("大写字符串：%s%n",
         Arrays.stream(strings)             
               .map(String::toUpperCase)   
               .toList());

      // 小于"n"的字符串升序排序（不区分大小写）
      System.out.printf("小于n的字符串升序排序（不区分大小写）：%s%n",
         Arrays.stream(strings)                            
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER)
               .toList());             

      // 小于"n"的字符串降序排序（不区分大小写）
      System.out.printf("小于n的字符串降序排序（不区分大小写）：%s%n",
         Arrays.stream(strings)
               .filter(s -> s.compareToIgnoreCase("n") < 0)
               .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
               .toList());
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
