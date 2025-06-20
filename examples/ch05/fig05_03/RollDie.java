// 图5.3: RollDie.java
// 模拟掷六面骰子6000万次
import java.util.random.RandomGenerator;

public class RollDie {
   public static void main(String[] args) {
      // 用randomNumbers对象生成随机数
      RandomGenerator randomNumbers = RandomGenerator.getDefault(); 

      int frequency1 = 0; // 掷出1点的次数
      int frequency2 = 0; // 掷出2点的次数
      int frequency3 = 0; // 掷出3点的次数
      int frequency4 = 0; // 掷出4点的次数
      int frequency5 = 0; // 掷出5点的次数
      int frequency6 = 0; // 掷出6点的次数
   
      // 统计6000万次掷骰结果
      for (int roll = 1; roll <= 60_000_000; ++roll) {
         int face = randomNumbers.nextInt(1, 7); // 生成1~6的随机整数
   
         // 根据点数来决定递增哪个计数器
         switch (face) {
            case 1 -> ++frequency1; // 递增点数1的计数器
            case 2 -> ++frequency2; // 递增点数2的计数器
            case 3 -> ++frequency3; // 递增点数3的计数器
            case 4 -> ++frequency4; // 递增点数4的计数器
            case 5 -> ++frequency5; // 递增点数5的计数器
            case 6 -> ++frequency6; // 递增点数6的计数器
         } 
      } 

      System.out.println("点数\t次数"); // 列标题
      System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n",
         frequency1, frequency2, frequency3, frequency4,
         frequency5, frequency6);
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
