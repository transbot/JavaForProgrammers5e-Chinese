// 图8.21: Employee.java
// 用静态变量维护内存中
// Employee对象的计数

public class Employee {
   private static int count = 0; // 已创建的Employee对象数量
   private String firstName;
   private String lastName;

   // 初始化Employee对象，静态count递增1，并输出
   // 一个字符串来证明构造函数已被调用
   public Employee(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;

      ++count; // 递增员工的静态count
      System.out.printf("Employee构造函数: %s %s; count = %d%n",
         firstName, lastName, count);
   } 

   // 获取名字
   public String getFirstName() {
      return firstName; 
   } 

   // 获取姓氏
   public String getLastName() {
      return lastName; 
   } 

   // 静态方法用于获取静态count的值
   public static int getCount() {            
      return count;                          
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
