// 7.3.4节, 生成式AI练习: StringSearchDemo.java

/* 执行以下操作：
   a) 定位字符串"to be or not to be"中子串"be"的第一个实例，然后显示索引。
   b) 定位字符串"to be or not to be"中子串"be"的最后一个实例，然后显示索引。
*/

public class StringSearchDemo {
    public static void main(String[] args) {
        String s = "to be or not to be";
        
        // 查找并输出第一个"be"的位置
        System.out.printf("第一个\"be\"的索引位置: %d%n", s.indexOf("be"));
        
        // 查找并输出最后一个"be"的位置
        System.out.printf("最后一个\"be\"的索引位置: %d%n", s.lastIndexOf("be"));
    }
}