package advancepro;



import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Noha
 */
public class LearningNumController {
	@FXML
	private Label ChooseNum_Label, UserSelection_Label;
	
        @FXML
        private ImageView Num_Background, Numbers_img;
        
        @FXML
	private RadioButton Zero_Btn, One_Btn, Two_Btn, Three_Btn, Four_Btn, Five_Btn, Six_Btn, Seven_Btn, Eight_Btn, Nine_Btn;
	
        @FXML
	private Button BackBtn;
                
        @FXML
        private AnchorPane NumAnch;
             
	public void getChoose(ActionEvent event) {
            
            try {
		
		if(Zero_Btn.isSelected()) {
                    Image pic1 = new Image("img/Number_0.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Zero_Btn.textProperty());
		}
		if(One_Btn.isSelected()) {
                    Image pic1 = new Image("img/Number_1.jpg");
                     Numbers_img.setImage(pic1);
		    UserSelection_Label.textProperty().bind(One_Btn.textProperty());
		}
		if(Two_Btn.isSelected()) {
                    Image pic1 = new Image("img/Number_2.jpg");
                     Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Two_Btn.textProperty());
		}
                
		if(Three_Btn.isSelected()) {
                    Image pic1 = new Image("img/Number_3.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Three_Btn.textProperty());
		}
		if(Four_Btn.isSelected()) {
		    Image pic1 = new Image("img/Number_4.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Four_Btn.textProperty());
		}
                
		if(Five_Btn.isSelected()) {
		    Image pic1 = new Image("img/Number_5.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Five_Btn.textProperty());
		}
		if(Six_Btn.isSelected()) {
                    Image pic1 = new Image("img/Number_6.jpg");
                    Numbers_img.setImage(pic1);
	   	    UserSelection_Label.textProperty().bind(Six_Btn.textProperty());
		}
                
		if(Seven_Btn.isSelected()) {
		    Image pic1 = new Image("img/Number_7.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Seven_Btn.textProperty());
		}
		if(Eight_Btn.isSelected()) {
		    Image pic1 = new Image("img/Number_8.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Eight_Btn.textProperty());
		}
                
		if(Nine_Btn.isSelected()) {
		    Image pic1 = new Image("img/Number_9.jpg");
                    Numbers_img.setImage(pic1);
                    UserSelection_Label.textProperty().bind(Nine_Btn.textProperty());
		}
	} catch (Exception e) {
            System.out.println(e.toString());
            }     
     }
        @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("StartP1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        NumAnch.setTranslateX(-500);
        
    }

}
   

