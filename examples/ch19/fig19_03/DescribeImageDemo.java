// 图19.3: DescribeImageDemo.java
// 获取图像的无障碍描述
import deitel.openai.OpenAIUtilities;
import java.nio.file.Path;

public class DescribeImageDemo {
   public static void main(String[] args) throws Exception {
      // 资源文件夹路径（上一级目录的resources子目录）
      Path resourcesPath = Path.of(System.getProperty("user.dir"))
         .getParent().resolve("resources");

      // 使用gpt-4o获取UML图的详细描述
      System.out.println("UML图的无障碍描述");
      String diagramDescription =
         OpenAIUtilities.describeImage("gpt-4o", """
            这是一张UML活动图，展示了Java 'for'循环的控制流程，
            图中包含UML注释提供额外上下文。
            请用中文回答。""",
            Path.of(resourcesPath.toString(), "ForLoop.png"));
      System.out.printf("%s%n%n", diagramDescription);

      // 使用gpt-4o获取照片的详细描述
      System.out.println("照片的无障碍描述");
      String imageDescription =
         OpenAIUtilities.describeImage("gpt-4o", """
            这是一张海滩场景的照片。
            请详细描述照片中的每个对象和场景。请用中文回答。""",
            Path.of(resourcesPath.toString(), "beach.jpg"));
      System.out.printf("%s%n%n", imageDescription);
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
