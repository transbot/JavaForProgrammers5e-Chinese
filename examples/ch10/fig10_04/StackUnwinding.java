// 图10.4: StackUnwinding.java
// 演示“栈展开”和从异常对象中获取数据

public class StackUnwinding {
   public static void main(String[] args) {
      try {
         method1(); 
      } 
      catch (Exception exception) { // 捕获method1中抛出的异常
         System.err.printf("%s%n%n", exception.getMessage());
         exception.printStackTrace(); 

         // 获取栈跟踪信息
         StackTraceElement[] traceElements = exception.getStackTrace();
         
         System.out.printf("%n从getStackTrace获取的栈跟踪：%n");
         System.out.println("类名\t\t文件名\t\t\t行号\t方法名");

         // 循环遍历traceElements获取异常描述
         for (StackTraceElement element : traceElements) {
            System.out.printf("%s\t", element.getClassName());
            System.out.printf("%s\t", element.getFileName());
            System.out.printf("%s\t", element.getLineNumber());
            System.out.printf("%s%n", element.getMethodName());
         } 
      }
   } 

   // 调用method2；将异常抛回给main
   public static void method1() throws Exception {
      method2();
   }

   // 调用method3；将异常抛回给method1
   public static void method2() throws Exception {
      method3();
   } 

   // 将异常抛回给method2
   public static void method3() throws Exception {
      throw new Exception("在method3中抛出了异常");
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
