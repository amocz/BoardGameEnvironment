package Othello;
import java.util.ArrayList;

public class GameState {

    private GameBoard gameBoard;
    private int blackScore, whiteScore;
    private boolean gameOver;
    private String turn;
    private String winner;

    public GameState(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.blackScore = 0;
        this.whiteScore = 0;
        this.gameOver = false;
        this.turn = "WHITE";
        this.winner = null;
    }

    // getGameBoard() returns a reference to a constant OthelloBoard describing
    // what's on the board in this game state.
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    // getBlackScore() returns the black player's current score.
    public int getBlackScore() {
        return blackScore;
    }

    // getWhiteScore() returns the white player's current score.
    public int getWhiteScore() {
       return whiteScore;
    }

    // getWinner() returns the winner
    public String getWinner() {
        return winner;
    }

    // isGameOver() returns true if the game is over in this game state,
    // false otherwise.
    public boolean isGameOver() {
        return gameOver;
    }

    // isBlackTurn() returns true if it is currently the black player's
    // turn in this game state, false otherwise.
    public boolean isBlackTurn() {
        return turn.equals("BLACK");
    }

    // isWhiteTurn() returns true if it is currently the white player's
    // turn in this game state, false otherwise.
    public boolean isWhiteTurn() {
    	return turn.equals("WHITE");
    }

    // isValidMove() returns true if the current player whose turn it is
    // can make a valid move at cell (x, y).
    public boolean isValidMove(int x, int y) { //IMPLEMENT
        return false;
    }

    // makeMove() modifies this game state by making a move on behalf of
    // the current player at cell (x, y).
    public void makeMove(int x, int y) { //IMPLEMENT
        if (isValidMove(x,y)) {

        }
    }
    
    // checkGameOver() modifies and sets gameOver attribute to true if
    // the game is over in this game state, false otherwise.
    public void checkGameOver(int x, int y) { //IMPLEMENT
    	for (ArrayList<Cell> col : getGameBoard().getBoard()) {
        	for (Cell cell : col)
        		if (cell.isEmpty()) return;
        }
    	gameOver = true;
    }
}
