// 图19.1: TextSummarizationDemo.java
// 将文字记录总结为摘要段落和要点
import deitel.openai.OpenAIUtilities;
import deitel.openai.OpenAIUtilities.Message;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextSummarizationDemo {
   public static void main(String[] args) throws Exception {
      // 加载transcript.txt文件
      Path transcriptPath = Path.of(System.getProperty("user.dir"))
         .getParent().resolve("resources").resolve("transcript.txt");
      String transcript = Files.readString(transcriptPath);

      // 使用OpenAI的gpt-4o模型生成摘要段落
      System.out.println("为一份文字记录创建摘要");
      String summaryAbstract = OpenAIUtilities.chat("gpt-4o",
         List.of(
            new Message("system", """
               给定一份技术演讲的文字记录，请创建
               一个简洁、清晰的摘要段落。使用直接
               的写作风格，避免使用介词短语，
               并采用直截了当的句子结构。
               聚焦于要点，不要提及演讲者。
               抓住核心思想，使人无需阅读全文
               即可理解。请用中文回答。"""),
            new Message("user", transcript)
         )
      );
      System.out.printf("%s%n%n", summaryAbstract);

      // 使用OpenAI的gpt-4o模型提取要点
      System.out.println("从文字记录中提取要点");
      String keyPoints = OpenAIUtilities.chat("gpt-4o",
         List.of(
            new Message("system", """
               给定一份技术演讲的文字记录，请识别前5个要点，
               并按编号列出。对于每个点，使用简洁、直接、清晰
               且直截了当的句子。避免使用介词短语。
               请用中文回答。"""),
            new Message("user", transcript)
         )
      );
      System.out.printf("%s%n", keyPoints);
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
