// 图6.1: InitArray.java
// int数组的元素默认初始化为0

public class InitArray {
   public static void main(String[] args) {
      // 声明数组变量array，并用一个数组对象来初始化它
      int[] array = new int[5]; // 创建数组对象

      System.out.printf("%s%6s%n", "索引", "值"); // 列标题
   
      // 输出每个数组元素的值                    
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
