// 图12.2: ListTest.java
// 演示List、LinkedList和ListIterator
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class ListTest {
   public static void main(String[] args) {
      // 将colors数组的元素添加到list1
      String[] colors = 
         {"黑(black)", "黄(yellow)", "绿(green)", "蓝(blue)", "紫(violet)", "银(silver)"};
      List<String> list1 = new LinkedList<>(); 

      for (String color : colors) {
         list1.add(color);
      }

      // 将colors2数组的元素添加到list2
      String[] colors2 = 
         {"金(gold)", "白(white)", "棕(brown)", "蓝(blue)", "灰(gray)", "银(silver)"};
      List<String> list2 = new LinkedList<>();

      for (String color : colors2) {
         list2.add(color);
      }

      list1.addAll(list2); // 连接（拼接）两个列表

      printList(list1); 

      convertToUppercaseStrings(list1); 
      printList(list1); 

      System.out.printf("%n删除元素4~6..."); 
      removeItems(list1, 4, 7); // 从列表中移除元素4~6
      printList(list1); 
      printReversedList(list1); 
   }                                     

   // 输出列表内容
   private static void printList(List<String> list) {
      System.out.printf("%n列表内容:%n");
   
      for (String color : list) {
         System.out.printf("%s ", color);
      }

      System.out.println();
   }                                                    

   // 定位字符串对象并转换为大写
   private static void convertToUppercaseStrings(List<String> list) {
      ListIterator<String> iterator = list.listIterator();

      while (iterator.hasNext()) {
         String color = iterator.next();    // 获取元素                
         iterator.set(color.toUpperCase()); // 转换为大写
      } 
   } 

   // 获取子列表并使用clear方法删除子列表项
   private static void removeItems(List<String> list, 
      int start, int end) {
      list.subList(start, end).clear(); // 移除元素
   } 

   // 打印反转后的列表
   private static void printReversedList(List<String> list) {
      ListIterator<String> iterator = list.listIterator(list.size());

      System.out.printf("%n反转后的列表:%n");

      // 以相反顺序打印列表
      while (iterator.hasPrevious()) {
         System.out.printf("%s ", iterator.previous()); 
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
