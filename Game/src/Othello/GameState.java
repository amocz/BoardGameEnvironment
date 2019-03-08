package Othello;

public class GameState {

    private GameBoard gameBoard;
    private int blackScore, whiteScore;
    private boolean gameOver;
    private String turn;
    private String winner;

    private GameState(GameBoard gameBoard, int blackScore, int whiteScore, boolean gameOver, String turn, String winner){
        this.gameBoard = gameBoard;
        this.blackScore = blackScore;
        this.whiteScore = whiteScore;
        this.gameOver = gameOver;
        this.turn = turn;
        this.winner = winner;
    }

    // getGameBoard() returns a reference to a constant OthelloBoard describing
    // what's on the board in this game state.
    public GameBoard getGameBoard(){
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
    public boolean isGameOver() { //IMPLEMENT
        return false
    }

    // isBlackTurn() returns true if it is currently the black player's
    // turn in this game state, false otherwise.
    public boolean isBlackTurn() {
        if(turn == "BLACK") {
            return true;
        }
        else {
            return false;
        }

    }

    // isWhiteTurn() returns true if it is currently the white player's
    // turn in this game state, false otherwise.
    public boolean isWhiteTurn() {
        if(turn == "WHITE") {
            return true;
        }
        else {
            return false;
        }
    }

    // isValidMove() returns true if the current player whose turn it is
    // can make a valid move at cell (x, y).
    public boolean isValidMove(int x, int y){ //IMPLEMENT
        return false;
    }

    // makeMove() modifies this game state by making a move on behalf of
    // the current player at cell (x, y).
    public void makeMove(int x, int y){ //IMPLEMENT
        if(isValidMove(x,y)){

        }
    }
}
