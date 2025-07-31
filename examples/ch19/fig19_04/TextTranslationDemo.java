// 图19.4: TextTranslationDemo.java
// 在不同的口头语言之间翻译
import deitel.openai.OpenAIUtilities;

public class TextTranslationDemo {
   public static void main(String[] args) throws Exception {
      // 使用OpenAI的gpt-4o模型翻译文本
      System.out.println("翻译演示");
      String english =
         "Today was a beautiful day. Tomorrow looks like bad weather.";
      System.out.printf("原文: %s%n%n", english);

      System.out.println("正在将英语翻译为西班牙语...");
      String spanish =
         OpenAIUtilities.translate("gpt-4o", english, "Spanish");
      System.out.printf("西班牙语: %s%n%n", spanish);

      System.out.println("正在将英语翻译为中文...");
      String chinese =
         OpenAIUtilities.translate("gpt-4o", english, "Chinese");
      System.out.printf("中文: %s%n%n", chinese);

      System.out.println("正在将西班牙语翻译为英语...");
      String spanishToEnglish =
         OpenAIUtilities.translate("gpt-4o", spanish, "English");
      System.out.printf(
         "西班牙语转回英语: %s%n%n", spanishToEnglish);

      System.out.println("正在将中文翻译为英语...");
      String chineseToEnglish =
         OpenAIUtilities.translate("gpt-4o", chinese, "English");
      System.out.printf(
         "中文转回英语: %s%n", chineseToEnglish);
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
