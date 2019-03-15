package GameEnvironment;

import java.util.List;

public abstract class Game {

	private String name;
	private List<Player> players;
	
	public Game(String name, List<Player> players){
		this.name = name;
		this.players = players;
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
    
}