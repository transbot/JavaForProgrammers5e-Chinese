// 3.8节, Checkpoint 3: OddOrEven.java
// 判断输入的整数是奇数还是偶数
import java.util.Scanner;

public class OddOrEven {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int counter = 1;

      while (counter <= 3) {
         System.out.print("输入一个整数: ");
         int number = input.nextInt();

         if (number % 2 == 0) {
            System.out.printf("%d是偶数%n", number);
         } 
         else {
            System.out.printf("%d是奇数%n", number);
         }

         counter = counter + 1;
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
