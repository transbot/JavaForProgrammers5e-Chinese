// 图4.7: BreakTest.java
// 用break语句退出for
public class BreakTest {
   public static void main(String[] args) {
      int count; // 在进入循环前声明控制变量，以便在循环终止后也能使用
      
      for (count = 1; count <= 10; ++count) { // loop 10 times
         if (count == 5) {
            break; // count为5就终止循环
         }

         System.out.printf("%d ", count);
      } 

      System.out.printf("%n当count = %d时，循环终止%n", count);
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
