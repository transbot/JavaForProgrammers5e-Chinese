// 图8.7: Card.java
// 用于表示一张扑克牌的Card类

public class Card {
   private final String face; // 牌的点数（如"A"、"2"、"K"等）
   private final String suit; // 牌的花色（如"红桃♥"、"黑桃♠"等）

   // 双参数构造函数，初始化牌的点数和花色
   public Card(String face, String suit) {
      this.face = face; // 初始化牌的点数
      this.suit = suit; // 初始化牌的花色
   } 

   // 返回牌的中文表示形式
   public String toString() {             
      return suit + face; // 格式：花色+点数
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
