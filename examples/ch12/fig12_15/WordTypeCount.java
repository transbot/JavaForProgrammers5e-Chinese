// 图12.15: WordTypeCount.java
// 统计英文字符串中每个单词出现的次数
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class WordTypeCount {
   public static void main(String[] args) {
      // 创建HashMap对象来存储字符串键和整数计数值
      Map<String, Integer> myMap = new HashMap<>();            

      createMap(myMap);  // 根据用户输入创建映射
      displayMap(myMap); // 显示映射内容
   } 

   // 从用户输入创建映射
   private static void createMap(Map<String, Integer> map) {
      Scanner scanner = new Scanner(System.in);  // 创建Scanner对象以读取输入
      System.out.println("输入一个英文字符串:"); // 提示用户输入
      String input = scanner.nextLine();

      // 对输入进行词元化
      String[] tokens = input.split(" ");
               
      // 处理输入文本 
      for (String token : tokens) {
         String word = token.toLowerCase(); // 单词转换为小写
                  
         // 如果映射中包含该单词
         if (map.containsKey(word)) {  // 单词是否在映射中?
            int count = map.get(word); // 获取当前计数
            map.put(word, count + 1);  // 递增计数
         } 
         else {
            map.put(word, 1); // 向映射添加新单词并设置计数为1
         } 
      } 
   } 
   
   // 显示映射内容
   private static void displayMap(Map<String, Integer> map) {
      Set<String> keys = map.keySet(); // 获取键的集合

      // 对键排序
      TreeSet<String> sortedKeys = new TreeSet<>(keys);

      System.out.printf("%n映射（Map对象）中的内容:%n键\t\t值%n");

      // 为映射中的每个键生成输出
      for (String key : sortedKeys) {
         System.out.printf("%-10s%7s%n", key, map.get(key));
      }
      
      System.out.printf(
         "%n大小: %d%n是否为空: %b%n", map.size(), map.isEmpty());
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
