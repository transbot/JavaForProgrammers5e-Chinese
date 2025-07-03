// 图8.1: Account.java
// Account类具有一个name实例变量，
// 以及用于赋值和取值的实例方法。

public class Account {
   private String name; // 实例变量
 
   // name的赋值方法（也称为set方法或setter）
   public void setName(String name) {            
      this.name = name; // 存储name
   }

   // name的取值方法（也称为get方法或getter）
   public String getName() {                        
      return name; // 向调用者返回name的值
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
