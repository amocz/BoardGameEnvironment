package tictactoe;
import GameEnvironment.Element;

public class TicTacToeElement extends Element{
	private String piecename1 = "X";
	private String piecename2 = "O";
	
	public TicTacToeElement() {
		
	}
	
	public TicTacToeElement(String A, String B) {
		piecename1 = A;
		piecename2 = B;
	}
	
	public String getName1() {
		return piecename1;
	}
	
	public String getName2() {
		return piecename2;
	}
	
	public String setName1(String A) {
		return piecename1 = A;
	}
	
	public String setName2(String B) {
		return piecename2 = B; 
	}
}
