// 图18.10: BlockingBufferTest.java
// 两个线程操作一个正确实现了生产者/消费者
// 关系的阻塞缓冲区
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class BlockingBufferTest {
   public static void main(String[] args) throws InterruptedException {
      // 该executor为每个任务分配一个虚拟线程
      try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
         // 创建BlockingBuffer来存储int值
         final Buffer buffer = new BlockingBuffer();

         // 生产者任务向缓冲区写入1~10
         executor.execute(() -> {
            int sum = 0;

            for (int count = 1; count <= 10; count++) {
               try { 
                  Thread.sleep(ThreadLocalRandom.current().nextInt(3000));  
                  buffer.blockingPut(count); // 向缓冲区写入值
                  sum += count; // 持续累加所写入的值
               } 
               catch (InterruptedException exception) {
                  Thread.currentThread().interrupt(); 
               } 
            } 

            System.out.printf(
               "生产者完成: 所生成值的总和为%d%n", sum);
         });

         // 消费者任务从缓冲区读取值
         executor.execute(() -> {
            int sum = 0;

            for (int count = 1; count <= 10; count++) {
               try {
                  Thread.sleep(ThreadLocalRandom.current().nextInt(3000));  
                  sum += buffer.blockingGet(); // 从缓冲区读取值
               } 
               catch (InterruptedException exception) {
                  Thread.currentThread().interrupt(); 
               } 
            } 

            System.out.printf(
               "%n消费者完成: 所读取值的总和为%d%n", sum);
         });
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