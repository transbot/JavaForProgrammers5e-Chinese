// 6.18节, 生成式AI练习: BetterInitArrayWithCommandLineArguments.java
// 改进版：使用命令行参数来初始化数组，并处理异常情况
public class BetterInitArrayWithCommandLineArguments {
   public static void main(String[] args) {
      // 检查命令行参数数量
      if (args.length != 3) {
         System.out.println("""
            错误：请重新执行程序并提供：
            数组长度、初始值和增量三个参数。""");
         return;
      }

      try {
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
      } catch (NumberFormatException e) {
         System.out.println("错误：所有参数必须是整数。");
      } catch (NegativeArraySizeException e) {
         System.out.println("错误：数组长度不能为负数。");
      }
   } 
}