// 图19.7: SpeechToTextDemo.java
// 将音频文件转录为文本
import deitel.openai.OpenAIUtilities;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SpeechToTextDemo {
   public static void main(String[] args) throws Exception {
      // 获取资源文件夹路径
      Path resourcesFolder = Path.of(System.getProperty("user.dir"))
        .getParent().resolve("resources");   

      // 获取音频文件 WhatsNewInJavaOverview.m4a 的路径
      Path audioPath = Path.of(resourcesFolder.toString(),
         "Java遇见AI：生成式AI时代如何用Java开发、应对挑战与测试未来？.m4a");

      // 使用OpenAI的whisper-1模型进行语音转文本
      System.out.println("正在转录，请稍候...");
      String transcript = OpenAIUtilities.speechToText(
         "whisper-1", audioPath.toString());
      System.out.printf("转录内容：%n%s%n", transcript);

      // 将转录结果写入文件，若文件已存在则覆盖
      Path transcriptPath = Path.of(resourcesFolder.toString(),
         "outputs", "Java遇见AI.txt");
      Files.writeString(transcriptPath, transcript,
         StandardOpenOption.CREATE,
         StandardOpenOption.TRUNCATE_EXISTING);
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
