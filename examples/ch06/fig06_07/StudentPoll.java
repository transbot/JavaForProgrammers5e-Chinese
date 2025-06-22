// 图6.7: StudentPoll.java
// 分析学生打分结果

public class StudentPoll {
   public static void main(String[] args) {
      // 学生打分结果数组（通常应在运行时输入）
      int[] responses =  
         {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14};
      int[] frequency = new int[6]; // 频次统计数组

      // 遍历responses数组来选择每个元素中存储的分数，
      // 将该分数作为frequency数组的索引，以确定要递增frequency的哪个元素。
      for (int answer = 0; answer < responses.length; ++answer) {    
         try {                                                       
            ++frequency[responses[answer]];                          
         }
         catch (ArrayIndexOutOfBoundsException e) {                  
            System.out.println(e); // 调用异常对象的toString方法以便输出异常消息
            System.out.printf("   responses[%d] = %d%n%n",           
               answer, responses[answer]);                           
         }
      }

      System.out.printf("%s%10s%n", "分数", "频次");
   
      // 输出每个分数对应的频次
      for (int rating = 1; rating < frequency.length; ++rating) {
         System.out.printf("%4d%12d%n", rating, frequency[rating]);
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
