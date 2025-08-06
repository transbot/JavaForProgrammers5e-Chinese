// 图21.11: MathTutor.java
// 使用ProblemProvider显示数学问题的数学辅导应用
package com.deitel.mathtutor;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;
import com.deitel.mathtutor.spi.Problem;
import com.deitel.mathtutor.spi.ProblemProvider;

public class MathTutor {
   private static Scanner input = new Scanner(System.in);

   public static void main(String[] args) {
      // 获取ProblemProvider的服务加载器
      ServiceLoader<ProblemProvider> serviceLoader = 
        ServiceLoader.load(ProblemProvider.class);

      // 获取服务提供者列表
      List<Provider<ProblemProvider>> providersList = 
         serviceLoader.stream().collect(Collectors.toList());

      // 检查是否存在任何提供者
      if (providersList.isEmpty()) {
         System.out.println(
            "终止MathTutor：未找到问题提供者。");
         return;
      }
      
      boolean shouldContinue = true;
      RandomGenerator random = RandomGenerator.getDefault();

      do {
         // 随机选择一个ProblemProvider 
         ProblemProvider provider = 
            providersList.get(random.nextInt(providersList.size())).get();
         
         // 获取Problem
         Problem problem = provider.getProblem();

         // 向用户显示问题
         showProblem(problem);
      } while (playAgain());
   }   

   // 向用户显示数学问题
   private static void showProblem(Problem problem) {
      var problemStatement = String.format("%n%d %s %d 等于多少？", 
         problem.getLeftOperand(), problem.getOperation(), 
         problem.getRightOperand());
      
      // 显示问题并获取用户答案
      System.out.printf(problemStatement);
      int answer = input.nextInt();

      while (answer != problem.getResult()) {
         System.out.println("回答错误，请重试。");
         System.out.printf(problemStatement);
         answer = input.nextInt();
      }

      System.out.println("回答正确！");
   }

   // 是否继续？
   private static boolean playAgain() {
      System.out.printf("%n继续尝试？输入y继续，n终止：");
      String response = input.next();

      return response.toLowerCase().startsWith("y");
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
