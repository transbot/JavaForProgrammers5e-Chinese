// 图18.9: BlockingBuffer.java
// 使用ArrayBlockingQueue创建同步缓冲区
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingBuffer implements Buffer {
   // BlockingBuffer使用ArrayBlockingQueue管理同步
   private final ArrayBlockingQueue<Integer> buffer = 
      new ArrayBlockingQueue<>(1);
   
   // 将值放入缓冲区
   @Override
   public void blockingPut(int value) throws InterruptedException {
      buffer.put(value); // 将值放入缓冲区
      System.out.printf("%s%2d\t%s%d%n", "生产者写入 ", value,
         "占用的缓冲区单元数量: ", buffer.size());
   }

   // 从缓冲区返回值
   @Override
   public int blockingGet() throws InterruptedException {
      int readValue = buffer.take(); // 从缓冲区移除值
      System.out.printf("%s%2d\t%s%d%n", "消费者读取 ",
         readValue, "占用的缓冲区单元数量: ", buffer.size());

      return readValue;
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