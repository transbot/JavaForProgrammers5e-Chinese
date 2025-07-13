// 图12.4: Sort1.java
// Collections的sort方法
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Sort1 {
   public static void main(String[] args) {
      String[] country = {"USA", "China", "Japan", "Germany"};
      
      // 创建并显示包含country数组元素的一个列表
      List<String> list = Arrays.asList(country);  // 返回固定大小的List
      System.out.printf("未排序的数组元素: %s%n", list);

      Collections.sort(list); // 对ArrayList进行排序
      System.out.printf("已排序的数组元素(升序): %s%n", list);
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
