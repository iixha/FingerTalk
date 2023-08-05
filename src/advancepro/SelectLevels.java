/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancepro;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class SelectLevels implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label point;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Code to execute when the scene is loaded
        //to be able to access same user recoed using "gameID" that match user info
        Login1Controller loginController = new Login1Controller();
        int id = loginController.getId(); //same id for the user whose made the Login
        //retrive student list
        Session session = hibernate.getSessionFactory().openSession();
        List<Game> gList = null;
        ObservableList observableList = FXCollections.observableArrayList();
        String queryStr = "from Game";
        Query query = session.createQuery(queryStr);
        gList = query.list();
        observableList.setAll(gList);
        session.close();
        for (Iterator it = observableList.iterator(); it.hasNext();) {
            Game g = (Game) it.next();
            
            
            if ((g != null) && g.getGameID() == id) {
                point.setText(String.valueOf(g.getPoints()));
                System.out.println(g.getPoints());

            }
        } 
    }

    @FXML
    void onAdvancedClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("letterY.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBeginnerClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Aletter.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ExitselectlevelButtonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
