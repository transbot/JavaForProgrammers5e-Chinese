// 图9.6: Employee.java
// Employee抽象超类
import java.math.BigDecimal;

public abstract class Employee {
   private final String name;

   // 构造函数
   public Employee(String name) {this.name = name;}

   // 返回姓名
   public String getName() {return name;}

   // 返回Employee的字符串表示形式
   @Override
   public String toString() {return String.format("姓名: %s", getName());}

   // 抽象方法必须由具体的子类重写
   public abstract BigDecimal calculateEarnings(); // 不提供实现
} 



/**************************************************************************
 * (C) Copyright 1992-2025 by Deitel & Associates, Inc. and               *
 * Pearson Education, 2024. All Rights Reserved.                           *
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
