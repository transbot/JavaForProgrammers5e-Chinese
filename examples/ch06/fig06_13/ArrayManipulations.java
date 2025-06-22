// 图6.13: ArrayManipulations.java
// 演示Arrays类的各种静态方法和静态System.arraycopy方法
import java.util.Arrays;

public class ArrayManipulations {
   public static void main(String[] args) {
      // 将doubles数组按升序排序
      double[] doubles = {8.4, 9.3, 0.2, 7.9, 3.4};
      Arrays.sort(doubles);
      System.out.printf("doubles: %s%n", Arrays.toString(doubles));

      // 用7填充10个元素的数组
      int[] filledInts = new int[10]; 
      Arrays.fill(filledInts, 7);
      System.out.printf("filledInts: %s%n", Arrays.toString(filledInts));

      // 将ints数组复制到intsCopy数组
      int[] ints = {1, 2, 3, 4, 5, 6};
      int[] intsCopy = new int[ints.length];
      System.arraycopy(ints, 0, intsCopy, 0, ints.length);
      System.out.printf("ints: %s%n", Arrays.toString(ints));
      System.out.printf("intsCopy: %s%n", Arrays.toString(intsCopy));

      // 比较ints和intsCopy是否相等
      boolean b = Arrays.equals(ints, intsCopy);
      System.out.printf("%nints %s intsCopy%n", 
          (b ? "等于" : "不等于"));

      // 比较ints和filledInts是否相等
      b = Arrays.equals(ints, filledInts);
      System.out.printf("ints %s filledInts%n", 
          (b ? "等于" : "不等于"));

      // 在ints数组中查找值5
      int location = Arrays.binarySearch(ints, 5);
      
      if (location >= 0) {
         System.out.printf("在ints数组的索引%d处找到5%n", location); 
      } 
      else {
         System.out.println("在ints数组中未找到5"); 
      } 

      // 在ints数组中查找值8763
      location = Arrays.binarySearch(ints, 8763);

      if (location >= 0) {
         System.out.printf(
            "在ints数组的索引%d处找到8763%n", location);
      } 
      else {
         System.out.println("在ints数组中未找到8763"); 
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
