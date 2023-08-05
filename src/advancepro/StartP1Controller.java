package advancepro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Startp1
 */
public class StartP1Controller implements Initializable {

    @FXML
    private Button SignUpBtn, LogInBtn;
    
      private final Media AudioMedia = new Media("https://e.top4top.io/m_2699t5rgf1.mp3");
           MediaPlayer Audioplayer = new MediaPlayer(AudioMedia);


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    //---------------------------------
    //---------------------------------
    boolean rightPressed = false;
    boolean enterPressed = false;
    boolean leftPressed = false;
     Parent root;
    
    @FXML
    private void startGame(MouseEvent event) throws IOException { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartP1.fxml")); 
         root = loader.load(); 
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        Scene scene = new Scene(root); 
        stage.setScene(scene); 
        stage.show(); 
    }

    @FXML
    private void LeftLogin(KeyEvent event) throws IOException {
              Audioplayer.pause();
        if (event.getCode() == KeyCode.LEFT) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login1.fxml"));
             root = loader.load();
      
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
       
    }

     @FXML
    private void RightSignup(KeyEvent event) throws IOException {
                Audioplayer.pause();
        if (event.getCode() == KeyCode.RIGHT) {// نتأكد انو انضغط على سهم اليمين
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup1.fxml"));
             root = loader.load();
     
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
      @FXML
    public void voice1(MouseEvent e) {
           if (e.getButton().equals(MouseButton.PRIMARY) && e.getClickCount() == 1) {
               Audioplayer.pause();
           }
            }
    
      @FXML
    public void backgrundVoices(MouseEvent event) {
             Audioplayer.play();
         }

}
