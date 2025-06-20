// 图5.5: Scope.java
// 演示字段和局部变量的作用域

public class Scope {
    // 该字段可被本类的所有方法访问
    private static int x = 1;

    // main方法：创建并初始化局部变量x，
    // 并调用useLocalVariable和useField方法
    public static void main(String[] args) {
        int x = 5; // 方法内的局部变量x，它隐藏（shadow）了同名的字段x

        System.out.printf("main方法中的局部变量x是%d%n", x);

        useLocalVariable(); // useLocalVariable方法拥有自己的局部变量x
        useField(); // useField方法使用的是Scope类的字段x
        useLocalVariable(); // useLocalVariable方法会重新初始化其局部变量x
        useField(); // Scope类的字段x会保持其值

        System.out.printf("%nmain方法中的局部变量x是%d%n", x);
    } 

    // 每次调用时，都会创建并初始化局部变量x
    public static void useLocalVariable() {
        int x = 25; // 每次调用useLocalVariable时都会被初始化

        System.out.printf(
            "%n进入useLocalVariable方法时，局部变量x的值是%d%n", x);
        ++x; // 修改本方法内的局部变量x
        System.out.printf(
            "退出useLocalVariable方法前，局部变量x的值是%d%n", x);
    } 

    // 每次调用时，都会修改Scope类的字段x
    public static void useField() {
        System.out.printf(
            "%n进入useField方法时，字段x的值是%d%n", x);
        x *= 10; // 修改Scope类的字段x
        System.out.printf(
            "退出useField方法前，字段x的值是%d%n", x);
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
