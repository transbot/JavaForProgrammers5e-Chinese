// 图7.11: StringBuilderCapLen.java
// StringBuilder类的Length、setLength、capacity和ensureCapacity方法

public class StringBuilderCapLen {
   public static void main(String[] args) {
      var buffer = new StringBuilder("问问他山水相逢的命运谁在替她安排");

      System.out.printf("缓冲区内容 = %s%n长度 = %d%n容量 = %d%n%n",
         buffer.toString(), buffer.length(), buffer.capacity());

      buffer.ensureCapacity(75); // 确保最小容量为75
      System.out.printf("新容量 = %d%n%n", buffer.capacity());
      
      buffer.setLength(10); // 设置新长度为10（截断字符串）
      System.out.printf("新长度 = %d%n缓冲区内容 = %s%n", 
         buffer.length(), buffer.toString());
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
