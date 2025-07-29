// 图18.13: PrimeCalculatorTask.java
// 查找前n个素数，每找到一个就显示一个
import java.util.Arrays;
import javafx.concurrent.Task;

public class PrimeCalculatorTask extends Task<Integer> {
   private final boolean[] primes; // 用于查找素数的boolean数组

   // 构造函数
   public PrimeCalculatorTask(int max) {
      primes = new boolean[max]; 
      Arrays.fill(primes, true); // 将所有素数元素初始化为true
   } 

   // 要在工作线程中运行的耗时代码
   @Override
   protected Integer call() {
      int count = 0; // 已找到的素数数量

      // 从索引2（第一个素数，也是唯一的偶素数）开始遍历，
      // 如果发现是i的倍数，就将相应元素设为false
      for (int i = 2; i < primes.length; i++) {
         if (isCancelled()) { // 如果中途取消计算
            updateMessage("已取消");
            return 0;
         }
         else { 
            try { 
               Thread.sleep(10); // 人为放慢线程
            }  
            catch (InterruptedException ex) {
               updateMessage("已中断");
               return 0;
            } 

            updateProgress(i + 1, primes.length); 

            if (primes[i]) { // 如果i是素数
               ++count;
               updateMessage(String.format("找到了%d个素数", count));
               updateValue(i); // 中间结果

               // 筛除i的所有倍数（非素数）
               for (int j = i + i; j < primes.length; j += i) {
                  primes[j] = false; // j是i的倍数，因此j不是素数
               }
            } 
         }  
      } 
      
      return 0;   
   } 
} 

/*************************************************************************
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