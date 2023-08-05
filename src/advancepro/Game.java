
package advancepro;


import java.util.Date;
import javax.persistence.*;



  @Entity
@Table(name="GAME")
public class Game implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "gameID")
    private int gameID;
    
    @Column(name = "gameLevel")
    private String gameLevel;

    @Column(name = "gameDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date gameDate;

    @Column(name = "gameCounts")
    private int gameCounts;

    @Column(name = "Points")
    private int Points;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userEmail" , referencedColumnName = "userEmail")
    private UserB user;

    public UserB getUser() {
        return user;
    }

    public void setUser(UserB user) {
        this.user = user;
    }
    
 
    public Game() {
    }

    public Game(int gameID, String gameLevel, Date gameDate, int gameCounts, int Points, UserB user) {
        this.gameID = gameID;
        this.gameLevel = gameLevel;
        this.gameDate = gameDate;
        this.gameCounts = gameCounts;
        this.Points = Points;
        this.user = user;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(String gameLevel) {
        this.gameLevel = gameLevel;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public int getGameCounts() {
        return gameCounts;
    }

    public void setGameCounts(int gameCounts) {
        this.gameCounts = gameCounts;
    }

    public int getPoints() {
        return Points;
    }

    public void setPoints(int points) {
        this.Points = points;
    }

}
