// 图19.12: OpenAIUtilities.java
// 辅助方法和记录类，封装了通过Simple-OpenAI Java库
// 来调用OpenAI API的功能
package deitel.openai;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.common.ResponseFormat;
import io.github.sashirestela.openai.common.ResponseFormat.JsonSchema;
import io.github.sashirestela.openai.common.audio.Voice;
import io.github.sashirestela.openai.common.content.ContentPart;
import io.github.sashirestela.openai.domain.audio.AudioResponseFormat;
import io.github.sashirestela.openai.domain.audio.SpeechRequest;
import io.github.sashirestela.openai.domain.audio.Transcription;
import io.github.sashirestela.openai.domain.audio.TranscriptionRequest;
import io.github.sashirestela.openai.domain.chat.Chat;
import io.github.sashirestela.openai.domain.chat.ChatMessage;
import io.github.sashirestela.openai.domain.chat.ChatRequest;
import io.github.sashirestela.openai.domain.image.ImageRequest;
import io.github.sashirestela.openai.domain.moderation.Moderation;
import io.github.sashirestela.openai.domain.moderation.ModerationRequest;
import io.github.sashirestela.openai.support.Base64Util;

import java.io.FileOutputStream;
import java.net.URL;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class OpenAIUtilities {
   // 记录类，用于简化向chat和translate方法
   // 传递包含角色和内容的消息
   public record Message(String role, String content) {}

   // 创建SimpleOpenAI客户端对象
   private final static SimpleOpenAI openAI = SimpleOpenAI.builder()
      .apiKey(System.getenv("OPENAI_API_KEY")).build();

   // 执行聊天补全
   public static String chat(String chatModel, List<Message> messages) {
      // 开始构建ChatRequest
      var chatRequest = ChatRequest.builder().model(chatModel);

      // 向ChatRequest添加消息
      for (var currentMessage : makeChatMessages(messages)) {
         chatRequest = chatRequest.message(currentMessage);
      }

      var request = chatRequest.build(); // 完成请求构建

      // 发送ChatRequest并获取Chat响应
      var chatResponse = openAI.chatCompletions().create(request).join();

      return chatResponse.firstContent(); // 返回响应文本
   }

   // 辅助方法：将Message记录对象转换为SystemMessage、
   // UserMessage和AssistantMessage对象
   private static List<ChatMessage> makeChatMessages(
      List<Message> messages) {
      // 将每条Message记录转换为ChatMessage子类对象
      return messages.stream()
         .map(m -> switch(m.role().toLowerCase()) {
            case "system" ->
               ChatMessage.SystemMessage.of(m.content());
            case "user" -> ChatMessage.UserMessage.of(m.content());
            case "assistant" ->
               ChatMessage.AssistantMessage.of(m.content());
            default -> throw new IllegalArgumentException(
               "无效角色: " + m.role());
         })
         .toList();
   }

   // 执行聊天补全
   public static String describeImage(
      String chatModel, String prompt, Path imagePath) {
      // 开始构建可访问图像描述的ChatRequest
      var chatRequest = ChatRequest.builder()
         .model(chatModel)
         .message(ChatMessage.SystemMessage.of("""
            您是创建符合万维网联盟(W3C)
            指南的图像描述专家。
            请根据给定图像，
            为视障人士提供详细文本描述。"""))
         .message(ChatMessage.UserMessage.of(
            List.of(
               ContentPart.ContentPartText.of(prompt),
               ContentPart.ContentPartImageUrl.of(
                  ContentPart.ContentPartImageUrl.ImageUrl.of(
                     Base64Util.encode(imagePath.toString(),
                        Base64Util.MediaType.IMAGE))))))
         .build();

      // 发送ChatRequest并获取Chat响应
      var chatResponse =
         openAI.chatCompletions().create(chatRequest).join();

      return chatResponse.firstContent(); // 返回响应文本
   }

   // 执行翻译的聊天补全
   public static String translate(
      String chatModel, String textToTranslate, String targetLanguage) {

      // 构建翻译字符串的ChatRequest
      var chatRequest = ChatRequest.builder().model(chatModel)
         .message(ChatMessage.SystemMessage.of(String.format("""
            您是自然语言翻译专家。
            请将以下文本翻译成%s。""", targetLanguage)))
         .message(ChatMessage.UserMessage.of(textToTranslate))
         .build();

      // 创建并提交ChatRequest，等待Chat响应
      Chat response = openAI.chatCompletions().create(chatRequest).join();

      return response.firstContent(); // 返回翻译结果
   }

   // 记录类：定义了JSON响应的结构，其中包含
   // 命名实体识别的结果
   public record NamedEntity(String text, String tag) {}
   public record NamedEntities(List<NamedEntity> entities) {}

   // 泛型方法：执行聊天补全
   // 并返回结构化输出
   public static <T> T chatWithStructuredOutput(String chatModel,
      List<Message> messages, Class<T> jsonStructure) throws Exception {
      // 基于jsonStructure设置结构化输出的JSON模式
      var schema = ResponseFormat.jsonSchema(JsonSchema.builder()
         .name(jsonStructure.getSimpleName()) // 模式名称
         .schemaClass(jsonStructure) // 模式Java类
         .build()
      );

      // 开始构建返回结构化输出的ChatRequest
      var chatRequest = ChatRequest.builder()
         .model(chatModel)
         .responseFormat(schema);

      // 向ChatRequest添加消息
      for (var currentMessage : makeChatMessages(messages)) {
         chatRequest = chatRequest.message(currentMessage);
      }

      var request = chatRequest.build(); // 完成请求构建

      // 发送ChatRequest并获取Chat响应
      Chat response = openAI.chatCompletions().create(request).join();

      // 用于将JSON反序列化为NamedEntities对象的ObjectMapper
      var mapper = new ObjectMapper();

      // 返回结构化响应
      return mapper.readValue(response.firstContent(), jsonStructure);
   }

   // 将音频转录为文本
   public static String speechToText(String model, String audioPath) {
      // 构建TranscriptionRequest
      var audioRequest = TranscriptionRequest.builder()
         .file(Paths.get(audioPath))
         .model(model)
         .build();

      // 提交TranscriptionRequest并等待转录结果
      Transcription transcription =
         openAI.audios().transcribe(audioRequest).join();
      return transcription.getText(); // 返回转录文本
   }

   // 从文本合成语音
   public static void textToSpeech(String model, String text,
      String voice, String filename) throws Exception {
      // 构建SpeechRequest
      var speechRequest = SpeechRequest.builder()
         .model(model)
         .input(text)
         .voice(Voice.valueOf(voice.toUpperCase()))
         .build();

      // 提交SpeechRequest并等待音频，然后将音频保存到文件
      try (var audioStream = openAI.audios().speak(speechRequest).join();
           var audioFile = new FileOutputStream(filename)) {
         audioFile.write(audioStream.readAllBytes());
         System.out.printf("音频已写入 %s%n", filename);
      }
   }

   // 使用Dall-E生成图像
   public static void image(
      String model, String prompt, Path imagePath) throws Exception {
      // 使用指定模型和提示构建ImageRequest
      var imageRequest = ImageRequest.builder()
         .model(model)
         .prompt(prompt)
         .quality(ImageRequest.Quality.HD)
         .build();

      // 提交ImageRequest并等待图像
      var imageResponse = openAI.images().create(imageRequest).join();

      // 获取图像URL
      String urlString = imageResponse.getFirst().getUrl();
      URL url = URI.create(urlString).toURL();

      // 将图像保存为PNG文件
      try (var inputStream = url.openStream()) {
         Files.copy(inputStream, imagePath,
            StandardCopyOption.REPLACE_EXISTING);
         System.out.printf("图像已写入 %s%n", imagePath);
      }
   }

   // 将视频音轨转换为隐藏字幕
   public static String speechToVTT(String model, Path audioPath) {
      // 构建一个TranscriptionRequest，它返回包含转录片段
      // 及其起止时间的JSON
      var audioRequest = TranscriptionRequest.builder()
         .file(audioPath)
         .model(model)
         .responseFormat(AudioResponseFormat.VERBOSE_JSON)
         .build();

      // 提交TranscriptionRequest并等待转录结果
      Transcription transcription =
         openAI.audios().transcribe(audioRequest).join();

      // 获取转录片段
      List<Transcription.Segment> segments = transcription.getSegments();

      // 创建包含起止时间的
      // 转录片段字符串表示
      String transcriptionText = segments.stream()
         .map(segment -> String.format("起始: %f, 结束: %f, 文本: %s",
            segment.getStart(), segment.getEnd(), segment.getText()))
         .collect(Collectors.joining("\n"));

      // 发起聊天请求将音频片段
      // 转录转换为VTT格式
      var request = ChatRequest.builder()
         .model("gpt-4o")
         .message(ChatMessage.SystemMessage.of("""
            您是字幕格式化助手。请将以下转录
            数据格式化为VTT(WebVTT)格式。
            时间戳必须符合WebVTT要求
            的hh:mm:ss.mmm格式。
            在文件开头包含必需的WEBVTT标头。仅输出VTT内容。"""))
         .message(ChatMessage.UserMessage.of(transcriptionText))
         .build();

      // 发送ChatRequest并获取响应
      var response = openAI.chatCompletions().create(request).join();

      // 移除响应开头和结尾的markdown代码块
      // 分隔符(```)并返回VTT格式字幕
      var captions = response.firstContent();
      return captions.substring(3, captions.length() - 3);
   }

   // 向OpenAI审核API发送文本以检查攻击性内容
   public static Moderation.ModerationResult checkPrompt(String prompt) {
      // 构建ModerationRequest
      var moderationRequest = ModerationRequest.builder()
         .model("omni-moderation-latest") // OpenAI推荐模型
         .input(List.of(prompt))
         .build();

      // 提交请求并返回结果
      var result = openAI.moderations().create(moderationRequest).join();
      return result.getResults().getFirst();
   }
}