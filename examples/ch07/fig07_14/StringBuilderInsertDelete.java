// 图7.14: StringBuilderInsertDelete.java
// StringBuilder的insert、delete和deleteCharAt方法

public class StringBuilderInsertDelete {
   public static void main(String[] args) {
      Object objectRef = "你好";  
      String string = "再见";  
      char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
      boolean booleanValue = true;
      char characterValue = 'K';
      int integerValue = 7;
      long longValue = 10000000;
      float floatValue = 2.5f; // f后续表明2.5是一个float
      double doubleValue = 33.333;

      var buffer = new StringBuilder();

      buffer.insert(0, objectRef);      
      buffer.insert(0, "  "); // 均包含两个空格
      buffer.insert(0, string);         
      buffer.insert(0, "  ");           
      buffer.insert(0, charArray);      
      buffer.insert(0, "  ");           
      buffer.insert(0, charArray, 3, 3);
      buffer.insert(0, "  ");           
      buffer.insert(0, booleanValue);   
      buffer.insert(0, "  ");           
      buffer.insert(0, characterValue); 
      buffer.insert(0, "  ");           
      buffer.insert(0, integerValue);   
      buffer.insert(0, "  ");           
      buffer.insert(0, longValue);      
      buffer.insert(0, "  ");           
      buffer.insert(0, floatValue);     
      buffer.insert(0, "  ");           
      buffer.insert(0, doubleValue);    

      System.out.printf(
         "插入后的buffer:%n%s%n%n", buffer.toString());

      buffer.deleteCharAt(10); // 删除2.5中的5
      buffer.delete(2, 6); // 删除33.333中的.333

      System.out.printf(
         "删除后的buffer:%n%s%n", buffer.toString());
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
