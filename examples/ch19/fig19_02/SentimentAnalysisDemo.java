// 图19.2: SentimentAnalysisDemo.java
// 分析文字记录的情感
import deitel.openai.OpenAIUtilities;
import deitel.openai.OpenAIUtilities.Message;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SentimentAnalysisDemo {
   public static void main(String[] args) throws Exception {
      // 加载上一级目录resources子目录中的transcript.txt
      Path transcriptPath = Path.of(System.getProperty("user.dir"))
         .getParent().resolve("resources").resolve("transcript.txt");
      String transcript = Files.readString(transcriptPath);

      // 使用OpenAI的gpt-4o模型分析文本情感
      System.out.println("分析情感");
      String sentiment = OpenAIUtilities.chat("gpt-4o",
         List.of(
            new Message("system", """
               你是一位情感分析专家。请分析以下演讲文字记录，
               并判断其情感倾向是积极、消极还是中性。
               请解释你的分析过程和结论。
               请用中文回答。"""),
            new Message("user", transcript)
         )
      );
      System.out.printf("%s%n%n", sentiment);
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
