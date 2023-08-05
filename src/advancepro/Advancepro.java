
package advancepro;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author blue sugar
 */
public class Advancepro extends Application {

    
    private final Media AudioMedia = new Media("https://e.top4top.io/m_2699t5rgf1.mp3");
    MediaPlayer Audioplayer = new MediaPlayer(AudioMedia);
    FXMLDocumentController f =new FXMLDocumentController();
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
  
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.getModality();
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
