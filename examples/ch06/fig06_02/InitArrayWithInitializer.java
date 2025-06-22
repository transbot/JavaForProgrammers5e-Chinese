// 图6.2: InitArrayWithInitializer.java
// 使用“数组初始化器”来初始化数组元素

public class InitArrayWithInitializer {
   public static void main(String[] args) {
      // 数组初始化器指定了每个元素的初始值
      int[] array = {32, 27, 64, 18, 95};  

      System.out.printf("%s%5s%n", "索引", "值"); // 列标题

      // output each array element's value 
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
