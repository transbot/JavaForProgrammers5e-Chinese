// 图6.14: ArrayListCollection.java
// 演示泛型ArrayList<E>集合
import java.util.ArrayList;

public class ArrayListCollection {
   public static void main(String[] args) {
      // 创建一个初始容量为3的字符串ArrayList
      var items = new ArrayList<String>(3);
      System.out.printf(
         "创建初始容量为3的列表后，列表大小是: %d%n",
         items.size());

      items.add("红色"); // 向列表追加一个元素      
      items.add(0, "黄色"); // 在索引0处插入"黄色"

      System.out.print(
         "使用计数器控制的for循环显示列表内容:"); 

      // 显示列表中的颜色
      for (int i = 0; i < items.size(); ++i) {
         System.out.printf(" %s", items.get(i));
      }

      // 在display方法中使用增强for循环显示颜色
      display(items,
         "%n使用增强for循环显示列表内容:");
      System.out.printf("列表大小: %d%n", items.size());

      items.add("绿色"); // 向列表末尾添加"绿色"
      items.add("黄色"); // 向列表末尾添加"黄色"      
      display(items, "\n添加两个新元素后的列表:"); 
      System.out.println("列表已超出初始容量3");
      System.out.printf("列表大小: %d%n", items.size());

      items.remove("黄色"); // 移除第一个"黄色"
      display(items, "\n移除第一个黄色后的列表:"); 
      System.out.printf("列表大小: %d%n", items.size());

      items.remove(1); // 移除索引1处的元素
      display(items, "\n移除第二个列表元素(绿色)后:"); 
      System.out.printf("列表大小: %d%n", items.size());

      // 检查某个值是否在列表中
      System.out.printf("\n\"红色\"%s在列表中%n",
         items.contains("红色") ? "": "不");

      // 获取元素在列表中的索引位置
      System.out.printf("\"红色\"的位置索引是: %d%n", 
         items.indexOf("红色"));

      // 清空ArrayList并显示其大小
      items.clear();
      System.out.printf("\n清空后的大小: %s%n", items.size());
   } 

   // 在控制台显示ArrayList的元素
   public static void display(ArrayList<String> items, String header) {
      System.out.printf(header); // 显示标题

      // 使用增强for循环显示每个元素
      for (String item : items) {
         System.out.printf(" %s", item);
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
