// 6.10节, 生成式AI练习: CoinFlipper.java
// 统计抛硬币结果
import java.util.random.RandomGenerator;

public class CoinFlipper {
   public static void main(String[] args) {
      RandomGenerator randomNumbers = RandomGenerator.getDefault();

      // 代表正面和反面的常量，0代表正面，1代表反面 
      final int HEADS = 0;
      final int TAILS = 1;

      // frequency[0]存储正面次数，frequency[1]存储反面次数
      int[] frequency = new int[2]; 

      // 模拟抛100次硬币
      for (int counter = 0; counter < 100; ++counter) {
         ++frequency[randomNumbers.nextInt(2)];
      }

      System.out.printf("正面次数: %d%n", frequency[HEADS]);
      System.out.printf("反面次数: %d%n", frequency[TAILS]);
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
