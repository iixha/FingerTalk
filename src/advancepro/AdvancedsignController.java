package advancepro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//#FF7B7B for wrong answers
//#D6FFA3 , right
public class AdvancedsignController {
//----------------------

    public AdvancedsignController() throws IOException {
    }

    boolean answer;
    private Stage stage;
    private Scene scene;
    private Parent root;
//------------------------

//media
    private Media WrongAnswer = new Media("https://s27.aconvert.com/convert/p3r68-cdx67/ng043-0hcv8.mp3");
    MediaPlayer wmediaplayer = new MediaPlayer(WrongAnswer);
    private Media WrongAnswer2 = new Media("https://s27.aconvert.com/convert/p3r68-cdx67/ng043-0hcv8.mp3");
    MediaPlayer wmediaplayer2 = new MediaPlayer(WrongAnswer2);
    Media RightAnswer = new Media("https://s27.aconvert.com/convert/p3r68-cdx67/xess0-dcs3m.mp3");
    MediaPlayer rmediaplayer = new MediaPlayer(RightAnswer);
    @FXML
    Label point ;
    
    Game game = new Game();
     Query query ; 
    public void initialize(URL url, ResourceBundle rb) {
      
    }
    //------exit button------
//    @FXML
//    private Button Exitselectlevel;
    
    @FXML
    void ExitselectlevelButtonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //------exit button------
    @FXML
    private Button Exit;

    @FXML
    void ExitButtonClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("selectLevel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //------next letter button-------
    @FXML
    private Button NextLetter;

//--------------letters-----------------------------
    //-----------------------letter n
    @FXML
    private Button btn;
    @FXML
    private TextField tfn;

    @FXML
    void NextLetterNClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterW.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedN(ActionEvent event) {
        String answerN = tfn.getText();
        if (answerN.equalsIgnoreCase("n")) {
            answer = true;
            tfn.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerN.equals("")) {
            tfn.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfn.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter o
    @FXML
    private Button bto;
    @FXML
    private TextField tfo;

    @FXML
    void NextLetterOClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterQ.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedO(ActionEvent event) {
        String answerO = tfo.getText();
        if (answerO.equalsIgnoreCase("o")) {
            answer = true;
            tfo.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerO.equals("")) {
            tfo.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfo.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter p
    @FXML
    private Button btp;
    @FXML
    private TextField tfp;

    @FXML
    void NextLetterPClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("number7.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedP(ActionEvent event) {
        String answerP = tfp.getText();
        if (answerP.equalsIgnoreCase("p")) {
            answer = true;
            tfp.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerP.equals("")) {
            tfp.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfp.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter q
    @FXML
    private Button btq;
    @FXML
    private TextField tfq;

    @FXML
    void NextLetterQClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterT.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedQ(ActionEvent event) {
        String answerQ = tfq.getText();
        if (answerQ.equalsIgnoreCase("q")) {
            answer = true;
            tfq.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answerQ.equals("")) {
            tfq.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfq.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //------------------------letter r
    @FXML
    private Button btr;
    @FXML
    private TextField tfr;

    @FXML
    void NextLetterRClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterX.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedR(ActionEvent event) {
        String answerR = tfr.getText();
        if (answerR.equalsIgnoreCase("r")) {
            answer = true;
            tfr.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerR.equals("")) {
            tfr.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfr.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //------------------------letter s
    @FXML
    private Button bts;
    @FXML
    private TextField tfs;

    @FXML
    void NextLetterSClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterU.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedS(ActionEvent event) {
        String answerS = tfs.getText();
        if (answerS.equalsIgnoreCase("s")) {
            answer = true;
            tfs.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerS.equals("")) {
            tfs.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfs.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter t
    @FXML
    private Button btt;
    @FXML
    private TextField tft;

    @FXML
    void NextLetterTClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterN.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedT(ActionEvent event) {
        String answerT = tft.getText();
        if (answerT.equalsIgnoreCase("t")) {
            answer = true;
            tft.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerT.equals("")) {
            tft.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tft.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter u
    @FXML
    private Button btu;
    @FXML
    private TextField tfu;

    @FXML
    void NextLetterUClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterP.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedU(ActionEvent event) {
        String answerU = tfu.getText();
        if (answerU.equalsIgnoreCase("u")) {
            answer = true;
            tfu.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerU.equals("")) {
            tfu.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfu.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter v
    @FXML
    private Button btnv;
    @FXML
    private TextField tfv;

    @FXML
    void NextLetterVClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterS_1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedV(ActionEvent event) {
        String answerV = tfv.getText();
        if (answerV.equalsIgnoreCase("v")) {
            answer = true;
            tfv.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answerV.equals("")) {
            tfv.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfv.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter w
    @FXML
    private Button btnw;
    @FXML
    private TextField tfw;

    @FXML
    void NextLetterWClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterz.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedW(ActionEvent event) {
        String answerW = tfw.getText();
        if (answerW.equalsIgnoreCase("w")) {
            answer = true;
            tfw.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answerW.equals("")) {
            tfw.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfw.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter x
    @FXML
    private Button btnx;
    @FXML
    private TextField tfx;

    @FXML
    void NextLetterXClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterV.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedX(ActionEvent event) {
        String answerX = tfx.getText();
        if (answerX.equalsIgnoreCase("x")) {
            answer = true;
            tfx.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answerX.equals("")) {
            tfx.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfx.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter y
    @FXML
    private Button btny;
    @FXML
    private TextField tfy;

    @FXML
    void NextLetterYClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterO.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClickedY(ActionEvent event) {
        String answerY = tfy.getText();
        if (answerY.equalsIgnoreCase("y")) {
            answer = true;
            tfy.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answerY.equals("")) {
            tfy.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfy.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //-----------------------letter z
    @FXML
    private TextField tfZ;

    @FXML
    private Button btnz;

    @FXML
    void onEnterClickedZ(ActionEvent event) {
        String answerz = tfZ.getText();
        if (answerz.equalsIgnoreCase("z")) {
            answer = true;
            tfZ.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answerz.equals("")) {
            tfZ.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tfZ.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    @FXML
    void NextLetterZClicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("letterR.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

//number 5------------
    @FXML
    private Button btn5;
    @FXML
    private TextField tf5;

    @FXML
    void NextLetter5Clicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("number6.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClicked5(ActionEvent event) {
        String answer5 = tf5.getText();
        if (answer5.equalsIgnoreCase("5")) {
            answer = true;
            tf5.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answer5.equals("")) {
            tf5.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tf5.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //number 6------------
    @FXML
    private Button btn6;
    @FXML
    private TextField tf6;

    @FXML
    void NextLetter6Clicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("number8.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClicked6(ActionEvent event) {
        String answer6 = tf6.getText();
        if (answer6.equalsIgnoreCase("6")) {
            answer = true;
            tf6.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answer6.equals("")) {
            tf6.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tf6.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //number 7------------
    @FXML
    private Button btn7;
    @FXML
    private TextField tf7;

    @FXML
    void NextLetter7Clicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("number9.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClicked7(ActionEvent event) {
        String answer7 = tf7.getText();
        if (answer7.equalsIgnoreCase("7")) {
            answer = true;
            tf7.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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

        } else if (answer7.equals("")) {
            tf7.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tf7.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //number 8------------
    @FXML
    private Button btn8;
    @FXML
    private TextField tf8;

    @FXML
    void NextLetter8Clicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("endOfAdvanced.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClicked8(ActionEvent event) {
        String answer8 = tf8.getText();
        if (answer8.equalsIgnoreCase("8")) {
            answer = true;
            tf8.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answer8.equals("")) {
            tf8.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tf8.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

    //number 9------------
    @FXML
    private Button btn9;
    @FXML
    private TextField tf9;

    @FXML
    void NextLetter9Clicked(ActionEvent event) throws IOException {
        if (answer) {
            root = FXMLLoader.load(getClass().getResource("number5.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void onEnterClicked9(ActionEvent event) {
        String answer9 = tf9.getText();
        if (answer9.equalsIgnoreCase("9")) {
            answer = true;
            tf9.setStyle("-fx-background-color: #D6FFA3; ");
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
                    game.setPoints(game.getPoints() + 5);
                    game.setGameLevel("Advanced");
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
        } else if (answer9.equals("")) {
            tf9.setStyle("-fx-border-color: #FF7B7B; -fx-border-width: 1px ;");
            answer = false;
            wmediaplayer.play();
        } else {
            tf9.setStyle("-fx-background-color: #FF7B7B; ");
            answer = false;
            wmediaplayer2.play();
        }
    }

}
