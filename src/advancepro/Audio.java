package advancepro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Audio implements Initializable{
    private static final String error = "assests/error-2-126514.mp3";
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public static void sound1(){
    //Load the media file
    Media letterSound = new Media(error);
    //create a MediaPlayer to Play the Media
    MediaPlayer mediaPlayer = new MediaPlayer(letterSound);
    // Play the Media
    mediaPlayer.play();
    
    }
   
}
