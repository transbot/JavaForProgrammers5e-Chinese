// 图8.17: Employee.java
// Employee类包含对其他对象的引用

public class Employee {
   private String firstName;
   private String lastName;
   private Date birthDate;
   private Date hireDate; 

   // 初始化姓名、生日和入职日期的构造函数   
   public Employee(String firstName, String lastName, Date birthDate, 
      Date hireDate) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthDate = birthDate;
      this.hireDate = hireDate;
   } 

   // 将Employee转换为字符串
   public String toString() {
      return String.format("%s, %s  入职: %s  生日: %s", 
         lastName, firstName, hireDate, birthDate);
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
