// 图7.20: RegexReplacement.java
// 正则表达式替换
public class RegexReplacement {
   public static void main(String[] args) {
      // 制表符替换为逗号
      String s1 = "一\t二\t三\t四";
      System.out.printf("原始字符串: %s%n", s1);
      System.out.printf("用逗号替换制表符后的新字符串: %s%n", 
         s1.replaceAll("\\t", ","));
   }
}


/*
 **************************************************************************
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
 **************************************************************************
*/


