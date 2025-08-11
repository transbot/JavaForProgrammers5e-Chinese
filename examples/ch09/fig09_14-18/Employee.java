// 图9.15: Employee.java
// Employee与CompensationModel是"有一个"（has-a）关系
import java.math.BigDecimal;

public final class Employee {
   private final String name;
   private CompensationModel model; // has-a关系

   // 传入一个对CompensationModel实现的引用，
   // 从而通过“构造函数注入”（constructor injection）来初始化模型
   public Employee(String name, CompensationModel model) {
      this.name = name;
      this.model = model; // 构造函数注入
   }

   // 赋值方法（setter）执行“属性注入”（property injection）操作
   // 将模型替换为新的CompensationModel实现
   public void setCompensationModel(CompensationModel model) {
      this.model = model; // 属性注入
   }

   // 返回当前的CompensationModel实例
   public CompensationModel getCompensationModel() {return model;}

   // 使用CompensationModel计算员工收入
   public BigDecimal calculateEarnings() {
      return model.calculateEarnings();
   }

   // 返回Employee对象的字符串表示
   @Override
   public String toString() {
      return String.format("%s\n%s", name, model.toString());
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
