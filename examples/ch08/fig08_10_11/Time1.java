// 图8.10: Time1.java
// Time1类使用24小时制维护时间

public class Time1 {
   private int hour; // 0~23  
   private int minute; // 0~59
   private int second; // 0~59

   // 使用世界时设置新时间值；
   // 如果时、分或秒无效则抛出异常。
   public void setTime(int hour, int minute, int second) {
      // 验证时、分、秒的有效性
      if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || 
         second < 0 || second >= 60) {
         throw new IllegalArgumentException(               
            "小时、分钟和/或秒超出范围");
      }

      this.hour = hour;
      this.minute = minute;
      this.second = second;
   } 

   // 转换为世界时间格式字符串（HH:MM:SS）
   public String toUniversalString() {
      return String.format("%02d:%02d:%02d", hour, minute, second);
   } 

   // 转换为标准时间格式字符串（H:MM:SS AM 或 PM）
   public String toString() {
      return String.format("%d:%02d:%02d %s",         
         ((hour == 0 || hour == 12) ? 12 : hour % 12),
         minute, second, (hour < 12 ? "AM" : "PM"));  
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