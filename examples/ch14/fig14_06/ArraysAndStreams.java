// 图14.6: ArraysAndStreams.java
// 使用Integer数组演示Lambda表达式和流
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {
   public static void main(String[] args) {
      Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

      // 显示原始值
      System.out.printf("原始值：%s%n", Arrays.asList(values));

      // 使用流对值进行升序排序
      System.out.printf("排序后的值：%s%n", 
         Arrays.stream(values)              
               .sorted()                    
               .collect(Collectors.toList()));

      // 过滤出大于4的值
      List<Integer> greaterThan4 =           
         Arrays.stream(values)               
               .filter(value -> value > 4)   
               .toList();
      System.out.printf("大于4的值：%s%n", greaterThan4);

      // 过滤出大于4的值，然后对结果进行排序
      System.out.printf("大于4的排序值：%s%n",
         Arrays.stream(values)              
               .filter(value -> value > 4)  
               .sorted()                    
               .toList());

      // 使用流来排序的greaterThan4列表
      System.out.printf(
         "大于4的值（使用流来升序排序）：%s%n",
         greaterThan4.stream()              
               .sorted()                    
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
