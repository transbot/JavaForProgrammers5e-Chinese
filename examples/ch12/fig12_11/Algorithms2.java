// 图12.11: Algorithms2.java
// Collections methods addAll, frequency and disjoint.
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms2 {
   public static void main(String[] args) {
      // initialize list1 and list2
      String[] colors = {"red", "white", "yellow", "blue"};
      List<String> list1 = Arrays.asList(colors);
      List<String> list2 = new ArrayList<>();

      list2.add("black"); // add "black" to the end of list2
      list2.add("red"); // add "red" to the end of list2
      list2.add("green"); // add "green" to the end of list2

      System.out.printf("Before addAll, list2 contains: %s%n", list2);
      Collections.addAll(list2, colors); // add colors Strings to list2
      System.out.printf("After addAll, list2 contains: %s%n", list2);

      // get frequency of "red"                           
      int frequency = Collections.frequency(list2, "red");
      System.out.printf("%nFrequency of red in list2: %d%n", frequency);

      // check whether list1 and list2 have any elements in common
      boolean areDisjoint = Collections.disjoint(list1, list2);  

      System.out.printf("list1 and list2 %s elements in common%n", 
         (areDisjoint ? "do not have" : "have"));
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
