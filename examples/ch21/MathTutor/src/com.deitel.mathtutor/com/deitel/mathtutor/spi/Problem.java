// 图21.10: Problem.java
// 包含有关数学问题信息的Problem超类
package com.deitel.mathtutor.spi;

public abstract class Problem {
   private int leftOperand;
   private int rightOperand;
   private int result;
   private String operation;

   // 构造函数
   public Problem(int leftOperand, int rightOperand, String operation) {
      this.leftOperand = leftOperand;
      this.rightOperand = rightOperand;
      this.operation = operation;
   } 
   
   // 获取左操作数
   public int getLeftOperand() {return leftOperand;} 
   
   // 获取右操作数
   public int getRightOperand() {return rightOperand;} 
   
   // 获取运算
   public String getOperation() {return operation;}
   
   // 获取结果
   public abstract int getResult();
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
