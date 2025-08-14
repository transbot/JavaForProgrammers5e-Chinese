// 图13.5: StackTest.java
// Stack泛型类测试程序
import java.util.NoSuchElementException;

public class StackTest {
   public static void main(String[] args) {
      double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      int[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      // 创建一个Stack<Double>和一个Stack<Integer>
      var doubleStack = new Stack<Double>(5);   
      var integerStack = new Stack<Integer>();  

      // 将doubleElements的元素压入doubleStack
      testPushDouble(doubleStack, doubleElements); 
      testPopDouble(doubleStack); // 从doubleStack出栈

      // 将integerElements的元素压入integerStack
      testPushInteger(integerStack, integerElements); 
      testPopInteger(integerStack); // 从integerStack出栈
   } 

   // 测试double栈的push方法
   private static void testPushDouble(
      Stack<Double> stack, double[] values) {
      System.out.printf("%n以下元素向doubleStack入栈：%n   ");

      // 元素入栈
      for (double value : values) {
         System.out.printf("%.1f ", value);
         stack.push(value); // 向doubleStack入栈
      }
   }

   // 测试double栈的pop方法
   private static void testPopDouble(Stack<Double> stack) {
      // 从栈弹出元素
      try {
         System.out.printf("%n以下元素从doubleStack出栈：%n   ");
         double popValue; // 用于存储出栈的元素

         // 移除栈中的所有元素
         while (true) {
            popValue = stack.pop(); // 从doubleStack出栈
            System.out.printf("%.1f ", popValue); 
         } 
      }
      catch(NoSuchElementException noSuchElementException) {
         System.err.println();
         noSuchElementException.printStackTrace();
      } 
   }

   // 测试integerStack栈的push方法
   private static void testPushInteger(
      Stack<Integer> stack, int[] values) {
      System.out.printf("%n以下元素向integerStack入栈：%n   ");

      // 元素入栈
      for (int value : values) {
         System.out.printf("%d ", value);
         stack.push(value); // 向integerStack入栈
      } 
   }

   // 测试integerStack栈的pop方法
   private static void testPopInteger(Stack<Integer> stack) {
      // 元素出栈
      try {
         System.out.printf("%n以下元素从integerStack出栈：%n   ");
         int popValue; // 用于存储出栈的元素

         // 从栈中移除所有元素
         while (true) {
            popValue = stack.pop(); // 从intStack出栈
            System.out.printf("%d ", popValue);
         } 
      } 
      catch(NoSuchElementException noSuchElementException) {
         System.err.println();
         noSuchElementException.printStackTrace();
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