// 图12.3: UsingToArray.java
// 将数组视为List，并将List转换为数组
import java.util.LinkedList;
import java.util.Arrays;

public class UsingToArray {
   public static void main(String[] args) {
      String[] colors = {"黑", "蓝", "黄"};
      LinkedList<String> list = new LinkedList<>(Arrays.asList(colors));

      list.addLast("红");   // 作为最后一项添加   
      list.add("粉");       // 添加到末尾        
      list.add(3, "绿");    // 在索引3处添加  
      list.addFirst("青");  // 作为第一项添加

      // 将LinkedList的元素作为数组来获取
      colors = list.toArray(new String[list.size()]);

      System.out.println("颜色列表: ");

      for (String color : colors) {
         System.out.println(color);
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
