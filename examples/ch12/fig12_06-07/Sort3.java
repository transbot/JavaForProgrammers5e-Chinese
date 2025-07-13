// 图12.7: Sort3.java
// 为sort方法使用一个自定义Comparator对象
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Sort3 {
   public static void main(String[] args) {
      List<Time2> list = new ArrayList<>(); // 创建列表

      list.add(new Time2(6, 24, 34));
      list.add(new Time2(18, 14, 58));
      list.add(new Time2(6, 5, 34));
      list.add(new Time2(12, 14, 58));
      list.add(new Time2(6, 24, 22));
      
      // 输出列表元素
      System.out.printf("未排序的数组元素:%n%s%n", list);

      // 使用一个comparator来排序          
      Collections.sort(list, new TimeComparator());

      // 输出列表元素
      System.out.printf("已排序的列表元素:%n%s%n", list);
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
