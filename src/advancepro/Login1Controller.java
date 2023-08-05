package advancepro;

//
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author ....
 */
public class Login1Controller implements Initializable {

    @FXML
    private TextField LoginName22;

    @FXML
    private TextField LoginPass22;

    @FXML
    private AnchorPane SignInalert;//تبع شباك الايرور
    @FXML
    private Label SignInmsg;//تبع مسج الايرور
    
    @FXML
    private Label playerNamelbl1;
    
    private UserB info;
    private Game infoo;
    private static int id;
    private static int point;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SignInalert.setTranslateX(-500);
    }

    private Media error = new Media("https://s31.aconvert.com/convert/p3r68-cdx67/7pjwf-gduby.mp3");
    MediaPlayer errorSound = new MediaPlayer(error);
    
    
        @FXML
    private void onNameTyped(KeyEvent event) throws IOException {
        //create name binding
        playerNamelbl1.textProperty().bind(LoginName22.textProperty());
    }
    
    @FXML
    private void LoginPageBtn(ActionEvent event) {

        try {
            Session session1 = hibernate.getSessionFactory().openSession();
            Transaction too = session1.beginTransaction();
            Query query = session1.createQuery("from UserB");
            List<UserB> UsList = query.list();
            System.out.println("The connection is succeeded");
            too.commit();
            session1.close();
           
            if (LoginName22.getText().isEmpty() && LoginPass22.getText().isEmpty()) {
                errorSound.play();
                trans("Please enter your information!");
                return;
            }
            if (LoginName22.getText().isEmpty() && !LoginPass22.getText().isEmpty()) {
                errorSound.play();
                trans("Please enter your Name!");
                return;
            }
            if (LoginPass22.getText().isEmpty() && !LoginName22.getText().isEmpty()) {
                trans("Please enter your password!");
                errorSound.play();
                return;
            }
            for (UserB i : UsList) {
                info = i;
                if ((i != null) && i.getUserName().equals(LoginName22.getText())) {
                    if (i.getUserPassword().equals(LoginPass22.getText())) {
                        //continue to home page
                        String email = i.getUserEmail();
                        //
                        Session session2 = hibernate.getSessionFactory().openSession();
                        Transaction tooo = session2.beginTransaction();
                        Query query2 = session2.createQuery("from Game g join fetch g.user where g.user.userEmail = :email");
                        query2.setParameter("email", email);
                        List<Game> gmList = query2.list();
                       ObservableList observableList = FXCollections.observableArrayList();
                        System.out.println("The connection is succeeded");
                         observableList.setAll(gmList);
                        tooo.commit();
                        session2.close();
                        /*"from Game g join fetch g.user where g.user.userEmail = :email"
                         uses the named parameter "email" to filter the results to only those Game entities that are associated with the User entity having the specified email address. */
                        ///////--Session--/////////
                      for (Iterator it = observableList.iterator(); it.hasNext();) {
                           Game n = (Game) it.next();
                            infoo = n;
                            if ((n != null) && n.getUser().getUserEmail().equals(email)) {
                                
                                id = n.getGameID();
                                point = n.getPoints();
                                
                                
                                Session session = hibernate.getSessionFactory().openSession();
                                Transaction tx = session.beginTransaction();
                                Game game = (Game) session.get(Game.class, id);
                                Hibernate.initialize(game.getUser());
                                game.setGameCounts(game.getGameCounts() + 1);
                                Date date = new Date();
                                game.setGameDate(date);
                                session.save(game);
                                tx.commit();
                                session.close();
                                /////--Session--///////////
                                Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                                Scene scen = new Scene(root);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(scen);
                                stage.show();
                            }
                        }
                    } else {
                        errorSound.play();
                        trans("The password is incorrect! please make sure to enter the correct password");
                        return;
                    }
                }
            }
            if (!info.getUserName().equals(LoginName22.getText())) {
                trans("There's no account with this User Name, please register!");
                return;
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

    }

    private void trans(String m) {
        SignInmsg.setText(m);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(SignInalert);
        slide.setToX(0);
        slide.play();
    }

    @FXML
    private void SignInOkBtn(ActionEvent event) throws IOException {
        SignInalert.setTranslateX(-500);
    }
    
    public int getId() {
        return id;
    }
    
     public int getpoint() {
        return point;
    }
}
