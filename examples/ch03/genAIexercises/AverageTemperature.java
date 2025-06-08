// 3.7节, Checkpoint 3: AverageTemperature.java
// 计算几个摄氏温度的平均值
import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int total = 0;
        int count = 0;
        
        System.out.print("输入一个摄氏温度，或者输入999退出: ");
        int temperature = input.nextInt();

        while (temperature != 999) {
            if (temperature >= -135 && temperature <= 100) {
                total += temperature;
                count++;
            } else {
                System.out.println("温度超出范围 (-135~100摄氏度)，请重新输入。");
            }
            System.out.print("输入一个摄氏温度，或者输入999退出: ");
            temperature = input.nextInt();
        }

        if (count > 0) {
            double average = (double) total / count;
            System.out.printf("平均温度是: %.2f\n", average);
        } else {
            System.out.println("没有输入任何温度");
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