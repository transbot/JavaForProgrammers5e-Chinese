// 图12.11: Algorithms2.java
// Collections的addAll、frequency和disjoint方法
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms2 {
   public static void main(String[] args) {
      // 初始化list1和list2
      String[] colors = {"红", "白", "黄", "蓝"};
      List<String> list1 = Arrays.asList(colors);
      List<String> list2 = new ArrayList<>();

      list2.add("黑"); // 将"黑"添加到list2末尾
      list2.add("红"); // 将"红"添加到list2末尾
      list2.add("绿"); // 将"绿"添加到list2末尾

      System.out.printf("addAll前，list2包含: %s%n", list2);
      Collections.addAll(list2, colors); // 将colors中的字符串添加到list2
      System.out.printf("addAll后，list2包含: %s%n", list2);

      // 获取"红"的出现频率                           
      int frequency = Collections.frequency(list2, "红");
      System.out.printf("%nlist2中红的出现频率: %d%n", frequency);

      // 检查list1和list2是否有共同元素
      boolean areDisjoint = Collections.disjoint(list1, list2);  

      System.out.printf("list1和list2%s共同元素%n", 
         (areDisjoint ? "没有" : "有")); 
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
