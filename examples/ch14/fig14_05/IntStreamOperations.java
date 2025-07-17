// 图14.5: IntStreamOperations.java
// 演示IntStream的操作
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamOperations {
   public static void main(String[] args) {
      int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

      // 显示原始值
      System.out.print("原始值：");
      System.out.println(
         IntStream.of(values)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));

      // 值的计数、最小值、最大值、总和和平均值
      System.out.printf("%n计数：%d%n", IntStream.of(values).count());
      System.out.printf("最小值：%d%n",
         IntStream.of(values).min().getAsInt());
      System.out.printf("最大值：%d%n",
         IntStream.of(values).max().getAsInt());
      System.out.printf("总和：%d%n", IntStream.of(values).sum());
      System.out.printf("平均值：%.2f%n",
         IntStream.of(values).average().getAsDouble());

      // 使用reduce方法计算总和
      System.out.printf("%n通过reduce方法计算的总和：%d%n",
         IntStream.of(values)
                  .reduce(0, (x, y) -> x + y));

      // 使用reduce方法计算乘积
      System.out.printf("通过reduce方法计算的乘积：%d%n",
         IntStream.of(values)
                  .reduce((x, y) -> x * y).getAsInt());

      // 使用map和sum方法计算平方和
      System.out.printf("通过map和sum方法计算的平方和：%d%n%n",
         IntStream.of(values)
                  .map(x -> x * x)
                  .sum());        

      // 按排序顺序显示元素
      System.out.printf("按排序顺序显示的值：%s%n",
         IntStream.of(values)
                  .sorted()
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(" ")));
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
