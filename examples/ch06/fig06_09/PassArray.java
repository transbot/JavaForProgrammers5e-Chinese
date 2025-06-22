// 图6.9: PassArray.java
// 将数组和单个数组元素传递给方法

public class PassArray {
   // main方法创建数组并调用modifyArray和modifyElement方法
   public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5};  // 初始化一个int数组
    
      System.out.printf(
         "传递整个数组的引用时的影响:%n" +
         "原始数组的值为:%n");

      // 输出原始数组元素
      for (int value : array) {
         System.out.printf("   %d", value);
      }
   
      modifyArray(array);  // 传递数组引用
      System.out.printf("%n%n修改后的数组值为:%n");

      // 输出修改后的数组元素
      for (int value : array) {
         System.out.printf("   %d", value);
      }
   
      System.out.printf(
         "%n%n传递单个数组元素时的影响:%n" +
         "array[3]在调用modifyElement前的值: %d%n", array[3]);
   
      modifyElement(array[3]);  // 尝试修改传递的数组元素array[3]
      System.out.printf(
         "array[3]在modifyElement完成后的值: %d%n", array[3]);
   } 
   
   // 将数组中的每个元素乘以2
   public static void modifyArray(int[] array2) {                
      for (int counter = 0; counter < array2.length; ++counter) {
         array2[counter] *= 2;  // 修改数组元素值                               
      }
   }
   
   // 将传入的实参乘以2                 
   public static void modifyElement(int element) {            
      element *= 2;  // 只修改局部变量                                      
      System.out.printf(                                      
         "modifyElement方法中的element值: %d%n", element); 
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
