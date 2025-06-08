// GuessTheNumberGame.java
// 猜数字游戏程序
import java.util.Scanner;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class GuessTheNumberGame {
   private static int answer;
   private static boolean gameOver = false; // 当前游戏是否结束？

   public static void main(String[] args) {
      // 创建一个固定种子的RandomGenerator，使程序可重现相同序列
      // 如需随机化，请将第16行替换为：
      // RandomGenerator.getDefault();
      RandomGenerator generator = 
         RandomGeneratorFactory.getDefault().create(11);
      Scanner input = new Scanner(System.in);
      boolean continuePlaying = true; // 是否开始新游戏？

      while (continuePlaying) {
         // 开始新游戏：重置gameOver标志并选择新数字
         gameOver = false;
         newGame(generator);

         // 进行当前游戏直到猜中数字
         while (!gameOver) {
            System.out.print("? ");
            checkGuess(input.nextInt());
         }

         // 询问用户是否想再玩一次
         System.out.print("是否想再玩一次（输入y或n）？ ");
         String playAgain = input.next();

         if (!playAgain.toLowerCase().equals("y")) {
            continuePlaying = false;
         }
      }
   }

   // 通过生成新的随机答案开始新游戏
   public static void newGame(RandomGenerator generator) {
      answer = generator.nextInt(1, 1001);
      System.out.printf("""
         我有一个1到1000之间的数字。
         你能猜出是多少吗？
         请输入你的第一个猜测。
         """);
   }

   // 检查用户猜测并提供反馈
   public static void checkGuess(int userGuess) {
      if (userGuess < answer) {
         System.out.println("太小了。请再试一次。");
      } 
      else if (userGuess > answer) {
         System.out.println("太大了。请再试一次。");
      } 
      else {
         gameOver = true;
         System.out.println("\n太棒了！你猜中了这个数字！");
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
