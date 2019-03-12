package Othello;
import java.util.ArrayList;

public class Othello {

    private ArrayList<GameState> gameState;
    private int width;
    private int height;

    public Othello(int width, int height) {
        gameState = new ArrayList<GameState>();
        this.width = width;
        this.height = height;
    }

    public void makeNewGame() {
        gameState.add(new GameState(new GameBoard(width, height)));
    }

    public String determineWinner(GameState gameState) {
        if (gameState.getBlackScore() > gameState.getWhiteScore()) return "BLACK";
        if (gameState.getBlackScore() < gameState.getWhiteScore()) return "WHITE";
    	return "TIE";
    }
}
