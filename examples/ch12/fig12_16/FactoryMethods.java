// 图12.16: FactoryMethods.java
// 用于创建不可变集合的便捷工厂方法
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FactoryMethods {
   public static void main(String[] args) {
      // 创建一个List 
      List<String> colorList = List.of("红", "橙", "黄", 
         "绿", "蓝", "靛", "紫");
      System.out.printf("colorList: %s%n", colorList);

      // 创建一个Set
      Set<String> colorSet = Set.of("红", "橙", "黄", 
         "绿", "蓝", "靛", "紫");
      System.out.printf("colorSet: %s%n", colorSet);

      // 使用of方法创建一个Map
      Map<String, Integer> dayMap = Map.of("星期一", 1, "星期二", 2,
         "星期三", 3, "星期四", 4, "星期五", 5, "星期六", 6,
         "星期日", 7);
      System.out.printf("dayMap: %s%n", dayMap);

      // 对于超过10对的情况，使用ofEntries方法创建一个Map
      Map<String, Integer> daysPerMonthMap = Map.ofEntries(
         Map.entry("一月", 31),
         Map.entry("二月", 28),
         Map.entry("三月", 31),
         Map.entry("四月", 30),
         Map.entry("五月", 31),
         Map.entry("六月", 30),
         Map.entry("七月", 31),
         Map.entry("八月", 31),
         Map.entry("九月", 30),
         Map.entry("十月", 31),
         Map.entry("十一月", 30),
         Map.entry("十二月", 31)
      );
      System.out.printf("monthMap: %s%n", daysPerMonthMap);
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
