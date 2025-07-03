// 图8.15: Time2Test.java
// 使用重载构造函数初始化多个Time2对象

public class Time2Test {
   public static void main(String[] args) {
      var t1 = new Time2(); // 00:00:00          
      var t2 = new Time2(2); // 02:00:00         
      var t3 = new Time2(21, 34); // 21:34:00    
      var t4 = new Time2(12, 25, 42); // 12:25:42
      var t5 = new Time2(t4); // 12:25:42        

      System.out.println("构造结果：");
      displayTime("t1: 全部使用默认参数", t1);
      displayTime("t2: 指定小时；默认分钟和秒", t2);
      displayTime("t3: 指定小时和分钟；默认秒", t3);
      displayTime("t4: 指定小时、分钟和秒", t4);
      displayTime("t5: 指定Time2对象t4", t5);

      // 尝试用非法值初始化t6
      try {
         var t6 = new Time2(27, 74, 99); // 非法值
      } 
      catch (IllegalArgumentException e) {
         System.out.printf("%n初始化t6时发生异常: %s%n",
            e.getMessage());
      } 
   } 

   // 以24小时制和12小时制格式显示Time2对象
   private static void displayTime(String header, Time2 t) {
      System.out.printf("%s%n   %s%n   %s%n",
         header, t.toUniversalString(), t.toString());
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
