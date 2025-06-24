// 图7.1: StringConstructors.java
// 调用String类的构造函数

public class StringConstructors {
   public static void main(String[] args) {
      char[] charArray = {'你', '仍', '然', '能', '闻', '到', '风', 
         '中', '的', '胭', '脂', '味'};
      var s = new String("我是那年轮上流浪的眼泪");

      // 使用String类的各种构造函数
      var s1 = new String(); // ""
      var s2 = new String(s); // "是那年轮上流浪的眼泪"
      var s3 = new String(charArray); // "你仍然能闻到风中的胭脂味"
      var s4 = new String(charArray, 9, 3); // "胭脂味"

      System.out.printf(
         "s1 = %s%ns2 = %s%ns3 = %s%ns4 = %s%n", s1, s2, s3, s4);
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
