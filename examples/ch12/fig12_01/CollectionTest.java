// 图12.1: CollectionTest.java
// 通过ArrayList对象演示Collection接口
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
   public static void main(String[] args) {
      // 将colors数组的元素添加到colorList
      String[] colors = {"品红", "红", "白", "蓝", "青"};  // 要添加的颜色
      List<String> colorList = new ArrayList<String>();

      for (String color : colors) {
         colorList.add(color); // 在colorList末尾添加颜色
      }

      // 将removeColors数组的元素添加到removeList
      String[] removeColors = {"红", "白", "蓝"};  // 要移除的颜色
      List<String> removeList = new ArrayList<String>();

      for (String color : removeColors) {
         removeList.add(color);
      }

      // 输出colorList内容
      System.out.println("ArrayList的内容: ");

      for (int count = 0; count < colorList.size(); ++count) {
         System.out.printf("%s ", colorList.get(count));
      }

      // 从colorList中移除removeList包含的颜色
      removeColors(colorList, removeList);

      // 输出colorList内容
      System.out.printf("%n%n调用removeColors后的ArrayList:%n");

      for (String color : colorList) {
         System.out.printf("%s ", color);
      }
   } 

   // 从allItems中移除itemsToRemove指定的颜色
   private static void removeColors(Collection<String> allItems, 
      Collection<String> itemsToRemove) {
      
      Iterator<String> iterator = allItems.iterator(); // 获取迭代器

      // 当集合有元素时就循环
      while (iterator.hasNext()) {
         if (itemsToRemove.contains(iterator.next())) { // 检查当前元素是否存在于需要移除的颜色集合中    
            iterator.remove(); // 移除当前元素
         }
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
