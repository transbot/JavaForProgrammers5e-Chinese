// 图3.3: Analysis.java
// 使用嵌套控制语句分析考试结果
import java.util.Scanner; // class uses class Scanner

public class Analysis {
   public static void main(String[] args) {
      // 创建一个Scanner对象从用户获取输入
      Scanner input = new Scanner(System.in);

      // 声明的同时初始化变量
      int passes = 0;                          
      int failures = 0;                        
      int studentCounter = 1;                  

      // 使用读数器控制的循环处理10名学生的考试结果
      while (studentCounter <= 10) {
         // 提示用户输入值
         System.out.print("输入结果(1 = 通过，2 = 未通过): ");
         int result = input.nextInt(); 

         // if...else嵌套在while中
         if (result == 1) {                           
            passes = passes + 1;                      
         }                                            
         else {                                       
            failures = failures + 1;                  
         }                                            

         // 递增studentCounter，使循环最终能终止
         studentCounter = studentCounter + 1;  
      } 

      // 终止阶段; 准备并显示结果
      System.out.printf("通过数: %d%n未通过数: %d%n", passes, failures);

      // 判断是否超过8名学生通过考试
      if (passes > 8) {                               
         System.out.println("给老师发奖金!");  
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
