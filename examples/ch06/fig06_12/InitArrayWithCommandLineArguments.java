// 图6.12: InitArrayWithCommandLineArguments.java
// 使用命令行参数来初始化数组

public class InitArrayWithCommandLineArguments {
   public static void main(String[] args) {
      // 检查命令行参数数量
      if (args.length != 3) {
         System.out.println("""
            错误：请重新执行程序并提供：
            数组长度、初始值和增量三个参数。""");
         return;
      }

      // 从第一个命令行参数获取数组长度
      int arrayLength = Integer.parseInt(args[0]); 
      int[] array = new int[arrayLength]; 

      // 从后续的命令行参数获取初始值和增量
      int initialValue = Integer.parseInt(args[1]);
      int increment = Integer.parseInt(args[2]);   

      // 计算每个数组元素的值               
      for (int counter = 0; counter < array.length; ++counter) {
         array[counter] = initialValue + increment * counter;   
      }

      System.out.printf("%s%8s%n", "索引", "值");
         
      // 显示数组索引和对应值
      for (int counter = 0; counter < array.length; ++counter) {
         System.out.printf("%4d%9d%n", counter, array[counter]);
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
