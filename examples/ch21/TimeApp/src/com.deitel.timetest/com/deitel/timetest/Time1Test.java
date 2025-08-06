// 图21.13: Time1Test.java
// 在应用程序中使用Time1对象
package com.deitel.timetest;

import com.deitel.timelibrary.Time1;

public class Time1Test {
   public static void main(String[] args) {
      // 创建并初始化Time1对象
      var time = new Time1(); // 调用Time1构造函数

      // 输出时间的字符串表示形式
      displayTime("time对象创建后", time);
      System.out.println(); 

      // 修改时间并输出更新后的时间
      time.setTime(13, 27, 6); 
      displayTime("调用setTime方法后", time);
      System.out.println(); 

      // 尝试设置非法时间值
      try {
         time.setTime(99, 99, 99); // 所有值均超出有效范围
      } 
      catch (IllegalArgumentException e) {
         System.out.printf("异常：%s%n%n", e.getMessage());
      } 

      // 设置非法值后显示时间
      displayTime("使用无效值调用setTime后", time);
   } 

   // 以24小时制和12小时制显示Time1对象
   private static void displayTime(String header, Time1 t) {
      System.out.printf("%s%n世界时间：%s%n标准时间：%s%n",
         header, t.toUniversalString(), t.toString());
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
