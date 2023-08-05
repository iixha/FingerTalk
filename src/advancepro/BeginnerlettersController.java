
package advancepro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author blue sugar
 */
public class BeginnerlettersController implements Initializable {

    @FXML
    private Label NoteLabel;
    @FXML
    private Button RightLetter;
    @FXML
    private Button WrongLetter1;
    @FXML
    private Button WrongLetter2;
    @FXML
    private Button RightNum;
    @FXML
    private Button WrongNum1;
    @FXML
    private Button WrongNum2;
    @FXML
    private Button NextLevel;
    @FXML
    private Button Exit;
    @FXML
    private ImageView welcome;

    boolean answer;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ////////Audio//////////
    private Media WrongAnswer = new Media("https://c.top4top.io/m_2700azbbd1.mp3");
    MediaPlayer wmediaplayer = new MediaPlayer(WrongAnswer);

    private Media WrongAnswer2 = new Media("https://c.top4top.io/m_2700azbbd1.mp3");
    MediaPlayer wmediaplayer2 = new MediaPlayer(WrongAnswer2);

    private Media RightAnswer = new Media("https://g.top4top.io/m_2700ssnx91.mp3");
    MediaPlayer rmediaplayer = new MediaPlayer(RightAnswer);

    private Media AudioMedia2 = new Media("https://e.top4top.io/m_2699t5rgf1.mp3");
    MediaPlayer Audioplayer2 = new MediaPlayer(AudioMedia2);

    private final Media AudioMedia = new Media("https://e.top4top.io/m_2699t5rgf1.mp3");
    MediaPlayer Audioplayer = new MediaPlayer(AudioMedia);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    Game game = new Game();

    //------------------Beginner level----------------------------------
    @FXML
    private void ExitButtonClicked(MouseEvent event) throws IOException {
        Audioplayer.pause();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("selectLevel.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /* AdvancedsignController Advance = new AdvancedsignController();
         Advance.ExitButtonClicked(event);*/
    }

    @FXML
    private void RightLetterClicked(ActionEvent event) throws IOException {
        answer = true;
        RightLetter.setStyle("-fx-background-color: #D6FFA3; ");//Right
        NoteLabel.setText("Great job !!");
        rmediaplayer.play();
        
        //to be able to access same user recoed using "gameID" that match user info
        Login1Controller loginController = new Login1Controller();
        
        Session session = hibernate.getSessionFactory().openSession();
        Transaction tx = null;
         int id = loginController.getId(); //same id for the user whose made the Login
        try {
            tx = session.beginTransaction();
            Game game = (Game) session.get(Game.class, id);
            if (game != null) {
                game.setPoints(game.getPoints() + 1);
                game.setGameLevel("Beginner");
                session.save(game);
                tx.commit();
                System.out.println("Game updated successfully");
            } else {
                System.out.println("Game with Id" + id + "does not exist");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    private void WrongLetter1Clicked(ActionEvent event) {
        answer = false;
        WrongLetter1.setStyle("-fx-background-color: #FF7B7B; ");//Wrong
        NoteLabel.setText("Try Again..");
        wmediaplayer.play();
    }

    @FXML
    private void WrongLetter2Clicked(ActionEvent event) {
        answer = false;
        WrongLetter2.setStyle("-fx-background-color: #FF7B7B; ");//Wrong
        NoteLabel.setText("Try Again..");
        wmediaplayer2.play();
    }

    @FXML
    private void RightNumClicked(ActionEvent event) {
        answer = true;
        RightNum.setStyle("-fx-background-color: #D6FFA3; ");//Right
        NoteLabel.setText("Great job !!");
        rmediaplayer.play();
        
        //to be able to access same user recoed using "gameID" that match user info
        Login1Controller loginController = new Login1Controller();
        
        Session session = hibernate.getSessionFactory().openSession();
        Transaction tx = null;
         int id = loginController.getId(); //same id for the user whose made the Login
        try {
            tx = session.beginTransaction();
            Game game = (Game) session.get(Game.class, id);
            if (game != null) {
                game.setPoints(game.getPoints() + 1);
                game.setGameLevel("Beginner");
                session.save(game);
                tx.commit();
                System.out.println("Game updated successfully");
            } else {
                System.out.println("Game with Id" + id + "does not exist");
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    private void WrongNum1Clicked(ActionEvent event) {
        answer = false;
        WrongNum1.setStyle("-fx-background-color: #FF7B7B; ");//Wrong
        NoteLabel.setText("Try Again..");
        MediaPlayer mediaplayer = new MediaPlayer(WrongAnswer);
        wmediaplayer.play();
    }

    @FXML
    private void WrongNum2Clicked(ActionEvent event) {
        answer = false;
        WrongNum2.setStyle("-fx-background-color: #FF7B7B; ");//Wrong
        NoteLabel.setText("Try Again..");
        MediaPlayer mediaplayer = new MediaPlayer(WrongAnswer);
        wmediaplayer2.play();
    }

    @FXML
    private void NextLetterAClicked(MouseEvent event) throws IOException {
        MediaPlayer Audioplayer = new MediaPlayer(AudioMedia);
        if (answer) {//for check if the right button is clicked the he can move to next
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Kletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterBClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Eletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterCClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Jletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterDClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterEClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Hletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterFClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("iletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterGClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("onum.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterHClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Mletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterIClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Bletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterJClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterKClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Fletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterLClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Gletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLetterMClicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Cletter.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextNumber0Clicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fnum.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextNumber1Clicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("thnum.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextNumber2Clicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("completeblvl.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextNumber3Clicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("znum.fxml"));
            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextNumber4Clicked(MouseEvent event) throws IOException {
        if (answer) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("tnum.fxml"));
            root = loader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        } else {
            NoteLabel.setText("Choose right\nanswer first!");
        }
    }

    @FXML
    private void NextLevelClicked(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("letterY.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
