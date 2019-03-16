package tictactoe;
import GameEnvironment.Element;

public class TicTacToeElement extends Element{
	private String piecename;
	
	public TicTacToeElement(String piecename) {
		this.piecename = piecename;
	}
	
	public String getName() {
		return piecename;
	}
	
	public String setName(String B) {
		return piecename = B; 
	}
}
