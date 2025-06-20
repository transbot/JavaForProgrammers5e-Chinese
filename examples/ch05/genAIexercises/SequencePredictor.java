// 练习5.2: SequencePredictor.java

/**
 * 智能数列预测程序
 * 
 * 该程序能够接收用户输入的整数序列，并预测该序列的下一个数字。
 * 支持多种常见数列类型的识别和预测，包括：
 * 1. 等差数列 - 相邻数字之间的差值相同（如：2, 5, 8, 11 → 14）
 * 2. 斐波那契数列 - 每个数字是前两个数字之和（如：1, 1, 2, 3, 5 → 8）
 * 3. 等比数列 - 相邻数字之间的比值相同（如：3, 6, 12, 24 → 48）
 * 4. 平方数列 - 数字是连续整数的平方（如：1, 4, 9, 16 → 25）
 * 5. 立方数列 - 数字是连续整数的立方（如：1, 8, 27, 64 → 125）
 * 6. 阶乘数列 - 数字是连续整数的阶乘（如：1, 2, 6, 24 → 120 或 24, 120, 720 → 5040）
 * 7. 素数数列 - 数字是连续的素数（如：2, 3, 5, 7 → 11 或 13, 17, 19 → 23）
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequencePredictor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("智能数列预测程序");
        System.out.println("请输入一个整数序列，用空格分隔（例如：1 2 3 4 5）：");
        
        String input = scanner.nextLine();
        String[] parts = input.trim().split("\\s+");
        
        List<Integer> sequence = new ArrayList<>();
        for (String part : parts) {
            try {
                sequence.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {
                System.out.println("输入包含非数字字符: " + part);
                return;
            }
        }
        
        if (sequence.size() < 3) {
            System.out.println("序列太短，无法进行有效预测。至少需要3个数字。");
            return;
        }
        
        System.out.println("分析序列: " + sequence);
        
        Integer nextNumber = predictNextNumber(sequence);
        
        if (nextNumber != null) {
            System.out.println("预测下一个数字是: " + nextNumber);
        } else {
            System.out.println("无法识别该序列的模式。");
        }
    }
    
    /**
     * 尝试识别序列模式并预测下一个数字
     * 按优先级检查多种数列类型，返回第一个匹配的预测结果
     */
    private static Integer predictNextNumber(List<Integer> sequence) {
        // 尝试等差数列
        Integer arithmeticNext = checkArithmeticSequence(sequence);
        if (arithmeticNext != null) {
            System.out.println("识别为等差数列");
            return arithmeticNext;
        }

        // 尝试斐波那契数列
        Integer fibonacciNext = checkFibonacciSequence(sequence);
        if (fibonacciNext != null) {
            System.out.println("识别为斐波那契数列");
            return fibonacciNext;
        }
                
        // 尝试等比数列
        Integer geometricNext = checkGeometricSequence(sequence);
        if (geometricNext != null) {
            System.out.println("识别为等比数列");
            return geometricNext;
        }
        
        
        
        // 尝试平方数列
        Integer squareNext = checkSquareSequence(sequence);
        if (squareNext != null) {
            System.out.println("识别为平方数列");
            return squareNext;
        }
        
        // 尝试立方数列
        Integer cubeNext = checkCubeSequence(sequence);
        if (cubeNext != null) {
            System.out.println("识别为立方数列");
            return cubeNext;
        }
        
        // 尝试阶乘数列
        Integer factorialNext = checkFactorialSequence(sequence);
        if (factorialNext != null) {
            System.out.println("识别为阶乘数列");
            return factorialNext;
        }
        
        // 尝试素数数列
        Integer primeNext = checkPrimeSequence(sequence);
        if (primeNext != null) {
            System.out.println("识别为素数数列");
            return primeNext;
        }
        
        return null;
    }
    
    /**
     * 检查序列是否为等差数列
     * @return 若是等差数列，返回下一个预测值；否则返回null
     */
    private static Integer checkArithmeticSequence(List<Integer> sequence) {
        int diff = sequence.get(1) - sequence.get(0);
        for (int i = 1; i < sequence.size() - 1; i++) {
            if (sequence.get(i + 1) - sequence.get(i) != diff) {
                return null;
            }
        }
        return sequence.get(sequence.size() - 1) + diff;
    }
    
    /**
     * 检查序列是否为等比数列
     * @return 若是等比数列，返回下一个预测值；否则返回null
     */
    private static Integer checkGeometricSequence(List<Integer> sequence) {
        if (sequence.get(0) == 0) return null;
        
        double ratio = (double) sequence.get(1) / sequence.get(0);
        for (int i = 1; i < sequence.size() - 1; i++) {
            if (sequence.get(i) == 0) return null;
            double currentRatio = (double) sequence.get(i + 1) / sequence.get(i);
            if (Math.abs(currentRatio - ratio) > 0.0001) {
                return null;
            }
        }
        return (int) Math.round(sequence.get(sequence.size() - 1) * ratio);
    }
    
    /**
     * 检查序列是否为斐波那契数列
     * @return 若是斐波那契数列，返回下一个预测值；否则返回null
     */
    private static Integer checkFibonacciSequence(List<Integer> sequence) {
        int size = sequence.size();
        if (size < 3) return null;
    
        // 验证所有元素是否满足递推关系
        for (int i = 2; i < size; i++) {
            if (sequence.get(i) != sequence.get(i-1) + sequence.get(i-2)) {
                return null;
            }
        }
    
        // 特殊处理：如果数列长度为3，检查是否可能是平方数列
        if (size == 3) {
            if (checkSquareSequence(sequence) != null) {
                return null; // 优先识别为平方数列
            }
        }
        return sequence.get(size - 1) + sequence.get(size - 2);
    }
    
    /**
     * 检查序列是否为平方数列
     * @return 若是平方数列，返回下一个预测值；否则返回null
     */
    private static Integer checkSquareSequence(List<Integer> sequence) {
        // 尝试找出起始的n值
        int startN = (int) Math.round(Math.sqrt(sequence.get(0)));
        if (startN < 0) return null;
        
        // 检查是否真的是平方数
        if (startN * startN != sequence.get(0)) {
            // 如果不是精确平方，尝试相邻值
            if ((startN + 1) * (startN + 1) == sequence.get(0)) {
                startN++;
            } else if ((startN - 1) * (startN - 1) == sequence.get(0)) {
                startN--;
            } else {
                return null;
            }
        }
        
        // 验证整个序列
        for (int i = 0; i < sequence.size(); i++) {
            int expected = (startN + i) * (startN + i);
            if (sequence.get(i) != expected) {
                return null;
            }
        }
        
        return (startN + sequence.size()) * (startN + sequence.size());
    }

    /**
     * 检查序列是否为立方数列
     * @return 若是立方数列，返回下一个预测值；否则返回null
     */
    private static Integer checkCubeSequence(List<Integer> sequence) {
    int startN = (int) Math.round(Math.cbrt(sequence.get(0)));
    
    // 验证整个序列（允许递增或递减）
    for (int i = 0; i < sequence.size(); i++) {
        int expected = (startN - i) * (startN - i) * (startN - i); // 修正索引逻辑
        if (sequence.get(i) != expected) {
            return null;
        }
    }
    
    return (startN - sequence.size()) * (startN - sequence.size()) * (startN - sequence.size());
}
    
    /**
     * 检查序列是否为阶乘数列
     * @return 若是阶乘数列，返回下一个预测值；否则返回null
     */
    private static Integer checkFactorialSequence(List<Integer> sequence) {
        // 查找序列可能的起始位置
        int start = findFactorialStart(sequence.get(0));
        if (start == -1) return null;
        
        // 验证整个序列是否符合阶乘规律
        for (int i = 0; i < sequence.size(); i++) {
            if (sequence.get(i) != factorial(start + i)) {
                return null;
            }
        }
        
        return factorial(start + sequence.size());
    }
    
    /**
     * 查找给定数字对应的阶乘位置n（即n! = num）
     * @return 若存在这样的n，返回n；否则返回-1
     */
    private static int findFactorialStart(int num) {
        int n = 1;
        while (factorial(n) <= num) {
            if (factorial(n) == num) {
                return n;
            }
            n++;
        }
        return -1;
    }
    
    /**
     * 计算n的阶乘
     */
    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * 检查序列是否为素数数列
     * @return 若是素数数列，返回下一个预测值；否则返回null
     */
    private static Integer checkPrimeSequence(List<Integer> sequence) {
        // 首先检查所有数字是否都是素数
        for (int num : sequence) {
            if (!isPrime(num)) {
                return null;
            }
        }
        
        // 检查是否为连续素数
        for (int i = 0; i < sequence.size() - 1; i++) {
            if (findNextPrime(sequence.get(i)) != sequence.get(i + 1)) {
                return null;
            }
        }
        
        return findNextPrime(sequence.get(sequence.size() - 1));
    }
    
    /**
     * 查找给定数字后的下一个素数
     */
    private static int findNextPrime(int num) {
        int next = num + 1;
        while (true) {
            if (isPrime(next)) {
                return next;
            }
            next++;
        }
    }
    
    /**
     * 判断一个数字是否为素数
     */
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}