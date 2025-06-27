// 图7.7: StringConcatenation.java
// String的concat方法

public class StringConcatenation {
   public static void main(String[] args) {
      String s1 = "红颜易老";
      String s2 = "转眼桑田泛清波";

      System.out.printf("s1 = %s%ns2 = %s%n%n", s1, s2);
      System.out.printf(
         "s1.concat(s2)的结果 = %s%n", s1.concat(s2));
      System.out.printf("连接后的s1 = %s%n", s1);
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
