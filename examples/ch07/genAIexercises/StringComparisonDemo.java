// 7.3.3节, 生成式AI练习: StringComparisonDemo.java
// 证明在程序中，所有内容相同的字符串字面值都指向内存中的同一个对象；
// 而通过new String()构造函数创建的、内容相同的字符串则是不同的对象。

/*  代码步骤： 
    1. 创建两个字符串字面值，内容相同。
    2. 创建两个通过new String()构造的字符串，内容相同。
    3. 比较字面值字符串的引用（用==）和内容（用equals）。
    4. 比较new出来的字符串的引用和内容。
    5. 另外，还可以比较一个字面值字符串和一个new出来的字符串（内容相同）的引用和内容。
    注意：在Java中，字符串字面值会被放入字符串常量池，相同内容的字面值会指向池中的同一个对象。
         而new String()会在堆上创建一个新的对象，即使内容相同，也不会指向常量池中的对象（除非使用intern方法）
*/

public class StringComparisonDemo {
    public static void main(String[] args) {
        // 使用字符串字面值创建字符串
        String literal1 = "Java字符串";
        String literal2 = "Java字符串";
        
        // 使用new关键字创建字符串对象
        String object1 = new String("Java字符串");
        String object2 = new String("Java字符串");
        
        // 比较字符串字面值
        System.out.println("===== 字符串字面值比较 =====");
        System.out.println("literal1 == literal2: " + (literal1 == literal2)); // true
        System.out.println("literal1.equals(literal2): " + literal1.equals(literal2)); // true
        
        // 比较new创建的对象
        System.out.println("\n===== new String() 比较 =====");
        System.out.println("object1 == object2: " + (object1 == object2)); // false
        System.out.println("object1.equals(object2): " + object1.equals(object2)); // true
        
        // 比较字面值和new创建的对象
        System.out.println("\n===== 字面值与new对象比较 =====");
        System.out.println("literal1 == object1: " + (literal1 == object1)); // false
        System.out.println("literal1.equals(object1): " + literal1.equals(object1)); // true
        
        // 验证hashCode相同但对象不同
        System.out.println("\n===== hashCode 验证 =====");
        System.out.println("literal1哈希值: " + System.identityHashCode(literal1));
        System.out.println("literal2哈希值: " + System.identityHashCode(literal2));
        System.out.println("object1哈希值: " + System.identityHashCode(object1));
        System.out.println("object2哈希值: " + System.identityHashCode(object2));
    }
}