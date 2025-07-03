
// 8.13节, 生成式AI练习: EmployeeTest.java
// 针对中文地区的语言文化习惯修改本节的代码。
// 例如，将日期更改为年/月/日，将人名修改为姓在前，名在后。

// 演示"组合"
public class EmployeeTest {
   public static void main(String[] args) {
      var birth = new Date(7, 24, 1949);
      var hire = new Date(3, 12, 1988);
      var employee = new Employee("胡", "辉", birth, hire);

      System.out.println(employee);
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
