// 图3.1: ClassAverage.java
// 使用计数器控制的循环计算班级平均成绩
import java.util.Scanner; // 程序使用了Scanner类

public class ClassAverage {
   public static void main(String[] args) {
      // 创建一个Scanner对象从用户获取输入
      Scanner input = new Scanner(System.in);

      // 初始化阶段
      int total = 0;  // 初始化用户输入成绩之累加和
      int gradeCounter = 1; // 初始化下一个输入的成绩的编号
   
      // 在处理阶段，我们使用计数器控制的循环
      while (gradeCounter <= 10) { // 循环10次
         System.out.print("输入成绩: "); // 提示输入下一个成绩
         int grade = input.nextInt(); // 输入成绩
         total = total + grade; // 将grade累加到total上
         gradeCounter = gradeCounter + 1; // 计数器1
      } 
   
      // 终止阶段
      int average = total / 10; // 整数除法的结果也是整数

      // 显示总成绩和平均成绩
      System.out.printf("%n全部10个成绩的总和是%d%n", total);
      System.out.printf("班级平均成绩是%d%n", average);
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
