// 图13.6: StackTest2.java
// 将泛型Stack对象传递给泛型方法
import java.util.NoSuchElementException;
      
public class StackTest2 {
   public static void main(String[] args) {
      Double[] doubleElements = {1.1, 2.2, 3.3, 4.4, 5.5};
      Integer[] integerElements = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      
      // 创建一个Stack<Double>和一个Stack<Integer>
      Stack<Double> doubleStack = new Stack<>(5); 
      Stack<Integer> integerStack = new Stack<>(); 

      // 将doubleElements的元素压入doubleStack         
      testPush("doubleStack", doubleStack, doubleElements);       
      testPop("doubleStack", doubleStack); // 从doubleStack出栈
 
      // 将integerElements的元素压入integerStack          
      testPush("integerStack", integerStack, integerElements);       
      testPop("integerStack", integerStack); // 从integerStack出栈
   }

   // 泛型方法testPush将元素入栈
   public static <E> void testPush(String name, Stack<E> stack,
      E[] elements) {
      System.out.printf("%n以下元素向%s入栈：%n   ", name);

      // 元素入栈
      for (E element : elements) {
         System.out.printf("%s ", element);
         stack.push(element); // 元素入栈
      }
   } 

   // 泛型方法testPop从栈中出栈元素
   public static <E> void testPop(String name, Stack<E> stack) {
      // 元素出栈
      try {
         System.out.printf("%n以下元素从%s出栈：%n   ", name);
         E popValue; // 用于存储出栈的元素

         // 移除栈中的所有元素
         while (true) {
            popValue = stack.pop(); 
            System.out.printf("%s ", popValue);
         }
      } 
      catch(NoSuchElementException noSuchElementException) {
         System.out.println();
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
