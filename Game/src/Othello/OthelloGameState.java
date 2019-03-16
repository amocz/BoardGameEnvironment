package Othello;
import GameEnvironment.GameState;

import java.util.ArrayList;

public class OthelloGameState extends GameState {

    private OthelloGameBoard gameBoard;
    private int blackScore, whiteScore;
    private boolean gameOver;
    private String playerTurn;

    public OthelloGameState(OthelloGameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.blackScore = 0;
        this.whiteScore = 0;
        this.gameOver = false;
        this.playerTurn = Othello.PLAYER_1;
    }

    // getGameBoard() returns a reference to a constant OthelloBoard describing
    // what's on the board in this game state.
    public OthelloGameBoard getGameBoard() {
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

    // isGameOver() returns true if the game is over in this game state,
    // false otherwise.
    public boolean isGameOver() { //IMPLEMENT
        return gameOver;
    }

    // isBlackTurn() returns true if it is currently the black player's
    // turn in this game state, false otherwise.
    public boolean isBlackTurn() {
        if(playerTurn == Othello.PLAYER_2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // isWhiteTurn() returns true if it is currently the white player's
    // turn in this game state, false otherwise.
    public boolean isWhiteTurn() {
        if(playerTurn == Othello.PLAYER_1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // isValidMove() returns true if the current player whose turn it is
    // can make a valid move at cell (x, y).
    public boolean isValidMove(int x, int y) { //IMPLEMENT














        return false;
    } //IMPLEMENT

    // makeMove() modifies this game state by making a move on behalf of
    // the current player at cell (x, y).
    public void makeMove(int x, int y) { //IMPLEMENT
















    }
    
    // checkGameOver() modifies and sets gameOver attribute to true if
    // the game is over in this game state, false otherwise.
    public void checkGameOver(int x, int y) { //IMPLEMENT
        for (ArrayList<OthelloCell> col : getGameBoard().getBoard()) {
            for (OthelloCell othelloCell : col)
                if (othelloCell.isEmpty()) {
                    gameOver = false;
                }
            gameOver = true;
        }
    }
}
