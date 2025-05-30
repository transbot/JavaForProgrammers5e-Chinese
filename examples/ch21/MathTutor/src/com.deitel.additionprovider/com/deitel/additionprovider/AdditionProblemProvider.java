// 图21.13: AdditionProblemProvider.java
// AdditionProblemProvider implementation of interface  
// ProblemProvider for the MathTutor app.
package com.deitel.additionprovider;

import java.util.random.RandomGenerator;
import com.deitel.mathtutor.spi.Problem;
import com.deitel.mathtutor.spi.ProblemProvider;

public class AdditionProblemProvider implements ProblemProvider {
   private static RandomGenerator random = RandomGenerator.getDefault();

   // returns a new addition problem
   @Override
   public Problem getProblem() {
      return new Problem(random.nextInt(10), random.nextInt(10), "+") {
         // override getResult to add the operands
         @Override
         public int getResult() {
            return getLeftOperand() + getRightOperand();
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
