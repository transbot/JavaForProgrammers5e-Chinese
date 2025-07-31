// 图19.10: SpeechToVTTDemo.java
// 转录视频中的音轨并创建隐藏（CC）字幕
import deitel.openai.OpenAIUtilities;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SpeechToVTTDemo {
   public static void main(String[] args) throws Exception {
      // 获取资源文件夹路径
      Path resourcesFolder = Path.of(System.getProperty("user.dir"))
        .getParent().resolve("resources");   
      
      // 获取音频文件 ImplicitClass.m4a 的路径
      Path audioPath =
         Path.of(resourcesFolder.toString(), "ImplicitClass.m4a");

      // 使用OpenAI的whisper-1模型将语音转为隐藏字幕
      System.out.println(
         "正在转录音频并创建VTT字幕文件...");
      String captions =
         OpenAIUtilities.speechToVTT("whisper-1", audioPath);
      System.out.printf("字幕内容：%n%s%n", captions);

      // 将字幕输出到.vtt文件
      var captionsPath = Path.of(resourcesFolder.toString(),
         "outputs", "ImplicitClass.vtt");
      Files.writeString(captionsPath, captions.trim(),
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
