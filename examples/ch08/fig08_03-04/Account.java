// 图8.3: Account.java
// Account类的一个构造函数可以初始化name

public class Account {
   private String name; // 实例变量

   // 该构造函数用参数name的值初始化name实例变量
   public Account(String name) { // 构造函数的名称就是类名
      this.name = name;                                           
   }

   // name的赋值方法（也称为set方法或setter）
   public void setName(String name) {
      this.name = name; 
   }

   // name的取值方法（也称为get方法或getter）
   public String getName() {
      return name; 
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
