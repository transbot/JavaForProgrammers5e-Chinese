// 图4.8: ContinueTest.java
// 用continue语句结束for语句的一次迭代
public class ContinueTest {
   public static void main(String[] args) {
      for (int count = 1; count <= 10; ++count) { // loop 10 times
         if (count == 5) {
            continue; // 如果count等于5，就跳过循环体剩余的代码
         } 

         System.out.printf("%d ", count);
      } 

      System.out.printf("%n使用continue跳过打印5的操作%n");
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
