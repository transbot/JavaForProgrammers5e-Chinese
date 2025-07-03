// 图8.12: MemberAccessTest.java
// 不能从外部访问Time1类的私有成员
public class MemberAccessTest {
   public static void main(String[] args) {
      var time = new Time1(); // 创建并初始化一个Time1对象

      time.hour = 7;    // 错误: hour是Time1私有的
      time.minute = 15; // 错误: minute是Time1私有的
      time.second = 30; // 错误: second是Time1私有的
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
