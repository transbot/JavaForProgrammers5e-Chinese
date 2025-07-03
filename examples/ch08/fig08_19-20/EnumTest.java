// 图8.20: EnumTest.java
// 测试枚举类型Book
import java.util.EnumSet;

public class EnumTest {
   public static void main(String[] args) {
      System.out.println("所有书籍:");

      // 打印Book枚举中的所有书
      for (Book book : Book.values()) {                       
         System.out.printf("%-10s%-57s%s%n", book,
             book.getTitle(), book.getCopyrightYear());
      }

      System.out.printf("%n显示指定范围内的枚举常量:%n");
    
      // 打印前4本书
      for (Book book : EnumSet.range(Book.JHTP, Book.CPPHTP)) {
         System.out.printf("%-10s%-57s%s%n", book,
             book.getTitle(), book.getCopyrightYear());
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
