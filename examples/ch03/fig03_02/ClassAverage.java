// 图3.2: ClassAverage.java
// 使用哨兵控制的循环计算班级平均成绩
import java.util.Scanner; // 程序使用了Scanner类

public class ClassAverage {
   public static void main(String[] args) {
      // 创建一个Scanner对象从用户获取输入
      Scanner input = new Scanner(System.in);

      // 初始化阶段
      int total = 0; // 初始化用户输入成绩之累加和
      int gradeCounter = 0; // 初始化用户迄今为止输入的成绩数量
      
      // 处理阶段
      // 提示用户输入并读取输入的成绩
      System.out.print("输入成绩，或者输入-1退出: ");
      int grade = input.nextInt();                    

      // 一直循环迭代，直到用户输入哨兵值（-1）
      while (grade != -1) {
         total = total + grade; // 将grade累加到total上
         gradeCounter = gradeCounter + 1; // 计数器递增1

         // 提示用户输入下一个成绩并读取
         System.out.print("输入成绩，或者输入-1退出: "); 
         grade = input.nextInt();                          
      }

      // 终止阶段
      // 如果用户输入至少一个成绩...
      if (gradeCounter != 0) { 
         // 将一个操作数转型为浮点类型，从而执行浮点计算
         double average = (double) total / gradeCounter;

         // 显示总成绩和平均成绩（两位小数精度）
         System.out.printf("%n全部%d个成绩的总和是%d%n", 
            gradeCounter, total);
         System.out.printf("班级平均成绩是%.2f%n", average); 
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
