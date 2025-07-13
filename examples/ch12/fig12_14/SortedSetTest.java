// 图12.14: SortedSetTest.java
// 使用SortedSet和TreeSet
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
   public static void main(String[] args) {
      // 从colors数组创建TreeSet
      String[] colors = {"黄", "绿", "黑", "棕", "灰",
         "白", "橙", "红", "绿"};
      SortedSet<String> tree = new TreeSet<>(Arrays.asList(colors));

      System.out.print("排序集合: ");
      printSet(tree); 

      // 获取基于"橙"的headSet
      System.out.print("headSet (\"橙\"): ");
      printSet(tree.headSet("橙"));

      // 获取基于"橙"的tailSet
      System.out.print("tailSet (\"橙\"): ");
      printSet(tree.tailSet("橙"));

      // 获取第一个和最后一个元素
      System.out.printf("第一个元素: %s%n", tree.first());
      System.out.printf("最后一个元素: %s%n", tree.last());
   } 

   // 使用增强for循环输出SortedSet
   private static void printSet(SortedSet<String> set) {
      for (String s : set) {
         System.out.printf("%s ", s);
      }

      System.out.println();
   } 
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
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
