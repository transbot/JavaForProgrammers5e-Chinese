// 图14.2: StreamMapReduce.java
// 使用IntStream计算2~20的偶数之和
import java.util.stream.IntStream;

public class StreamMapReduce {
   public static void main(String[] args) {
      System.out.printf("2~20的偶数之和是: %d%n",
         IntStream.rangeClosed(1, 10)              // 1...10
                  .map((int x) -> {return x * 2;}) // 乘以2
                  .sum());                         // 求和
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
