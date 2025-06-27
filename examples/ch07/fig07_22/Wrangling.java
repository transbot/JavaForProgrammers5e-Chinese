
// 图7.22: Wrangling.java
// 训练大语言模型前的简单数据整理任务
import java.util.Arrays;

public class Wrangling {
   public static void main(String[] args) {
      String corpus = """
         In C++, an int  on one  machine  might be 16 bits     (2 bytes) 
         of   memory,    on another    32 bits (4 bytes), and on another 
         64 bits (8 bytes).    In Java,   int values are  always 32 bits 
         (4 bytes). The eight  primitive types in Java -- boolean, byte, 
         char, double, float, int, long and short -- are portable across 
         all     computer     platforms      that     support      Java。
         """;      
      System.out.printf("初始语料:%n%s%n", corpus);

      // 将语料转换为小写
      String lowercased = corpus.toLowerCase();
      System.out.printf("小写转换后的语料:%n%s%n", lowercased);   

      // 移除标点符号（包括中文标点）
      String noPunctuation = lowercased.replaceAll("\\p{P}", "");
      System.out.printf("移除标点后的语料:%n%s%n", noPunctuation);   

      // 将连续空白字符折叠为单个空格
      String spacingNormalized = noPunctuation.replaceAll("\\s+", " ");
      System.out.printf("空格规范化后的语料:%n%s%n%n", spacingNormalized);

      // 对文本进行词元化（按空格分割）
      String[] tokenized = spacingNormalized.split(" ");
      System.out.printf("词元化结果:%n%s%n", Arrays.toString(tokenized));
   }
}

/*
 **************************************************************************
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
 **************************************************************************
*/