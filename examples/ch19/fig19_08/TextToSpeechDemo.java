// 图19.8: TextToSpeechDemo.java
// Synthesizing speech from text.
import deitel.openai.OpenAIUtilities;
import java.nio.file.Path;

public class TextToSpeechDemo {
   public static void main(String[] args) throws Exception {
      // 获取outputs文件夹的路径
      Path outputPath = Path.of(System.getProperty("user.dir"))
        .getParent().resolve("resources").resolve("outputs");   

      // 使用OpenAI的tts-1-hd模型从文本合成主意
      System.out.println("文本转语音演示");
      System.out.println("正在合成英语语音...");
      String english =
         "Today was a beautiful day. Tomorrow looks like bad weather.";
      OpenAIUtilities.textToSpeech("tts-1-hd", english, "alloy",
         Path.of(outputPath.toString(), "english.mp3").toString());

      System.out.println("正在合成西班牙语语音...");
      String spanish =
         "Hoy fue un día hermoso. Mañana parece que habrá mal tiempo.";
      OpenAIUtilities.textToSpeech("tts-1-hd", spanish, "alloy",
         Path.of(outputPath.toString(), "spanish.mp3").toString());

      System.out.println("正在合成中文语音...");
      String chinese = "今日天气很好，明天就有点糟糕了。";
      OpenAIUtilities.textToSpeech("tts-1-hd", chinese, "alloy",
         Path.of(outputPath.toString(), "chinese.mp3").toString());         

      System.out.println("正在合成日语语音...");
      String japanese = "今日は美しい日でした。明日は悪天候になりそうです。";
      OpenAIUtilities.textToSpeech("tts-1-hd", japanese, "alloy",
         Path.of(outputPath.toString(), "japanese.mp3").toString());
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
