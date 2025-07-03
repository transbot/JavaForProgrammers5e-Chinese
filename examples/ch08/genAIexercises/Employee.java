// 8.13节, 生成式AI练习: Employee.java
// 针对中文地区的语言文化习惯修改本节的代码。
// 例如，将日期更改为年/月/日，将人名修改为姓在前，名在后。

// Employee类包含对其他对象的引用
public class Employee {
   private String lastName;    // 姓
   private String firstName;   // 名
   private Date birthDate;     // 生日
   private Date hireDate;      // 入职日期

   // 初始化姓名、生日和入职日期的构造函数   
   public Employee(String lastName, String firstName, Date birthDate, 
      Date hireDate) {
      this.lastName = lastName;
      this.firstName = firstName;
      this.birthDate = birthDate;
      this.hireDate = hireDate;
   } 

   // 将Employee转换为字符串
   public String toString() {
      return String.format("%s%s  生日: %s  入职: %s", 
         lastName, firstName, birthDate, hireDate);
   } 
}