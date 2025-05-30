// 图12.3: UsingToArray.java
// Viewing arrays as Lists and converting Lists to arrays.
import java.util.LinkedList;
import java.util.Arrays;

public class UsingToArray {
   public static void main(String[] args) {
      String[] colors = {"black", "blue", "yellow"};
      LinkedList<String> list = new LinkedList<>(Arrays.asList(colors));

      list.addLast("red"); // add as last item   
      list.add("pink"); // add to the end        
      list.add(3, "green"); // add at 3rd index  
      list.addFirst("cyan"); // add as first item

      // get LinkedList elements as an array           
      colors = list.toArray(new String[list.size()]);

      System.out.println("colors: ");

      for (String color : colors) {
         System.out.println(color);
      }
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
