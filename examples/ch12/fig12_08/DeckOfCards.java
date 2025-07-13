// 图12.8: DeckOfCards.java
// 使用Collections的shuffle方法进行洗牌和发牌
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Card类表示牌组中的一张牌
class Card {
   public enum Face {A, 二, 三, 四, 五, 六, 七, 八, 九, 十,
      J, Q, K }      
   public enum Suit {红桃, 方块, 梅花, 黑桃} 

   private final Face face; 
   private final Suit suit; 
   
   // 构造函数
   public Card(Face face, Suit suit) {
       this.face = face; // 初始化牌的点数
       this.suit = suit; // 初始化牌的花色
   } 
   
   // 返回牌点
   public Face getFace() {return face;}

   // 返回花色
   public Suit getSuit() {return suit;}

   // 返回Card的字符串表示
   public String toString() {
      return String.format("%s%s", suit, face);
   } 
} 

// DeckOfCards（牌组）类声明
public class DeckOfCards {
   private List<Card> deck = new ArrayList<>(); // 用于存储Card对象的列表

   // 设置牌组并洗牌
   public DeckOfCards() {
      // 用Card对象填充牌组
      for (Card.Suit suit : Card.Suit.values()) {
         for (Card.Face face : Card.Face.values()) {  
            deck.add(new Card(face, suit));
         } 
      } 

      Collections.shuffle(deck);  // 洗牌
   } 

   // output deck
   public void printCards() {
      // 52张牌分4列显示
      for (int i = 0; i < deck.size(); ++i) {
         System.out.printf("%-12s%s", deck.get(i),
            ((i + 1) % 4 == 0) ? System.lineSeparator() : "");
      }
   } 

   public static void main(String[] args) {
      DeckOfCards cards = new DeckOfCards();
      cards.printCards();
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
