// 图12.13: SetTest.java
// 用HashSet从字符串数组中删除重复值
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class SetTest {
   public static void main(String[] args) {
      // 创建并显示List<String>
      String[] colors = {"红", "白", "蓝", "绿", "灰", 
         "橙", "棕", "白", "青", "桃", "灰", "橙"}; 
      List<String> list = Arrays.asList(colors);
      System.out.printf("原始列表: %s%n", list);

      // 消除重复项后打印唯一值
      printNonDuplicates(list);
   }  

   // 通过一个Collection来创建Set，以消除重复项
   private static void printNonDuplicates(Collection<String> values) {
      // 创建HashSet 
      Set<String> set = new HashSet<>(values);

      System.out.printf("%n无重复的项包括: ");

      for (String value : set) {
         System.out.printf("%s ", value);
      }

      System.out.println();
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
