// 图19.6: NamedEntityRecognitionDemo.java
// 识别命名实体并获取结构化输出
import deitel.openai.OpenAIUtilities;
import deitel.openai.OpenAIUtilities.Message;
import deitel.openai.OpenAIUtilities.NamedEntities;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NamedEntityRecognitionDemo {
   public static void main(String[] args) throws Exception {
      // 加载web.txt文件
      Path transcriptPath = Path.of(System.getProperty("user.dir"))
         .getParent().resolve("resources").resolve("web.txt");
      String text = Files.readString(transcriptPath);

      // 创建请求以获取命名实体
      NamedEntities results = OpenAIUtilities.chatWithStructuredOutput(
         "gpt-4o",
         List.of(
            new Message("system", """
                您是使用OntoNotes 5.0 NER标签集的
                命名实体识别（NER）专家。
                请分析以下文本，并返回符合指定结构化
                JSON格式的命名实体。
                不要在JSON响应中包含任何额外信息。"""),  
            new Message("user", text)
         ),
         OpenAIUtilities.NamedEntities.class
      );

      // 显示原始文本
      System.out.printf("原始文本:%n%s%n%n", text);

      // 显示命名实体
      System.out.println("实体:");
      results.entities().forEach(entity ->
         System.out.printf("%s: %s%n", entity.text(), entity.tag()));
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
