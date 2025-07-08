// 图10.3: UsingExceptions.java
// try...catch...finally异常处理机制

public class StackUnwinding {
   public static void main(String[] args) {
      try {
         throwException(); 
      } 
      catch (Exception exception) { // throwException方法抛出的异常
         System.err.println("在main方法中处理异常");
      } 

      doesNotThrowException();
   }

   // 演示try...catch...finally
   public static void throwException() throws Exception {
      try { // 抛出异常并立即捕获它
         System.out.println("执行throwException方法");
         throw new Exception(); // 生成异常
      } 
      catch (Exception exception) { // 捕获try块中抛出的异常
         System.err.println(
            "在throwException方法中处理异常");
         throw exception; // 重新抛出以供进一步处理

         // 此处代码不可达；会导致编译错误

      } 
      finally { // 无论try...catch发生什么都会执行
         System.err.println("throwException中的finally块已执行");  
      }

      // 此处代码不可达；会导致编译错误
   } 

   // 演示未发生异常时的finally执行
   public static void doesNotThrowException() {
      try { // try块未抛出异常
         System.out.println("执行doesNotThrowException方法");
      } 
      catch (Exception exception) { // 不会执行
         System.err.println(exception);
      }
      finally { // 无论try...catch发生什么都会执行     
         System.err.println("doesNotThrowException中的finally块已执行");
      }
 
      System.out.println("doesNotThrowException方法结束");
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
