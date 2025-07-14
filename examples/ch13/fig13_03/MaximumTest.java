// 图13.3: MaximumTest.java
// 泛型maximum方法返回三个对象中最大的那一个

public class MaximumTest {
   public static void main(String[] args) {
      System.out.printf("%d, %d 和 %d 的最大值是 %d%n", 3, 4, 5, 
         maximum(3, 4, 5));
      System.out.printf("%.1f, %.1f 和 %.1f 的最大值是 %.1f%n", 
         6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));
      System.out.printf("%s, %s 和 %s 的最大值是 %s%n", "苹果", 
         "梨", "橙子", maximum("苹果", "梨", "橙子"));
   } 

   // 确定三个对象中的最大值                 
   public static <T extends Comparable<T>> T maximum(T x, T y, T z) {    
      T max = x; // 假设x初始为最大值                    
   
      if (y.compareTo(max) > 0) {                                        
         max = y; // 当前y是最大值                             
      }
   
      if (z.compareTo(max) > 0) {                                        
         max = z; // z才是最大值                                    
      }
   
      return max; // 返回最大值                          
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
