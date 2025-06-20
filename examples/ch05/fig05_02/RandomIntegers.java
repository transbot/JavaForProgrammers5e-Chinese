// 图5.2: RandomIntegers.java
// 模拟掷六面骰子10次
import java.util.random.RandomGenerator; 

public class RandomIntegers {
   public static void main(String[] args) {
      // 用randomNumbers对象生成随机数
      RandomGenerator randomNumbers = RandomGenerator.getDefault(); 

      // 循环10次
      for (int counter = 1; counter <= 10; ++counter) {
         // 生成1~6的随机整数
         int face = randomNumbers.nextInt(1, 7);

         System.out.printf("%d  ", face); // 显示生成的值
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
