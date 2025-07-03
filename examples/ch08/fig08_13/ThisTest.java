// 图8.13: ThisTest.java
// 隐式和显式使用 this 来引用对象的成员。

public class ThisTest {
   public static void main(String[] args) {
      var time = new SimpleTime(15, 30, 19);
      System.out.println(time.buildString());
   } 
} 

// SimpleTime类演示了如何使用this引用
class SimpleTime {
   private int hour;   // 0-23
   private int minute; // 0-59
   private int second; // 0-59 

   // 如果构造函数的参数（形参）名与
   // 实例变量名相同，那么需要使用 
   // this引用来区分这些名称。
   public SimpleTime(int hour, int minute, int second) {
      this.hour = hour;     // 设置this对象的hour      
      this.minute = minute; // 设置this对象的minute
      this.second = second; // 设置this对象的second
   }

   // 使用显式和隐式this来调用toUniversalString
   public String buildString() {
      return String.format("%24s: %s%n%24s: %s", 
         "this.toUniversalString()", this.toUniversalString(),
         "toUniversalString()", toUniversalString());
   } 

   // 转换为世界时间格式字符串（HH:MM:SS）
   public String toUniversalString() {
      // 此处访问实例变量时，其实不需要
      // “this.”，因为该方法没有与实例
      // 变量同名的局部变量。
      return String.format("%02d:%02d:%02d", 
         this.hour, this.minute, this.second);
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
