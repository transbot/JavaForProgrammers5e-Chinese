// 图4.3: Sum.java
// 用for语句累加偶数

public class Sum {
   public static void main(String[] args) {
      int total = 0; 

      // 累加2~20的偶数
      for (int number = 2; number <= 20; number += 2) {
         total += number;                              
      }

      System.out.printf("2~20的偶数之和是%d%n", total);
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
