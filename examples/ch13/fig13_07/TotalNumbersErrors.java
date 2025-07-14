// 图13.7: TotalNumbersError.java
// 对List<Number>中的数字进行求和
import java.util.Arrays;
import java.util.List;

public class TotalNumbersErrors {
   public static void main(String[] args) {
      // 创建并初始化List<Integer> 
      Integer[] numbers = {1, 2, 3, 4}; // 包含整数
      List<Integer> numberList = Arrays.asList(numbers);

      // 显示numbersList 
      System.out.printf("numberList中包含: %s%n", numberList);

      // 对numbersList中的元素求和，然后显示结果
      System.out.printf("numberList中元素的总和: %.1f%n", 
         sum(numberList));
   }

   // 计算List中元素的总和
   public static double sum(List<Number> list) {
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
