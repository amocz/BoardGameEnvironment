package Memory;
import java.util.List;

import GameEnvironment.Game;
import GameEnvironment.GameState;
import GameEnvironment.Player;

public class MemoryGame extends Game {
    private static String name = "Memory";
    private List<Player> players;
    private GameState gamestate;
    
    public MemoryGame(List<Player> players) {
        super(name, players);
        this.players = players;
        gamestate = new MemoryGameState();
    }
    
    public void initialize() {
        this.gamestate.setPlayerTurn(this.players.get(0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }
}
