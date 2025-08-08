// 图22.4：TowersOfHanoi.java
// 使用递归方法解决汉诺塔问题。
public class TowersOfHanoi {
   // 递归地在塔之间移动盘子
   public static void solveTowers(int disks, int sourcePeg,           
      int destinationPeg, int tempPeg) {                              
      // 基本情况：只有一个盘子需要移动
      if (disks == 1) {                                              
         System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);
         return;                                                       
      }                                                      
                                                                       
      // 递归步骤——将(盘子数-1)个盘子从起始塔
      // 移动到临时塔（使用目标塔作为辅助）
      solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);    
                                                                       
      // 将最后一个盘子从起始塔移动到目标塔
      System.out.printf("%n%d --> %d", sourcePeg, destinationPeg);   
                                                                       
      // 将(盘子数-1)个盘子从临时塔移动到目标塔
      solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);    
   }                                          

   public static void main(String[] args) {
      int startPeg = 1;    // 值1用于在输出中表示起始塔(startPeg)
      int endPeg = 3;      // 值3用于在输出中表示目标塔(endPeg)
      int tempPeg = 2;     // 值2用于在输出中表示临时塔(tempPeg)
      int totalDisks = 3;  // 盘子数量

      // 初始的非递归调用，移动所有盘子
      solveTowers(totalDisks, startPeg, endPeg, tempPeg);
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

