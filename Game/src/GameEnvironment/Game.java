package GameEnvironment;

import java.util.List;

public class Game {

	private String name;
	private List<Player> players;
	private Grid grid;
	
	Game(String name, List<Player> players, Grid grid){
		this.name = name;
		this.players = players;
		this.grid = grid;
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
    
    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}