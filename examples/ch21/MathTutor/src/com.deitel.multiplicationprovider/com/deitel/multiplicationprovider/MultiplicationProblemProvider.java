// 图21.15: MultiplicationProblemProvider.java
// MathTutor应用程序ProblemProvider接口的
// MultiplicationProblemProvider实现
package com.deitel.multiplicationprovider;

import java.util.random.RandomGenerator;
import com.deitel.mathtutor.spi.Problem;
import com.deitel.mathtutor.spi.ProblemProvider;

public class MultiplicationProblemProvider implements ProblemProvider {
   private static RandomGenerator random = RandomGenerator.getDefault();

   // 返回一道新的乘法题
   @Override
   public Problem getProblem() {
      return new Problem(random.nextInt(10), random.nextInt(10), "*") {
         // 重写getResult使两个操作数相乘
         @Override
         public int getResult() {
            return getLeftOperand() * getRightOperand();
         }
      };
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
