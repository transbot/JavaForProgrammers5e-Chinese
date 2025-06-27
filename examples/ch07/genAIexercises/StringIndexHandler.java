// 7.3.5节, 生成式AI练习: StringIndexHandler.java
// 捕获当代码尝试访问字符串范围之外的字符时引发的异常。
// 程序应捕获并显示IndexOutOfBoundsException。
// 也可以捕获更具体的StringIndexOutOfBoundsException。

public class StringIndexHandler {
    public static void main(String[] args) {
        String text = "Hello";
        int invalidIndex = 10;  // 故意使用超出范围的索引
        
        try {
            // 尝试访问超出字符串长度的索引
            char invalidChar = text.charAt(invalidIndex);
            System.out.printf("索引位置%d的字符是: %c%n", invalidIndex, invalidChar);
        } 
        catch (IndexOutOfBoundsException e) {
            // 捕获并显示详细的异常信息
            System.out.printf("错误：尝试访问超出字符串范围的索引%n");
            System.out.printf("字符串长度: %d, 尝试访问的索引: %d%n", text.length(), invalidIndex);
            System.out.printf("异常详细信息: %s%n", e.getMessage());
        }
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
