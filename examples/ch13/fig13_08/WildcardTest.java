// 图13.8: WildcardTest.java
// 通配符测试程序
import java.util.Arrays;
import java.util.List;

public class WildcardTest {
   public static void main(String[] args) {
      // 创建并初始化List<Integer> 
      Integer[] integers = {1, 2, 3, 4, 5};
      List<Integer> integerList = Arrays.asList(integers);

      System.out.printf("integerList中包含: %s%n", integerList);
      System.out.printf("integerList中元素的总和: %.0f%n%n",
         sum(integerList));

      // 创建并初始化List<Double>
      Double[] doubles = {1.1, 3.3, 5.5};
      List<Double> doubleList =  Arrays.asList(doubles);

      System.out.printf("doubleList中包含: %s%n", doubleList);
      System.out.printf("doubleList中元素的总和: %.1f%n%n", 
         sum(doubleList));

      // 创建并初始化List<Number>，其中包含混合的数值类型
      Number[] numbers = {1, 2.4, 3, 4.1}; 
      List<Number> numberList = Arrays.asList(numbers);

      System.out.printf("numberList中包含: %s%n", numberList);
      System.out.printf("numberList中元素的总和: %.1f%n", 
         sum(numberList));
   }

   // 计算元素的总和；在List参数中使用了一个通配符
   public static double sum(List<? extends Number> list) {
      double total = 0; // 初始化总和

      // 计算总和
      for (Number element : list) {
         total += element.doubleValue();
      }

      return total;
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