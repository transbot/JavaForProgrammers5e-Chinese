// 图8.19: Book.java
// 该枚举类型包含构造函数和显式的实例字段，
// 并为这些字段提供了取值函数

public enum Book {
   // 声明枚举常量
   JHTP("Java How to Program", "2025"),                       
   CHTP("C How to Program", "2020"),                          
   CPP20FP("C++20 for Programmers", "2023"),
   CPPHTP("C++ How to Program", "2024"),                      
   PYCDS("Intro to Python for Computer Science and Data Science", "2020"),
   PYFP("Python for Programmers", "2020");             

   // 枚举的实例字段
   private final String title;         // 书名
   private final String copyrightYear; // 版权年份

   // 枚举的构造函数
   Book(String title, String copyrightYear) {
      this.title = title;
      this.copyrightYear = copyrightYear;
   } 

   // title字段的取值函数
   public String getTitle() {
      return title;
   } 

   // copyrightYear字段的取值函数
   public String getCopyrightYear() {
      return copyrightYear;
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
