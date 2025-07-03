// 8.13节, 生成式AI练习: Date.java
// 针对中文地区的语言文化习惯修改本节的代码。
// 例如，将日期更改为年/月/日，将人名修改为姓在前，名在后。

// Date类声明
public class Date {
   private int month; // 1~12
   private int day;   // 1~31，具体视月份而定
   private int year;  // 任意年份

   private static final int[] daysPerMonth = 
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   // 构造函数：在给定年份下，确认月份和日期的值是否合法
   public Date(int month, int day, int year) {
      // 检查月份是否在有效范围内
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException(
            "月份(" + month + ")必须是1~12");
      }

      // 检查日期是否在该月份的有效范围内
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
         throw new IllegalArgumentException("日期(" + day + 
            ")超出指定月份和年份的有效范围");
      }

      // 如果是2月29日，检查是否为闰年
      if (month == 2 && day == 29 && !(year % 400 == 0 || 
           (year % 4 == 0 && year % 100 != 0))) {
         throw new IllegalArgumentException("日期(" + day +
            ")超出指定月份和年份的有效范围");
      }
   
      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf("Date对象构造函数创建日期：%s%n", this);
   } 
   
   // 返回格式为"年/月/日"的字符串
   public String toString() {
      return String.format("%d/%d/%d", year, month, day); 
   } 
}