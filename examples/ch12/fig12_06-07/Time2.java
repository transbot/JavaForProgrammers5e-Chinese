// 图8.14: Time2.java
// 包含重载构造函数的Time2类

public class Time2 {
   private int hour;   // 0~23
   private int minute; // 0~59
   private int second; // 0~59

   // Time2的无参构造函数：
   // 将每个实例变量初始化为零
   public Time2() {
      this(0, 0, 0); // 委托给三参数构造函数
   } 

   // Time2构造函数：提供小时，分钟和秒默认为0
   public Time2(int hour) {                                               
      this(hour, 0, 0);   // 委托给三参数构造函数
   } 

   // Time2构造函数：提供小时和分钟，秒默认为0
   public Time2(int hour, int minute) {
      this(hour, minute, 0);     // 委托给三参数构造函数
   } 

   // Time2构造函数：提供小时、分钟和秒
   public Time2(int hour, int minute, int second) {                    
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("小时必须是0~23");
      } 

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("分钟必须是0~59");
      } 

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("秒必须是0~59");
      } 

      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   } 

   // Time2构造函数：提供另一个Time2对象
   public Time2(Time2 time) {                                   
      // 委托给三参数构造函数
      this(time.hour, time.minute, time.second);
   } 

   // 赋值方法（setter）
   // 使用世界时间设置新时间值
   // 校验数据有效性
   public void setTime(int hour, int minute, int second) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("小时必须是0~23");
      } 

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("分钟必须是0~59");
      } 

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("秒必须是0~59");
      } 

      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   } 

   // 校验并设置小时
   public void setHour(int hour) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("小时必须是0~23");
      }

      this.hour = hour;
   } 

   // 校验并设置分钟
   public void setMinute(int minute) {
      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("分钟必须是0~59");
      }

      this.minute = minute; 
   } 

   // 校验并设置秒
   public void setSecond(int second) {
      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("秒必须是0~59");
      }

      this.second = second;
   } 

   // 取值方法（getter）
   // 获取小时值
   public int getHour() {return hour;}

   // 获取分钟值
   public int getMinute() {return minute;} 

   // 获取秒值
   public int getSecond() {return second;}   

   // 转换为世界时间格式字符串 (HH:MM:SS)
   public String toUniversalString() {
      return String.format("%02d:%02d:%02d", 
         getHour(), getMinute(), getSecond());
   } 

   // 转换为标准时间格式字符串 (H:MM:SS AM 或 PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s", 
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
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
