import java.math.BigInteger;
import java.util.Scanner;

/**
 * 快速计算斐波那契数的 Java 实现（Fast Doubling Method）
 * 
 * 算法说明：
 * 快速倍增法（Fast Doubling）是一种基于数学推导的高效斐波那契计算方法，时间复杂度 O(log n)。
 * 核心公式：
 *   - F(2n)   = F(n) * [2*F(n+1) - F(n)]
 *   - F(2n+1) = F(n)^2 + F(n+1)^2
 * 通过递归分解问题，每次将 n 减半，避免线性计算，极大提升速度。
 * 
 * 适用场景：
 *   - 计算超大斐波那契数（如 n=200,000）
 *   - 比动态规划（O(n)）和矩阵快速幂（O(log n)）更易实现
 * 
 * 注意：
 *   - 使用 BigInteger 防止整数溢出（F(200000) 有 41,799 位）
 */
public class FastFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入n (0 ≤ n ≤ 200000): ");
        int n = scanner.nextInt();
        
        // 输入验证
        if (n < 0 || n > 200000) {
            System.out.println("错误：n必须在0到200000 之间。");
            return;
        }
        
        // 计算并输出结果
        BigInteger result = fastFibonacci(n);
        System.out.println("F(" + n + ") = " + result);
    }

    /**
     * 快速斐波那契计算入口（返回第 n 个斐波那契数）
     * @param n 目标索引（从 0 开始）
     * @return 第 n 个斐波那契数（BigInteger 类型）
     */
    public static BigInteger fastFibonacci(int n) {
        // 调用快速倍增法，返回结果数组的第一个值 F(n)
        return fastDoubling(n)[0];
    }

    /**
     * 快速倍增法核心实现
     * @param n 当前递归的索引
     * @return 数组 [F(n), F(n+1)]
     */
    private static BigInteger[] fastDoubling(int n) {
        // 基准情况：F(0) = 0, F(1) = 1
        if (n == 0) {
            return new BigInteger[]{BigInteger.ZERO, BigInteger.ONE};
        }
        
        // 递归计算 F(m) 和 F(m+1)，其中 m = n/2
        BigInteger[] pair = fastDoubling(n / 2);
        BigInteger a = pair[0];  // F(m)
        BigInteger b = pair[1];  // F(m+1)
        
        // 计算 F(2m) 和 F(2m+1)
        BigInteger c = a.multiply(
            b.multiply(BigInteger.TWO).subtract(a)  // 2*F(m+1) - F(m)
        );  // F(2m) = F(m) * [2*F(m+1) - F(m)]
        
        BigInteger d = a.multiply(a).add(
            b.multiply(b)
        );  // F(2m+1) = F(m)^2 + F(m+1)^2
        
        // 根据 n 的奇偶性返回正确结果
        if (n % 2 == 0) {
            return new BigInteger[]{c, d};
        } else {
            return new BigInteger[]{d, c.add(d)};  // F(2m+2) = F(2m) + F(2m+1)
        }
    }
}