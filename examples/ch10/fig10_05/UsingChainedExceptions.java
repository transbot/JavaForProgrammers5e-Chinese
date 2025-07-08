// 图10.5: UsingChainedExceptions.java
// 链式异常

public class UsingChainedExceptions {
   public static void main(String[] args) {
      try {
         method1(); 
      } 
      catch (Exception exception) { // 从method1抛出的异常
         exception.printStackTrace();
      } 
   } 

   // 调用method2；将异常抛回给main
   public static void method1() throws Exception {
      try {
         method2(); 
      } 
      catch (Exception exception) { // 从method2抛出的异常
         throw new Exception("method1中抛出的异常", exception);
      } 
   }

   // 调用method3；将异常抛回给method1
   public static void method2() throws Exception {
      try {
         method3();
      } 
      catch (Exception exception) { // 从method3抛出的异常
         throw new Exception("method2中抛出的异常", exception);
      }
   } 

   // 将异常抛回给method2
   public static void method3() throws Exception {
      throw new Exception("method3中抛出的异常");
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
