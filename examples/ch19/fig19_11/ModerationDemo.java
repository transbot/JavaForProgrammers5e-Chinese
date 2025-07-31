// 图19.11: ModerationDemo.java
// 使用OpenAI审核API检查攻击性内容
import deitel.openai.OpenAIUtilities;
import java.util.Scanner;

public class ModerationDemo {
   public static void main(String[] args) {
      var input = new Scanner(System.in);

      System.out.print("输入提示语(exit退出)：");
      String prompt = input.nextLine();

      while (!prompt.toLowerCase().equals("exit")) {
         var result = OpenAIUtilities.checkPrompt(prompt);

         if (!result.getFlagged()) {
            System.out.println(
               "提示语未检测到攻击性内容");
         }
         else {
            var categories = result.getCategories();
            var scores = result.getCategoryScores();

            // 显示报告
            System.out.println("攻击性内容类别及分数：");
            System.out.printf("""
               骚扰: %b %.2f; 威胁: %b %.2f
               仇恨: %b %.2f; 威胁: %b %.2f
               自残: %b %.2f; 指导: %b %.2f; 意图: %b %.2f
               性相关: %b %.2f; 未成年人: %b %.2f
               暴力: %b %.2f; 画面: %b %.2f%n""",
               categories.getHarassment(), scores.getHarassment(),
               categories.getHarassmentThreatening(),
               scores.getHarassmentThreatening(),
               categories.getHate(), scores.getHate(),
               categories.getHateThreatening(),
               scores.getHateThreatening(),
               categories.getSelfHarm(), scores.getSelfHarm(),
               categories.getSelfHarmInstructions(),
               scores.getSelfHarmInstructions(),
               categories.getSelfHarmIntent(), scores.getSelfHarmIntent(),
               categories.getSexual(), scores.getSexual(),
               categories.getSexualMinors(), scores.getSexualMinors(),
               categories.getViolence(), scores.getViolence(),
               categories.getViolencGraphic(),
               scores.getViolencGraphic());
         }

         System.out.print("\n输入提示语(exit退出)：");
         prompt = input.nextLine();
      }
   }
}
