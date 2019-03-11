import java.util.ArrayList;
import java.util.List;

public class GUI {
    private List<Game> games;
    
    public GUI() {
        this.games = new ArrayList<Game>();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
