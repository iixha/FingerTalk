package advancepro;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class FXMLDocumentController implements Initializable {

    private Stage stage;
    private Scene scene;
    Pane pane = new Pane();

    @FXML
    private Label ChooseNum_Label, UserSelection_Label;

    @FXML
    private ImageView Num_Background, Numbers_img;

    @FXML
    private RadioButton Zero_Btn, One_Btn, Two_Btn, Three_Btn, Four_Btn, Five_Btn, Six_Btn, Seven_Btn, Eight_Btn, Nine_Btn;

    @FXML
    private Button BackBtn;

    @FXML
    private Button Exit;

     
    @FXML
    private AnchorPane NumAnch;

    private Media AudioMedia = new Media("https://e.top4top.io/m_2699t5rgf1.mp3");
    MediaPlayer Audioplayer = new MediaPlayer(AudioMedia);
    
    @FXML
    public void backgrundVoice(MouseEvent event) {
             Audioplayer.play();
        }
     
       
    @FXML
    public void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    public void BACKHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Pane pane = new Pane();
        pane.getChildren().addAll(root);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Learn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectLearn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        pane.getChildren().addAll(root);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // زر الرجوع لصفحة الاختيار بين تعلم الحروف او الارقام 
    @FXML
    public void BACKSelect(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectLearn.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane.getChildren().addAll(root);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // تعلم الحروف 
    @FXML
    public void Letter(ActionEvent event) throws IOException {

        ListView<String> listLetter = new ListView();
        listLetter.setLayoutX(130);
        listLetter.setLayoutY(143);
        listLetter.setPrefSize(107, 140);
        listLetter.setStyle("-fx-background-color :#FFD778; -fx-background-radius : 5; -fx-background-size : 50; ");

        ObservableList<String> Letter = FXCollections.observableArrayList("Aa", "Bb", "Cc", "Dd", "Ee", "Ff", "Gg", "Hh", "Ii", "Jj", "Kk", "Ll", "Mm", "Nn", "Oo", "Pp", "Qq", "Rr", "Ss", "Tt", "Uu", "Vv", "Ww", "Xx", "Yy", "Zz");
        listLetter.getItems().addAll(Letter);
        ImageView imageView = new ImageView();
        imageView.setLayoutX(278);
        imageView.setLayoutY(59);
        imageView.setFitHeight(270);
        imageView.setFitWidth(363);

        Parent root = FXMLLoader.load(getClass().getResource("Letters.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        Pane pane = new Pane();
        pane.getChildren().addAll(root, listLetter, imageView);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        listLetter.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("Aa")) {
                Image image1 = new Image("https://e.top4top.io/p_2694dksud1.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);
            } else if (newValue.equals("Bb")) {
                Image image1 = new Image("https://a.top4top.io/p_2694qqy881.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Cc")) {
                Image image1 = new Image("https://g.top4top.io/p_2694azwzr1.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Dd")) {
                Image image1 = new Image("https://k.top4top.io/p_2694v89wu1.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Ee")) {
                Image image1 = new Image("https://l.top4top.io/p_269450nja2.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Ff")) {
                Image image1 = new Image("https://a.top4top.io/p_26944b6gv1.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Gg")) {
                Image image1 = new Image("https://b.top4top.io/p_2694zgdmj2.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);
            } else if (newValue.equals("Hh")) {
                Image image1 = new Image("https://c.top4top.io/p_2694i7sdu3.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Ii")) {
                Image image1 = new Image("https://d.top4top.io/p_26941jo284.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Jj")) {
                Image image1 = new Image("https://e.top4top.io/p_2694mcgk55.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Kk")) {
                Image image1 = new Image("https://f.top4top.io/p_2694tlkq96.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Ll")) {
                Image image1 = new Image("https://g.top4top.io/p_2694khbrt7.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Mm")) {
                Image image1 = new Image("https://g.top4top.io/p_2694werw01.png");
                imageView.setImage(image1);

            } else if (newValue.equals("Nn")) {
                Image image1 = new Image("https://h.top4top.io/p_26948zfud2.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Oo")) {
                Image image1 = new Image("https://i.top4top.io/p_2694togr23.png");
                imageView.setImage(image1);

                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Pp")) {
                Image image1 = new Image("https://j.top4top.io/p_2694zpl5p4.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Qq")) {
                Image image1 = new Image("https://k.top4top.io/p_2694gb4tu5.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Rr")) {
                Image image1 = new Image("https://l.top4top.io/p_2694kfeoq6.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Ss")) {
                Image image1 = new Image("https://a.top4top.io/p_2694lkigp7.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Tt")) {
                Image image1 = new Image("https://b.top4top.io/p_2694kmb808.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Uu")) {
                Image image1 = new Image("https://a.top4top.io/p_2694eds331.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Vv")) {
                Image image1 = new Image("https://b.top4top.io/p_2694lz27x2.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Ww")) {
                Image image1 = new Image("https://c.top4top.io/p_2694rrym83.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Xx")) {
                Image image1 = new Image("https://d.top4top.io/p_2694is6hu4.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Yy")) {
                Image image1 = new Image("https://e.top4top.io/p_26946veri5.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);

            } else if (newValue.equals("Zz")) {
                Image image1 = new Image("https://f.top4top.io/p_2694wd76r6.png");
                imageView.setImage(image1);
                pane.getChildren().setAll(root, listLetter, imageView);
            }
        });
    }

    @FXML
    public void Number(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("learningNum.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        pane.getChildren().addAll(root);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void getChoose(ActionEvent event) {

        try {

            if (Zero_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_0.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Zero_Btn.textProperty());
            }
            if (One_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_1.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(One_Btn.textProperty());
            }
            if (Two_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_2.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Two_Btn.textProperty());
            }

            if (Three_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_3.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Three_Btn.textProperty());
            }
            if (Four_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_4.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Four_Btn.textProperty());
            }

            if (Five_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_5.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Five_Btn.textProperty());
            }
            if (Six_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_6.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Six_Btn.textProperty());
            }

            if (Seven_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_7.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Seven_Btn.textProperty());
            }
            if (Eight_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_8.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Eight_Btn.textProperty());
            }

            if (Nine_Btn.isSelected()) {
                Image pic1 = new Image("assests/Number_9.jpg");
                Numbers_img.setImage(pic1);
                UserSelection_Label.textProperty().bind(Nine_Btn.textProperty());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void GameInfo(ActionEvent event) throws IOException {
//              هنا نحط صفحة الهيلب  
        FXMLLoader loader = new FXMLLoader(getClass().getResource("helpAndSupport.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    // صفحة الاختبارات 
    public void TeatYourself(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("selectLevel.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ExitButtonClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // mute 
    @FXML
    public void voice(MouseEvent e) {
           if (e.getButton().equals(MouseButton.PRIMARY) && e.getClickCount() == 1) {
               Audioplayer.pause();
           }
        }
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }
    }


