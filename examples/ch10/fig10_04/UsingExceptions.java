// 图10.4: UsingExceptions.java
// Stack unwinding and obtaining data from an exception object.

public class UsingExceptions {
   public static void main(String[] args) {
      try {
         method1(); 
      } 
      catch (Exception exception) { // catch exception thrown in method1
         System.err.printf("%s%n%n", exception.getMessage());
         exception.printStackTrace(); 

         // obtain the stack-trace information
         StackTraceElement[] traceElements = exception.getStackTrace();
         
         System.out.printf("%nStack trace from getStackTrace:%n");
         System.out.println("Class\t\tFile\t\t\tLine\tMethod");

         // loop through traceElements to get exception description
         for (StackTraceElement element : traceElements) {
            System.out.printf("%s\t", element.getClassName());
            System.out.printf("%s\t", element.getFileName());
            System.out.printf("%s\t", element.getLineNumber());
            System.out.printf("%s%n", element.getMethodName());
         } 
      }
   } 

   // call method2; throw exceptions back to main
   public static void method1() throws Exception {
      method2();
   }

   // call method3; throw exceptions back to method1
   public static void method2() throws Exception {
      method3();
   } 

   // throw Exception back to method2
   public static void method3() throws Exception {
      throw new Exception("Exception thrown in method3");
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
