// 图6.5: BarChart.java
// 条形图打印程序

public class BarChart {
   public static void main(String[] args) {
      int[] distribution = {0, 0, 0, 0, 0, 0, 1, 2, 4, 2, 1};

      System.out.println("成绩分布:");

      // 遍历distribution数组，为每个元素输出一个条形
      for (int counter = 0; counter < distribution.length; ++counter) {
         // 输出条形图的标签（例如 "00~09: ", ..., "90~99: ", "100: "）
         if (counter == 10) {
            System.out.printf("%5d: ", 100);
         } 
         else {
            System.out.printf("%02d~%02d: ", 
               counter * 10, counter * 10 + 9); 
         } 

         // 打印星号条
         for (int stars = 0; stars < distribution[counter]; ++stars) {
            System.out.print("*");                           
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
