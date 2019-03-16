package Othello;

import java.util.ArrayList;

public class Othello {
    private ArrayList<OthelloGameState> gameState;
    public static String PLAYER_1;
    public static String PLAYER_2;
    private int width;
    private int height;

    public Othello(int width, int height) {
        gameState = new ArrayList<OthelloGameState>();
        this.width = width;
        this.height = height;
    }

    public void makeNewGame() {

        gameState.add(new OthelloGameState(new OthelloGameBoard(width, height)));
    }

    public String determineWinner(OthelloGameState gameState) {
        if (gameState.getBlackScore() > gameState.getWhiteScore()) return "BLACK";
        if (gameState.getBlackScore() < gameState.getWhiteScore()) return "WHITE";
    	return "TIE";
    }
}
