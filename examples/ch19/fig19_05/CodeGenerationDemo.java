// 图19.5：CodeGenerationDemo.java
// 生成模拟掷骰代码
import deitel.openai.OpenAIUtilities;
import deitel.openai.OpenAIUtilities.Message;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeGenerationDemo {
   public static void main(String[] args) throws Exception {
      // 存储生成的Java源代码的路径
      Path codePath = Path.of(System.getProperty("user.dir"))
         .getParent().resolve("resources");

      // 使用OpenAI的gpt-4o模型生成Java代码
      System.out.println("生成掷骰模拟代码");
      String response = OpenAIUtilities.chat("gpt-4o",
         List.of(
            new Message("system",
               "您是一位Java最新版本的专家程序员。"),
            new Message("user", """
               创建一个名为RollDie的Java类，模拟
               尽可能快地掷骰6亿次。统计频率并以
               左对齐方式显示在双列表格中，
               列标题为"点数"和"次数"。
               避免使用循环。在代码中使用三空格的缩进，
               并将每行代码限制在74个字符以内。""")
         )
      );
      System.out.printf("%s%n%n", response);

      // 使用正则表达式提取代码并写入磁盘；
      // 该模式提取分隔符"```java"和"```"
      // 之间的所有文本
      Pattern pattern =
         Pattern.compile("```java\\s+(.*?)```", Pattern.DOTALL);
      Matcher matcher = pattern.matcher(response);

      // 如果匹配成功，将其写入文件RollDie.java
      if (matcher.find()) {
         Files.writeString(
            Path.of(codePath.toString(), "RollDie.java"),
            matcher.group(1).trim(),
            StandardOpenOption.TRUNCATE_EXISTING);
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
