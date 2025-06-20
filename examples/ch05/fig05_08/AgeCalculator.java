// 图5.8: AgeCalculator.java
// 使用日期/时间API来计算用户从出生至今的总时长
// 并判断其出生当天是星期几
import java.time.Duration; 
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class AgeCalculator {
   public static void main(String[] args) {
      var input = new Scanner(System.in);

      // 输入用户的生日，并将其转换为一个LocalDate对象
      System.out.print("请输入你的生日(格式yyyy-MM-dd): ");
      var birthday = LocalDate.parse(input.nextLine());

      // 输入用户的出生时间，并将其转换为一个LocalTime对象
      System.out.print("请输入你的出生时间(格式HH:mm): ");
      var birthTime = LocalTime.parse(input.nextLine());

      // 将生日和出生时间合并为一个LocalDateTime对象
      var birthDateTime = LocalDateTime.of(birthday, birthTime);

      // 获取当前的日期和时间，作为一个LocalDateTime对象
      var now = LocalDateTime.now();

      // 显示日期和时间
      displayDatesAndTimes(birthDateTime, now); 

      // 计算以年、月、日为单位的日期差
      var period = Period.between(birthday, now.toLocalDate());
      
      // 计算以时、分、秒为单位的时间差
      var duration = Duration.between(birthDateTime, now);
      
      // 显示用户出生当天是星期几
      System.out.printf("你出生当天是%s%n", 
         birthday.getDayOfWeek().getDisplayName(
            TextStyle.FULL, Locale.getDefault()));

      // 显示年龄的各个组成部分
      System.out.printf("""
            你至今已度过了%d年%d个月零%d天
            
            总计月数:      %d
            总计天数:      %d
            总计小时数:    %d
            总计分钟数:    %d
            总计秒数:      %d
            """, 
            period.getYears(), period.getMonths(), period.getDays(), 
            period.toTotalMonths(), 
            birthday.until(now.toLocalDate(), ChronoUnit.DAYS), 
            duration.toHours(), duration.toMinutes(), duration.toSeconds());
   }

   // 根据用户的区域设置来格式化并显示出生日期/时间和当前日期/时间
   public static void displayDatesAndTimes(
      LocalDateTime birth, LocalDateTime current) {

      // 准备一个格式化器，用于根据用户的区域设置来显示日期和时间
      var formatter =
         DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

      // 显示格式化后的日期和时间
      System.out.printf("%n出生日期/时间: %s%n", 
         birth.format(formatter));
      System.out.printf("当前日期/时间: %s%n%n",
         current.format(formatter));
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
