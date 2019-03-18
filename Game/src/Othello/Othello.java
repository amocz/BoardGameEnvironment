package Othello;

import GameEnvironment.GameState;

import java.util.ArrayList;

public class Othello {
    private ArrayList<OthelloGameState> gameState;
    public static String PLAYER_1 = "BLACK";
    public static String PLAYER_2 = "WHITE";
    private int width;
    private int height;

    public Othello(int width, int height) {
        gameState = new ArrayList<OthelloGameState>();
        this.width = width;
        this.height = height;
        makeNewGame();
    }

    public void makeNewGame() {
        OthelloGameBoard gb = new OthelloGameBoard(width, height);
        gameState.add(new OthelloGameState(gb));
    }

    public String determineWinner(OthelloGameState gameState) {
        if (gameState.getBlackScore() > gameState.getWhiteScore()) return "BLACK";
        if (gameState.getBlackScore() < gameState.getWhiteScore()) return "WHITE";
        return "TIE";
    }

    public boolean isGameOver() {
        return gameState.get(gameState.size() - 1).isGameOver();
    }

    public static void main(String args[]) {
        Othello game = new Othello(8, 8);
        OthelloGameState currentGameState = game.gameState.get(game.gameState.size() - 1);
        if(!game.isGameOver()) {
            currentGameState.getGameBoard().print();
        }
    }
}

