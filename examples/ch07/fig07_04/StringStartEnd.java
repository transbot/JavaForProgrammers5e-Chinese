// 图7.4: StringStartEnd.java
// 演示String类的startsWith和endsWith方法

public class StringStartEnd {
   public static void main(String[] args) {
      String[] strings = {"started", "starting", "ended", "ending"};

      // 测试startsWith方法
      for (String string : strings) {
         if (string.startsWith("st")) {
            System.out.printf("\"%s\"以\"st\"开头%n", string);
         } 
      } 

      System.out.println();

      // 从位置2开始测试startsWith方法
      for (String string : strings) {
         if (string.startsWith("art", 2)) {
            System.out.printf(
               "\"%s\"在位置2以\"art\"开头%n", string);
         } 
      } 

      System.out.println();

      // 测试endsWith方法
      for (String string : strings) {
         if (string.endsWith("ed")) {
            System.out.printf("\"%s\"以\"ed\"结尾%n", string);
         } 
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
