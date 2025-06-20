// 图5.6: MethodOverload.java
// 演示方法重载

public class MethodOverload {
    // 测试重载的square方法
    public static void main(String[] args) {
        System.out.printf("整数7的平方是%d%n", square(7));
        System.out.printf("浮点数7.5的平方是%.2f%n", square(7.5));
    } 

    // 接收int类型实参的square方法
    public static int square(int intValue) {
        System.out.printf("%n调用接收int实参%d的square方法%n",
            intValue);
        return intValue * intValue;
    } 

    // 接收double类型实参的square方法
    public static double square(double doubleValue) {
        System.out.printf("%n调用接收double实参%.2f的square方法%n",
            doubleValue);
        return doubleValue * doubleValue;
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
