// 图6.6: RollDieWithArray.java
// 使用数组来取代switch的掷骰子程序
import java.util.random.RandomGenerator;

public class RollDieWithArray {
   public static void main(String[] args) {
      var randomNumbers = RandomGenerator.getDefault(); 
      int[] frequency = new int[7]; // 该数组存储每一面被掷出的次数

      // 掷骰6千万次；使用点数作为数组索引
      for (int roll = 1; roll <= 60_000_000; ++roll) {
         ++frequency[randomNumbers.nextInt(1, 7)];
      } 

      System.out.printf("%s%10s%n", "点数", "次数");
   
      // 输出每个数组元素的值
      for (int face = 1; face < frequency.length; ++face) {
         System.out.printf("%4d%12d%n", face, frequency[face]);
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
