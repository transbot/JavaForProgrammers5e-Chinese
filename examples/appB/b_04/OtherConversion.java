// 图B.4: OtherConversion.java
// 使用b、B、h、H、%和n转换字符

public class OtherConversion {
   public static void main(String[] args) {
      Object test = null;
      System.out.printf("%b%n", false);
      System.out.printf("%b%n", true);
      System.out.printf("%b%n", "测试");
      System.out.printf("%B%n", test);
      System.out.printf("\"hello\"的哈希码是%h%n", "hello");
      System.out.printf("\"Hello\"的哈希码是%h%n", "Hello");
      System.out.printf("null的哈希码是%H%n", test);
      System.out.printf("在格式字符串中打印一个%%%n");
      System.out.printf("打印一个换行符%n下一行从这里开始");
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
