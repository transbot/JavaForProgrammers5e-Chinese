// 6.16节, 生成式AI练习: MaxValueIn2DArray.java
// 判断并显示二维数组中的最大值
import java.util.Random;

public class MaxValueIn2DArray {
    public static void main(String[] args) {
        // 定义二维数组的行数和列数
        int rows = 5;
        int cols = 4;
        
        // 创建二维数组
        double[][] values = new double[rows][cols];
        
        // 创建Random对象用于生成随机数
        Random random = new Random();
        
        // 填充并打印数组
        for (double[] row : values) { // 使用增强for循环遍历每一行
            for (int j = 0; j < row.length; j++) { // 使用嵌套的计数for循环遍历每一行的列 
                row[j] = random.nextDouble() * 100;
                System.out.printf("%8.2f", row[j]);
            }
            System.out.println();
        }
        
        // 使用增强for循环查找最大值
        double max = values[0][0];
        for (double[] row : values) {
            for (double value : row) { // 嵌套的循环也使用了增强for
                if (value > max) {
                    max = value;
                }
            }
        }
        
        // 显示最大值
        System.out.printf("\n数组中的最大值是: %.2f\n", max);
    }
}