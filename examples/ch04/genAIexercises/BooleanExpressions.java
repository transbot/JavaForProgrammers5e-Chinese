// 练习：要求AI写一个Java程序来显示以下条件的布尔结果，假定i = 1，j = 2，k = 3，m = 2

/*
a) i == 1
b) j == 3
c) (i >= 1) && (j < 4)
d) (m <= 99) & (k < m)
e) (j >= i) || (k == m)
f) (k + m < j) | (3 - j >= k)
g) !(k > m)
*/ 

// 以下是AI生成的程序：
public class BooleanExpressions {
    public static void main(String[] args) {
        // 定义变量
        int i = 1, j = 2, k = 3, m = 2;
        
        // 计算并输出结果
        System.out.println("a) i == 1: " + (i == 1));                   // true
        System.out.println("b) j == 3: " + (j == 3));                   // false
        System.out.println("c) (i >= 1) && (j < 4): " + ((i >= 1) && (j < 4))); // true
        System.out.println("d) (m <= 99) & (k < m): " + ((m <= 99) & (k < m)));  // false
        System.out.println("e) (j >= i) || (k == m): " + ((j >= i) || (k == m))); // true
        System.out.println("f) (k + m < j) | (3 - j >= k): " + ((k + m < j) | (3 - j >= k))); // false
        System.out.println("g) !(k > m): " + !(k > m));                 // false
    }
}