// 图7.6: Substring.java
// String类的substring方法

public class Substring {
   public static void main(String[] args) {
      String letters = "零壹贰叁肆伍陆柒捌玖拾佰仟零壹贰叁肆伍陆柒捌玖拾佰仟";

      // 测试substring方法
      System.out.printf("从索引20开始到末尾的子串是\"%s\"%n",
         letters.substring(20));
      System.out.printf("%s\"%s\"%n", 
         "从索引3开始到索引6（不包括6）的子串是",
         letters.substring(3, 6));
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
