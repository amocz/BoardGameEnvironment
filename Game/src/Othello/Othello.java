package Othello;
import GameEnvironment.Game;

import java.util.ArrayList;

public class Othello {
    private ArrayList<OthelloGameState> gameState;
    private int width;
    private int height;

    public Othello(int width, int height) {
        gameState = new ArrayList<OthelloGameState>();
        this.width = width;
        this.height = height;
    }

    public void makeNewGame() {
        gameState.add(new OthelloGameState(new GameBoard(width, height)));
    }

    public String determineWinner(OthelloGameState gameState) {
        if (gameState.getBlackScore() > gameState.getWhiteScore()) return "BLACK";
        if (gameState.getBlackScore() < gameState.getWhiteScore()) return "WHITE";
    	return "TIE";
    }
}
