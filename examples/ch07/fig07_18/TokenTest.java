// 图7.18: TokenTest.java
// 使用String的split方法进行词元化
import java.util.Scanner;

public class TokenTest {
   public static void main(String[] args) {
      // 从用户处获取句子
      var scanner = new Scanner(System.in);
      System.out.println("请输入一句话(英文)，并按Enter键：");
      String sentence = scanner.nextLine();

      // 处理用户输入的句子
      String[] tokens = sentence.split(" ");
      System.out.printf("%n元素数量: %d%n包含的词元是:%n",
         tokens.length);

      for (String token : tokens) {
         System.out.printf("  %s%n", token);
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
