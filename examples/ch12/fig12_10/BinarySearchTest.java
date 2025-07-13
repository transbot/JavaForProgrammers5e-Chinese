// 图12.10: BinarySearchTest.java
// Collections的binarySearch方法
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class BinarySearchTest {
   public static void main(String[] args) {
      // 从colors数组创建ArrayList<String>
      String[] colors = {"红", "白", "蓝", "黑", "黄", 
         "紫", "棕", "粉"};
      List<String> list = new ArrayList<>(Arrays.asList(colors));

      Collections.sort(list); // 排序ArrayList
      System.out.printf("排序后的ArrayList: %s%n", list);

      // 在列表中查找不同值
      printSearchResults(list, "黑"); 
      printSearchResults(list, "红"); 
      printSearchResults(list, "粉"); 
      printSearchResults(list, "浅绿"); // 不存在
      printSearchResults(list, "灰");   // 不存在
      printSearchResults(list, "青");   // 不存在
   }      

   // 执行查找并显示结果
   private static void printSearchResults(
      List<String> list, String key) {

      System.out.printf("%n正在查找: %s%n", key);
      int result = Collections.binarySearch(list, key);
      
      if (result >= 0) {
         System.out.printf("在索引 %d 处找到%n", result);
      } 
      else {
         System.out.printf("未找到 (%d)%n", result);
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
