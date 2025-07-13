// 图12.9: Algorithms1.java
// Collections的reverse、fill、copy、max和min方法
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms1 {
   public static void main(String[] args) {
      // 创建并显示List<Character>
      Character[] letters = {'P', 'C', 'M'};
      List<Character> list = Arrays.asList(letters); // 获取List
      outputList(list);

      // 反转并显示List<Character>
      Collections.reverse(list); // 反转元素顺序
      System.out.printf("%n调用reverse后，list包含:%n");
      outputList(list);

      // 从包含3个Character的数组创建copyList
      Character[] lettersCopy = new Character[3]; 
      List<Character> copyList = Arrays.asList(lettersCopy); 

      // 将list的内容复制到copyList
      Collections.copy(copyList, list);
      System.out.printf("%n复制后，copyList包含:%n");
      outputList(copyList);

      // 用R填充list
      Collections.fill(list, 'R');
      System.out.printf("%n调用fill后，list包含:%n");
      outputList(list);
   } 

   // 输出list中的信息
   private static void outputList(List<Character> list) {
      System.out.printf("列表内容: %s%n", list);
      System.out.printf("最大值: %s; 最小值: %s%n", Collections.max(list),
         Collections.min(list));
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
