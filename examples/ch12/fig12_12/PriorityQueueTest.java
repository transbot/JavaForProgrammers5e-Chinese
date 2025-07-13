// 图12.12: PriorityQueueTest.java
// PriorityQueue测试程序
import java.util.PriorityQueue;

public class PriorityQueueTest {
   public static void main(String[] args) {
      // 初始队列容量为11
      var queue = new PriorityQueue<Double>();

      // 向队列插入元素（入队）
      queue.offer(3.2);          
      queue.offer(9.8);          
      queue.offer(5.4);          

      System.out.print("连续获取并移除（poll）队头元素: ");

      // 显示队列中的元素
      while (!queue.isEmpty()) {
         System.out.printf("%.1f ", queue.peek()); // 查看队头元素
         queue.poll(); // 移除队头元素
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
