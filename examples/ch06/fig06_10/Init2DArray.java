// 图6.10: Init2DArray.java
// 初始化二维数组

public class Init2DArray {
   // 创建并输出二维数组
   public static void main(String[] args) {
      int[][] array1 = {{1, 2, 3}, {4, 5, 6}};  
      int[][] array2 = {{1, 2}, {3}, {4, 5, 6}};

      System.out.println("array1中的值（逐行输出）:");
      outputArray(array1); // 逐行显示array1
   
      System.out.printf("%narray2中的值（逐行输出）:%n");
      outputArray(array2); // 逐行显示array2
   } 

   // 输出二维数组的行和列
   public static void outputArray(int[][] array) {
      // 遍历数组行
      for (int row = 0; row < array.length; ++row) {                 
         // 遍历当前行的列
         for (int column = 0; column < array[row].length; ++column) {
            System.out.printf("%d  ", array[row][column]);           
         }                                                           
                                                                     
         System.out.println();                                       
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
