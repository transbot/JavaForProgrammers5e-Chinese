// 图13.4: Stack.java
// Stack泛型类声明
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<E> {
   private final ArrayList<E> elements; // 用ArrayList来存储栈中的元素

   // 无参构造函数创建默认容量的栈
   public Stack() {
      this(10); // 默认栈大小
   }
   
   // 有参构造函数创建指定容量的栈
   public Stack(int capacity) {
      int initCapacity = capacity > 0 ? capacity : 10; // 校验容量
      elements = new ArrayList<E>(initCapacity);       // 创建ArrayList
   } 

   // 将元素压入栈顶
   public void push(E pushValue) {
      elements.addLast(pushValue); // pushValue入栈
   } 

   // 栈非空时返回栈顶元素；否则抛出异常
   public E pop() {
      if (elements.isEmpty()) { // 如果栈为空
         throw new NoSuchElementException("栈为空，没有可以出栈的元素");
      } 

      // 移除并返回栈顶元素
      return elements.removeLast(); 
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
