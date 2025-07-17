// 图14.4: RandomIntegers.java
// 平移和缩放的随机整数。
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class RandomIntegers {
   public static void main(String[] args) {
      var random = RandomGenerator.getDefault();

      // 在单独的行上显示10个随机整数
      System.out.println("随机数分行显示：");
      random.ints(10, 1, 7)               
            .forEach(System.out::println);

      // 在同一行上显示10个随机整数
      String numbers = 
         random.ints(10, 1, 7)                   
               .mapToObj(String::valueOf)        
               .collect(Collectors.joining(" "));
      System.out.printf("%n随机数在一行中显示： %s%n", numbers);

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
