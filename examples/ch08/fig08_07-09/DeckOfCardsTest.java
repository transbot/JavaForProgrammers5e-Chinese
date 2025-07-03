// 图8.9: DeckOfCardsTest.java
// 洗牌和发牌演示

public class DeckOfCardsTest {
   // 程序执行入口
   public static void main(String[] args) {
      var myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // 将牌随机排序
      
      // 按发牌顺序打印所有52张牌
      for (int i = 1; i <= DeckOfCards.NUMBER_OF_CARDS; ++i) {
         // 发牌并显示当前牌
         System.out.printf("%-19s", myDeckOfCards.dealCard());

         if (i % 4 == 0) { // 每发4张牌就换行
            System.out.println();
         } 
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
