// 6.20节, 生成式AI练习: ArrayListCollectionWithPrintf.java
// 演示泛型ArrayList<E>集合
// 改进版：使用System.out.printf语句来直接显示ArrayList的内容

import java.util.ArrayList;

public class ArrayListCollectionWithPrintf {
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

      // 使用printf直接显示列表内容（利用ArrayList的toString方法）
      System.out.printf("%n使用增强for循环显示列表内容:%s%n", items);
      System.out.printf("列表大小: %d%n", items.size());

      items.add("绿色"); // 向列表末尾添加"绿色"
      items.add("黄色"); // 向列表末尾添加"黄色"      
      System.out.printf("\n添加两个新元素后的列表:%s%n", items); 
      System.out.println("列表已超出初始容量3");
      System.out.printf("列表大小: %d%n", items.size());

      items.remove("黄色"); // 移除第一个"黄色"
      System.out.printf("\n移除第一个黄色后的列表:%s%n", items); 
      System.out.printf("列表大小: %d%n", items.size());

      items.remove(1); // 移除索引1处的元素
      System.out.printf("\n移除第二个列表元素(绿色)后:%s%n", items); 
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
}