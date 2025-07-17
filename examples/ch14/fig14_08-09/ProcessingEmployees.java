// 图14.9: ProcessingEmployees.java
// 处理Employee对象流
import java.util.Comparator;
import java.util.List;
import java.util.Map;               
import java.util.function.Function; 
import java.util.function.Predicate;
import java.util.stream.Collectors; 

public class ProcessingEmployees {
   public static void main(String[] args) {

      // 初始化List<Employee>
      List<Employee> list = List.of(
         new Employee("James", "Roy", 5000, "IT"),
         new Employee("Zaynab", "Hanna", 7600, "IT"),
         new Employee("Zoe", "Lopez", 3587.5, "Sales"),
         new Employee("Mateo", "Lopez", 4700.77, "Marketing"),
         new Employee("Diego", "Lopez", 3200, "IT"),
         new Employee("Emma", "Bernard", 6200, "Sales"),
         new Employee("Xinyi", "Chen", 4236.4, "Marketing"));

      // 显示所有员工
      System.out.println("完整员工列表：");
      list.stream().forEach(System.out::println);
      
      // 该谓词为工资在$4000-$6000范围内的员工返回true       
      Predicate<Employee> salaryInRange4to6k =                   
         e -> (e.salary() >= 4000 && e.salary() <= 6000);

      // 显示工资在$4000-$6000范围内的所有员工，
      // 按工资进行升序排序
      System.out.printf(
         "%n月薪$4000-$6000的已排序员工：%n");
      list.stream()                                         
          .filter(salaryInRange4to6k)                        
          .sorted(Comparator.comparing(Employee::salary))
          .forEach(System.out::println);                    

      // 显示工资在$4000-$6000范围内的第一位员工
      System.out.printf("%n第一位月薪在$4000-$6000的员工：%n%s%n",
         list.stream()                 
             .filter(salaryInRange4to6k)
             .findFirst()
             .get());

      // 用于从Employee获取名字和姓氏的函数
      Function<Employee, String> byFirstName = Employee::firstName;
      Function<Employee, String> byLastName = Employee::lastName;  

      // 先按姓氏然后按名字比较Employee的比较器
      Comparator<Employee> lastThenFirst =                           
         Comparator.comparing(byLastName).thenComparing(byFirstName);

      // 先按姓氏然后按名字升序排序员工 
      System.out.printf(
         "%n先按姓氏然后按名字升序排序的员工：%n");
      list.stream()
          .sorted(lastThenFirst)
          .forEach(System.out::println);

      // 按姓氏然后名字降序排序员工
      System.out.printf(
         "%n先按姓氏然后按名字降序排序的员工：%n");
      list.stream()
          .sorted(lastThenFirst.reversed())
          .forEach(System.out::println);

      // 显示排序后的唯一员工姓氏
      System.out.printf("%n唯一的员工姓氏：%n");
      list.stream()
          .map(Employee::lastName)
          .distinct()                
          .sorted()
          .forEach(System.out::println);

      // 仅显示名字和姓氏
      System.out.printf(
         "%n先按姓氏然后按名字升序排序的员工姓名：%n"); 
      list.stream()
          .sorted(lastThenFirst)
          .map(Employee::getName)
          .forEach(System.out::println);

      // 按部门分组员工
      System.out.printf("%n按部门分组的员工：%n"); 
      Map<String, List<Employee>> groupedByDepartment =               
         list.stream()                                                
             .collect(Collectors.groupingBy(Employee::department));
      groupedByDepartment.forEach(                                    
         (department, employeesInDepartment) -> {                     
            System.out.printf("%s%n", department);                  
            employeesInDepartment.forEach(                            
               employee -> System.out.printf("   %s%n", employee));   
         }                                                            
      );                                                              

      // 统计每个部门的员工数量
      System.out.printf("%n按部门统计的员工数量：%n"); 
      Map<String, Long> employeeCountByDepartment =                 
         list.stream()                                              
             .collect(Collectors.groupingBy(Employee::department,
                Collectors.counting()));                            
      employeeCountByDepartment.forEach(                            
         (department, count) -> System.out.printf(                  
            "%s有%d名员工%n", department, count));         

      // 使用DoubleStream的sum方法计算员工总工资
      System.out.printf(
         "%n员工总工资（通过sum方法）：%.2f%n",
         list.stream()
             .mapToDouble(Employee::salary)
             .sum());

      // 使用Stream的reduce方法计算员工总工资
      System.out.printf(
         "员工总工资（通过reduce方法）：%.2f%n",
         list.stream()
             .mapToDouble(Employee::salary)              
             .reduce(0, (value1, value2) -> value1 + value2));  

      // 使用DoubleStream的average方法计算员工平均工资
      System.out.printf("员工平均工资：%.2f%n",
         list.stream()
             .mapToDouble(Employee::salary)
             .average()
             .getAsDouble());      
   } 
}
 


 
 /*************************************************************************
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
