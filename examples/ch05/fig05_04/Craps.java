// 图5.4: Craps.java
// 用于模拟“双骰子”游戏的Craps类
import java.util.random.RandomGenerator;

public class Craps {
    // 获取默认的RandomGenerator对象，供rollDice方法使用
    private static final RandomGenerator randomNumbers =
        RandomGenerator.getDefault();

    // 定义游戏状态的枚举类型
    private enum Status {CONTINUE, WON, LOST};

    // 玩一局双骰子游戏
    public static void main(String[] args) {
        int myPoint = 0;   // 初始化第一次掷骰未分胜负时的“目标点数”
        Status gameStatus; // 可用于存储游戏状态：CONTINUE（继续）、WON（获胜）或LOST（失败）

        int sumOfDice = rollDice(); // 第一次掷骰子

        // 根据第一次掷出的点数和，决定游戏状态和“目标点数” 
        switch (sumOfDice) {
            case 7:  // 第一次掷出7点，获胜
            case 11: // 第一次掷出11点，获胜
                gameStatus = Status.WON;
                break;
            case 2:  // 第一次掷出2点，失败
            case 3:  // 第一次掷出3点，失败
            case 12: // 第一次掷出12点，失败
                gameStatus = Status.LOST;
                break;
            default: // 未分胜负，记下“目标点数”
                gameStatus = Status.CONTINUE; // 游戏尚未结束  
                myPoint = sumOfDice; // 记下目标点数
                System.out.printf("目标点数是%d%n", myPoint);
                break; 
        }

        // 当游戏尚未结束时，持续循环
        while (gameStatus == Status.CONTINUE) { // 即游戏状态既不是WON也不是LOST
            sumOfDice = rollDice(); // 再次掷骰

            // 判断游戏状态
            if (sumOfDice == myPoint) { // 掷出目标点数，获胜
                gameStatus = Status.WON;
            } 
            else { 
                if (sumOfDice == 7) { // 在掷出目标点数前掷出了7，失败
                    gameStatus = Status.LOST;
                } 
            } 
        } 

        // 显示获胜或失败的消息
        if (gameStatus == Status.WON) {
            System.out.println("玩家赢");
        } 
        else {
            System.out.println("玩家输");
        } 
    } 

    // 掷骰子，计算点数和，并显示结果
    public static int rollDice() {
        // 随机选择骰子的点数
        int die1 = randomNumbers.nextInt(1, 7); // 第一枚骰子的点数
        int die2 = randomNumbers.nextInt(1, 7); // 第二枚骰子的点数

        int sum = die1 + die2; // 两枚骰子的点数和

        // 显示本次掷骰的结果
        System.out.printf("玩家掷出了%d + %d = %d点%n", die1, die2, sum);

        return sum; 
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
