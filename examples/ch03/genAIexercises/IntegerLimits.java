// 3.11节, IntegerLimits.java
// 显示Java基元整型的最小值和最大值
public class IntegerLimits {
    public static void main(String[] args) {
        // 打印 byte 类型的范围
        System.out.println("byte的最小值: " + Byte.MIN_VALUE);
        System.out.println("byte的最大值: " + Byte.MAX_VALUE);
        System.out.println();

        // 打印 short 类型的范围
        System.out.println("short的最小值: " + Short.MIN_VALUE);
        System.out.println("short的最大值: " + Short.MAX_VALUE);
        System.out.println();

        // 打印 int 类型的范围
        System.out.println("int的最小值: " + Integer.MIN_VALUE);
        System.out.println("int的最大值: " + Integer.MAX_VALUE);
        System.out.println();

        // 打印 long 类型的范围
        System.out.println("long的最小值: " + Long.MIN_VALUE);
        System.out.println("long的最大值: " + Long.MAX_VALUE);
        System.out.println();

        // 打印 char 类型的范围（无符号）
        System.out.println("char的最小值（Unicode 0）: " + (int) Character.MIN_VALUE);
        System.out.println("char的最大值（Unicode 65535）: " + (int) Character.MAX_VALUE);
    }
}