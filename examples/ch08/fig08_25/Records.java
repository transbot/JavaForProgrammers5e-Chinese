// 图8.25: Records.java
// Employee记录类
record Employee(
   String first,
   String last,
   double salary,
   String department) {

   // 用于数据校验的紧凑构造函数
   Employee {
      if (salary < 0.0) {
         throw new IllegalArgumentException("工资必须 >= 0.0");
      }
   }
}

public class Records {
   public static void main(String[] args) {
      Employee e1 = new Employee("张", "无忌", 5000, "技术部");
      Employee e2 = new Employee("赵", "敏", 7600, "销售部");
      Employee e3 = new Employee("赵", "敏", 7600, "销售部");
      
      System.out.println("获取员工的字符串表示形式:");
      System.out.printf("e1: %s%ne2: %s%ne3: %s%n%n", e1, e2, e3);

      System.out.println("从e1获取数据:");
      System.out.printf("名字: %s%n", e1.first());
      System.out.printf("姓氏: %s%n", e1.last());
      System.out.printf("工资: %.2f%n", e1.salary());
      System.out.printf("部门: %s%n%n", e1.department());
      
      System.out.println("比较员工对象是否相等:");
      System.out.printf("e1.equals(e2): %b%n", e1.equals(e2));
      System.out.printf("e2.equals(e3): %b%n%n", e2.equals(e3));

      System.out.println("创建工资无效的员工:");
      Employee e4 = new Employee("周", "芷若", -1000, "技术部");
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
