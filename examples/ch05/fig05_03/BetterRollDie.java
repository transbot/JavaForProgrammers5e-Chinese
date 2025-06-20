// BetterRollDie.java
// 模拟掷六面骰子6000万次
// 本程序是图5.3的优化版本，使用数组来存储频率计数
import java.util.random.RandomGenerator;

public class BetterRollDie {
    public static void main(String[] args) {
        RandomGenerator randomNumbers = RandomGenerator.getDefault();
        int[] frequencies = new int[6]; // 索引0对应点数1，索引5对应点数6
        
        // 统计6000万次掷骰结果
        for (int roll = 0; roll < 60_000_000; roll++) {
            frequencies[randomNumbers.nextInt(6)]++;
        }
        
        // 输出结果
        System.out.println("点数\t次数");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.printf("%d\t%d%n", i + 1, frequencies[i]);
        }
    }
}