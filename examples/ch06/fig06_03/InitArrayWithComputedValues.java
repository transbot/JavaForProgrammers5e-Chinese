// 图6.3: InitArrayWithComputedValues.java
// 计算要放入数组元素中的值

public class InitArrayWithComputedValues {
   public static void main(String[] args) {
      final int ARRAY_LENGTH = 5; // 声明常量
      int[] array = new int[ARRAY_LENGTH]; // 创建数组

      // 计算每个数组元素的值
      for (int counter = 0; counter < array.length; ++counter) {
         array[counter] = 2 + 2 * counter;
      }

      System.out.printf("%s%5s%n", "索引", "值"); // 列标题
   
      // 输入每个数组元素的值
      for (int counter = 0; counter < array.length; ++counter) {
         System.out.printf("%d%9d%n", counter, array[counter]);
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
