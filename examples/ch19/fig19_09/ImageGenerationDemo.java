// 图19.9: ImageGenerationDemo.java
// 文生图演示
import deitel.openai.OpenAIUtilities;
import java.nio.file.Path;

public class ImageGenerationDemo {
   public static void main(String[] args) throws Exception {      
      // 获取outputs文件夹的路径
      Path path = Path.of(System.getProperty("user.dir"))
        .getParent().resolve("resources").resolve("outputs");     

      // 使用OpenAI图像API和dall-e-3模型来文生图
      System.out.println("文生图演示");
      String prompt = """
         日漫风格的一只边牧，采用霓虹色彩，
         背景为黑色。""";
      System.out.printf("正在生成图片:%n%s%n", prompt);
      OpenAIUtilities.image("dall-e-3", prompt,
         Path.of(path.toString(), "边牧(动漫).png"));

      prompt = "梵高绘画风格的一只边牧";
      System.out.printf("%n正在生成图片:%n%s%n", prompt);
      OpenAIUtilities.image("dall-e-3", prompt,
         Path.of(path.toString(), "边牧(梵高).png"));

      prompt = "达芬奇风格的一只边牧";
      System.out.printf("%n正在生成图片:%n%s%n", prompt);
      OpenAIUtilities.image("dall-e-3", prompt,
         Path.of(path.toString(), "边牧(达芬奇).png"));
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
