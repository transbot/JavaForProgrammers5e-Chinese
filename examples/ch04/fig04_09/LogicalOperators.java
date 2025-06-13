// 图4.9: LogicalOperators.java
// 条件/逻辑操作符真值表

public class LogicalOperators {
   public static void main(String[] args) {
      // 创建&&(条件AND)操作符的真值表
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "条件AND (&&)", "false && false", (false && false),
         "false && true", (false && true), 
         "true && false", (true && false),
         "true && true", (true && true));

      // 创建||(条件OR)操作符的真值表
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "条件OR(||)", "false || false", (false || false),
         "false || true", (false || true),
         "true || false", (true || false),
         "true || true", (true || true));

      // 创建&(逻辑AND)操作符的真值表
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "逻辑AND(&)", "false & false", (false & false),
         "false & true", (false & true),
         "true & false", (true & false),
         "true & true", (true & true));

      // 创建|(逻辑OR)操作符的真值表
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "逻辑OR(|)",
         "false | false", (false | false),
         "false | true", (false | true),
         "true | false", (true | false),
         "true | true", (true | true));

      // 创建^(逻辑XOR)操作符的真值表
      System.out.printf("%s%n%s: %b%n%s: %b%n%s: %b%n%s: %b%n%n",
         "逻辑XOR(^)", 
         "false ^ false", (false ^ false),
         "false ^ true", (false ^ true),
         "true ^ false", (true ^ false),
         "true ^ true", (true ^ true));

      // 创建!(逻辑非/逻辑取反)操作符的真值表
      System.out.printf("%s%n%s: %b%n%s: %b%n", "逻辑非/逻辑取反(!)",
         "!false", (!false), "!true", (!true));
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
