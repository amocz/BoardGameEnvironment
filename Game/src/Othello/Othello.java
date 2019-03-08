package Othello;

import java.util.ArrayList;


public class Othello {

    private ArrayList<GameState> gameState;
    private int width;
    private int height;

    private Othello(int width, int height) {
        this.width = width;
        this.height = height;
        gameState = new ArrayList<GameState>();
    }

    public void makeNewGame() {
    }

    public String determineWinner() {
        return new String();
    }
}
