// 图8.8: DeckOfCards.java
// 用于表示一副扑克牌的DeckOfCards类
import java.util.random.RandomGenerator; 

public class DeckOfCards {
   // 随机数生成器
   private static final RandomGenerator randomNumbers = 
      RandomGenerator.getDefault();
   public static final int NUMBER_OF_CARDS = 52;    // 一副牌中有多少张牌（这常量）
   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card引用数组
   private int currentCardIndex = 0;    // 下一张待发牌的索引 (0~51)

   // 构造函数初始化牌组
   public DeckOfCards() {
      String[] faces = {"A", "2", "3", "4", "5", "6",
         "7", "8", "9", "10", "J", "Q", "K"};    
      String[] suits = {"红桃♥", "方块♦", "梅花♣", "黑桃♠"};

      // 用Card对象填充牌组                  
      for (int count = 0; count < deck.length; ++count) {  
         deck[count] = new Card(faces[count % 13], suits[count / 13]);
      }
   } 

   // 使用单遍（one-pass）算法洗牌
   public void shuffle() {
      // 下次发牌从deck[0]开始
      currentCardIndex = 0; 

      // 遍历每张牌，随机选择另一张牌(0~51)并交换位置
      for (int first = 0; first < deck.length; ++first) {
         // 随机选择0~51之间的数字
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // 交换当前牌与随机选择的牌
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
   } 

   // 发一张牌
   public Card dealCard() {
      // 检查是否还有牌可发
      if (currentCardIndex < deck.length) {
         return deck[currentCardIndex++]; // 返回数组中的当前牌
      } 
      else {
         return null; // 返回null表示所有牌已发完
      } 
   } 
} // 结束DeckOfCards类



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
