// 图13.1: OverloadedMethods.java
// 使用重载方法打印数组元素

public class OverloadedMethods {
   public static void main(String[] args) {
      // 创建Integer和Double数组
      Integer[] integerArray = {1, 2, 3, 4, 5, 6};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};

      System.out.printf("整数数组integerArray包含: ");
      printArray(integerArray); // 传入Integer数组
      System.out.printf("双精度数组doubleArray包含: ");
      printArray(doubleArray); // 传入Double数组
   }

   // 打印Integer数组的方法
   public static void printArray(Integer[] inputArray) {
      // 显示数组元素
      for (Integer element : inputArray) {
         System.out.printf("%s ", element);
      }

      System.out.println();
   }

   // 打印Double数组的方法
   public static void printArray(Double[] inputArray) {
      // 显示数组元素
      for (Double element : inputArray) {
         System.out.printf("%s ", element);
      }

      System.out.println();
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
