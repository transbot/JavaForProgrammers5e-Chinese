// 图17.8: VideoPlayerController.java
// 使用Media、MediaPlayer和MediaView来播放视频
import java.net.URL;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;             
import javafx.scene.media.MediaPlayer;       
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;         
import javafx.util.Duration;                 
import org.controlsfx.dialog.ExceptionDialog;

public class VideoPlayerController {
   @FXML private MediaView mediaView;
   @FXML private Button playPauseButton;
   private MediaPlayer mediaPlayer;
      
   @FXML
   private void initialize() {
      // 获取视频文件的URL
      URL url = VideoPlayerController.class.getResource(
         "Shenzhou-15_Launch_1min_Recap.mp4");
      
      // 为指定URL创建Media对象
      var media = new Media(url.toExternalForm());
      
      // 创建MediaPlayer来控制媒体播放
      mediaPlayer = new MediaPlayer(media);
      
      // 指定在MediaView中显示的MediaPlayer
      mediaView.setMediaPlayer(mediaPlayer);

      // 设置视频播放结束时的处理程序
      mediaPlayer.setOnEndOfMedia(() -> {
         mediaPlayer.seek(Duration.ZERO);
         mediaPlayer.pause();            
      });
 
      // 设置错误处理程序：出现错误时显示异常对话框
      mediaPlayer.setOnError(() -> {
         var dialog = new ExceptionDialog(mediaPlayer.getError());
         dialog.showAndWait();                          
      });
      
      // 设置准备就绪处理程序：调整mediaView大小以适应窗口
      mediaPlayer.setOnReady(() -> {
         DoubleProperty width = mediaView.fitWidthProperty();  
         DoubleProperty height = mediaView.fitHeightProperty();
         width.bind(Bindings.selectDouble(                     
            mediaView.sceneProperty(), "width"));              
         height.bind(Bindings.selectDouble(                    
            mediaView.sceneProperty(), "height"));             
      });

      // 将播放/暂停按钮文本绑定到MediaPlayer状态
      playPauseButton.textProperty().bind(Bindings.when(
         mediaPlayer.statusProperty().isEqualTo(Status.PLAYING))
                    .then("暂停")
                    .otherwise("播放")
      );
   }  
   
   // 切换媒体播放状态并更新播放/暂停按钮文本
   @FXML
   private void playPauseButtonPressed(ActionEvent e) {
      Status status = mediaPlayer.getStatus();

      if (status == Status.READY || status == Status.PAUSED) {
         mediaPlayer.play();
      }
      else {         
         mediaPlayer.pause();
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
