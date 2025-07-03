// 图8.24: PackageDataTest.java
// 类的包访问权限成员可以被
// 同一个包中的其他类访问

public class PackageDataTest {
   public static void main(String[] args) {
      var packageData = new PackageData();

      // 输出packageData的字符串表示形式
      System.out.printf("实例化之后:%n%s%n", packageData);

      // 修改packageData对象中的包访问权限数据
      packageData.number = 77;                           
      packageData.string = "Goodbye";                    

      // 输出packageData的字符串表示形式
      System.out.printf("%n修改值之后:%n%s%n", packageData);
   } 
} 

// 具有包访问权限实例变量的类
class PackageData {
   int number = 0;          // 包访问权限的实例变量         
   String string = "Hello"; // 包访问权限的实例变量

   // 返回PackageData对象的字符串表示形式
   public String toString() {
      return String.format("number: %d; string: %s", number, string);
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
