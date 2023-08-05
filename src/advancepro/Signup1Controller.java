package advancepro;


import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author SIGN
 */
public class Signup1Controller implements Initializable {

    @FXML
    private TextField TextFild_SignUpEmail, TextFild_SignUpName1;
    //********************************//
    @FXML
    private ImageView imgg_Background;
    @FXML
    private Rectangle Rectangle2UP;
    @FXML
    private PasswordField TextFild_SignUpPass;
    //********************************//
    @FXML
    private RadioButton RadioButtonFM, RadioButtonMal;
    @FXML
    private Button SignUpBtn, BackBtn, OkkBtn;

    //********************************//
    //********************************//
    @FXML
    private AnchorPane SignUpalert, anch_Background;  //
    @FXML
    private Label SignUpMsg, Label_SignUpGen, Label_SignUpPass, Label_SignUpEmail, Label_SignUpName, Label_SignUpFinger;//
    @FXML
    //private ToggleGroup Gender;
    private String gender;

    // private RadioButton rb = (RadioButton) Genderr.getSelectedToggle(); 
    UserB user = new UserB();

    /**
     * Initializes the controller class.
     */
    private Media error = new Media("https://s31.aconvert.com/convert/p3r68-cdx67/7pjwf-gduby.mp3");
    MediaPlayer errorSound = new MediaPlayer(error);
   
    @FXML
    private void SignUpPageBtn(ActionEvent event) {

        try {
            //radio buttons
            if (RadioButtonFM.isSelected()) {
                gender = "Female";
            } else if (RadioButtonMal.isSelected()) {
                gender = "male";
            }

            if (TextFild_SignUpName1.getText().isEmpty() && TextFild_SignUpEmail.getText().isEmpty() && TextFild_SignUpPass.getText().isEmpty()) {
                errorSound.play();
                trans("Please Enter your Information!");
                return;
            }
            if (TextFild_SignUpName1.getText().isEmpty()) {
                errorSound.play();
                trans("Please Enter your Name!");
                return;
            }
            if (TextFild_SignUpEmail.getText().isEmpty()) {
                errorSound.play();
                trans("Please Enter your Email!");
                return;
            }
            if (!(TextFild_SignUpEmail.getText().isEmpty()) && !(TextFild_SignUpEmail.getText().contains("@"))) {
                errorSound.play();
                TextFild_SignUpEmail.clear();
                trans("Invalid Email!");
                return;
            }
            if (TextFild_SignUpPass.getText().isEmpty()) {
                errorSound.play();
                trans("Please Enter a password!");
            } else {

                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Scene scen = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scen);
                stage.show();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        user.setUserEmail(TextFild_SignUpEmail.getText());
        user.setUserName(TextFild_SignUpName1.getText());
        user.setUserPassword(TextFild_SignUpPass.getText());
        user.setGender(gender);

        Session session;
        session = hibernate.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
  
        System.out.println("inserted User : " + user.getUserName());

        Game game = new Game();
        Random rand = new Random();
        int max = 30;
        int gameID = rand.nextInt(max);
        game.setGameCounts(game.getGameCounts() + 1);
        Date date = new Date(0);
        game.setGameDate(date);
        game.setPoints(0);
        game.setGameLevel(" ");
        game.setUser(user);

        
        session.save(user);
        session.save(game); 
        tx.commit();
        session.close();

    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartP1.fxml"));
        Scene MySignInPage = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(MySignInPage);
        stage.show();
    }

    private void trans(String m) {
        SignUpMsg.setText(m);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(SignUpalert);
        slide.setToX(0);
        slide.play();
    }

    @FXML
    private void okBtn(ActionEvent event) {
        SignUpalert.setTranslateX(-500);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SignUpalert.setTranslateX(-500);

    }
}
