// 图4.6: LetterGrades.java
// LetterGrades类用switch语句统计每个字母成绩的学生人数
import java.util.Scanner; 

public class LetterGrades {
   public static void main(String[] args) {
      int total = 0; // 成绩总和
      int gradeCounter = 0; // 已输入成绩数
      int aCount = 0; // 成绩A的数量
      int bCount = 0; // 成绩B的数量
      int cCount = 0; // 成绩C的数量
      int dCount = 0; // 成绩D的数量
      int fCount = 0; // 成绩F的数量

      Scanner input = new Scanner(System.in);

      System.out.println("""
         输入0~100的整数成绩。
         输入文件结束符（EOF）来终止输入:
            macOS/Linux：Ctrl+D（需在新行开头输入）；
            Windows：按Ctrl+Z（需在新行开头输入）。""");
 
      // 一直循环，直到用户输入文件结束符（EOF）
      while (input.hasNext()) {
         int grade = input.nextInt(); // 读取grade
         total += grade; // 将grade累加到total上
         ++gradeCounter; // 递增grade数量
         
         //  递增相应的字母成绩计数器
         switch (grade / 10) {                          
            case 10:  // 成绩为90~100分（含）
            case 9:   
               ++aCount;                               
               break; // 退出switch                  
            case 8: // 成绩为80~89分
               ++bCount;
               break; // 退出switch                  
            case 7: // 成绩为70~79分
               ++cCount;
               break; // 退出switch
            case 6: // 成绩为60-69分
               ++dCount;
               break; // 退出switch
            default: // 成绩小于60分
               ++fCount;
               break; // 可选; 强制退出switch
         }
      }  

      // 显示成绩报告
      System.out.printf("%n成绩报告:%n");

      // 如果用户输入至少一个成绩……
      if (gradeCounter != 0) {
         // 计算输入的所有成绩的平均值
         double average = (double) total / gradeCounter;  

         // 输出成绩报告
         System.out.printf("全部%d个成绩的总和是%d分%n", 
            gradeCounter, total);
         System.out.printf("班级平均成绩是%.2f分%n", average);
         System.out.printf("%n%s%n%s%d%n%s%d%n%s%d%n%s%d%n%s%d%n", 
            "每个字母成绩的学生数是:", 
            "A: ", aCount,  // 显示成绩A的人数
            "B: ", bCount,  // 显示成绩B的人数
            "C: ", cCount,  // 显示成绩C的人数
            "D: ", dCount,  // 显示成绩D的人数
            "F: ", fCount); // 显示成绩F的人数
      }
      else { // 没有输入成绩，输出对应的消息
         System.out.println("没有输入任何成绩");
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
