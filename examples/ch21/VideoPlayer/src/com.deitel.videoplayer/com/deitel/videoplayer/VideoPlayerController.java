// VideoPlayerController.java
// 使用Media、MediaPlayer和MediaView来播放视频
package com.deitel.videoplayer;

import java.net.URL;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import org.controlsfx.dialog.ExceptionDialog;

public class VideoPlayerController {  
   @FXML private MediaView mediaView;
   @FXML private Button playPauseButton;
   private MediaPlayer mediaPlayer;
   private boolean playing = false;
      
   public void initialize() {
      // 获取视频文件的URL
      URL url = VideoPlayerController.class.getResource("/res/Shenzhou-15_Launch_1min_Recap.mp4");
      
      // create a Media object for the specified URL
      Media media = new Media(url.toExternalForm());
      
      // create a MediaPlayer to control Media playback
      mediaPlayer = new MediaPlayer(media);
      
      // specify which MediaPlayer to display in the MediaView
      mediaView.setMediaPlayer(mediaPlayer); 

      // set handler to be called when the video completes playing
      mediaPlayer.setOnEndOfMedia(
         new Runnable() {
            public void run() {
               playing = false;
               playPauseButton.setText("播放");
               mediaPlayer.seek(Duration.ZERO);
               mediaPlayer.pause();
            }
         }
      );
 
      // set handler that displays an ExceptionDialog if an error occurs
      mediaPlayer.setOnError(
         new Runnable() {
            public void run() {
               ExceptionDialog dialog = 
                  new ExceptionDialog(mediaPlayer.getError());
               dialog.showAndWait();
            }
         }
      );
      
      // set handler that resizes window to video size once ready to play
      mediaPlayer.setOnReady(
         new Runnable() {
            public void run() {
               DoubleProperty width = mediaView.fitWidthProperty();
               DoubleProperty height = mediaView.fitHeightProperty();
               width.bind(Bindings.selectDouble(
                  mediaView.sceneProperty(), "width"));
               height.bind(Bindings.selectDouble(
                  mediaView.sceneProperty(), "height")); 
            }
         }
      );
   }  
   
   // toggle media playback and the text on the playPauseButton
   @FXML
   private void playPauseButtonPressed(ActionEvent e) {
      playing = !playing;

      if (playing) {
         playPauseButton.setText("暂停");
         mediaPlayer.play();
      }
      else {
         playPauseButton.setText("播放");
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
