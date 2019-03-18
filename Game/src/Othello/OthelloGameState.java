package Othello;
import GameEnvironment.GameState;

import java.util.ArrayList;

public class OthelloGameState {

    private OthelloGameBoard gameBoard;
    private int blackScore, whiteScore;
    private boolean gameOver;
    private String playerTurn;

    public OthelloGameState(OthelloGameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.blackScore = 2;
        this.whiteScore = 2;
        this.gameOver = false;
        this.playerTurn = Othello.PLAYER_1;
    }

    public OthelloGameState(OthelloGameBoard gameBoard, int blackScore, int whiteScore, boolean gameOver, String playerTurn) {
        this.gameBoard = gameBoard;
        this.blackScore = blackScore;
        this.whiteScore = whiteScore;
        this.gameOver = gameOver;
        this.playerTurn = playerTurn;
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

    // checkScore() modifies or updates the players' scores.
    public void checkScore() {
    	blackScore = 0;
    	whiteScore = 0;
    	for (ArrayList<OthelloCell> row : gameBoard.getBoard())
    		for (OthelloCell cell : row) {
    			if (cell.isBlack()) blackScore++;
    			if (cell.isWhite()) whiteScore++;
    		}
    }
    
    // isBlackTurn() returns true if it is currently the black player's
    // turn in this game state, false otherwise.
    public boolean isBlackTurn() {
        return playerTurn == Othello.PLAYER_2;
    }

    // isWhiteTurn() returns true if it is currently the white player's
    // turn in this game state, false otherwise.
    public boolean isWhiteTurn() {
        return playerTurn == Othello.PLAYER_1;
    }

    // isValidMove() returns true if the current player whose turn it is
    // can make a valid move at cell (x, y).
    public boolean isValidMove(int x, int y) {
    	if (!gameBoard.isValidCell(x, y)) return false;
    	if (!gameBoard.isCellEmpty(x, y)) return false;
    	return !getValidAdjCells(x, y).isEmpty();
    }

    // makeMove() modifies this game state by making a move on behalf of
    // the current player at cell (x, y).
    public void makeMove(int x, int y) {
    	int xCoord, yCoord, xDelta, yDelta;
    	Disk opposingColor = (isWhiteTurn()) ? Disk.BLACK : Disk.WHITE;

    	if (isValidMove(x, y)) {
    		gameBoard.placeElement(x, y, (isWhiteTurn()) ? Disk.WHITE : Disk.BLACK);
    		
    		for (OthelloCell cell : getValidAdjCells(x, y)) {
    			xCoord = cell.getxCoord();
    			yCoord = cell.getyCoord();
    			xDelta = x - xCoord;
    			yDelta = y - yCoord;
    			while (gameBoard.getCell(xCoord, yCoord).getDisk() == opposingColor) {
    				gameBoard.flipDisk(xCoord, yCoord);
    				xCoord -= xDelta;
    				yCoord -= yDelta;
    			}
    		}
    		
    		changeTurn();
    	}
    	else {
    		System.out.println("Invalid move!");
    	}
    }

    // isGameOver() returns true if the game is over in this game state,
    // false otherwise.
    public boolean isGameOver() {
        return gameOver;
    }
    
    // checkGameOver() modifies and sets gameOver attribute to true if
    // the game is over in this game state, false otherwise.
    public void checkGameOver() {
    	for (ArrayList<OthelloCell> column : gameBoard.getBoard()) {
            for (OthelloCell othelloCell : column)
                if (othelloCell.isEmpty()) {
                    gameOver = false;
                    return;
                }
        }
    	gameOver = true;
    }
    
    public String getPlayerTurn() {
    	return playerTurn;
    }
    
    // changes the turn of the current game state
    private void changeTurn() {
    	playerTurn = (isWhiteTurn()) ? Othello.PLAYER_2 : Othello.PLAYER_1;
    }

    // generates ArrayList of Cells adjacent to the 'center' Cell with coordinates x and y,
    // each with the corresponding xCoord and yCoord, with certain significant criteria applied
    private ArrayList<OthelloCell> getValidAdjCells(int x, int y) {
    	ArrayList<OthelloCell> valids = new ArrayList<OthelloCell>();
    	Disk opposingColor = (isWhiteTurn()) ? Disk.BLACK : Disk.WHITE;
    	
    	// iterate through the coordinates defined as top-left, top, top-right,
    	// left, right, bottom-left, bottom, and bottom-right, in that order
    	for (int xCoord = x - 1; xCoord <= x + 1; xCoord++) {
    		for (int yCoord = y - 1; yCoord <= y + 1; yCoord++) {
    			if (xCoord == x && yCoord == y) continue; // skip the 'center' Cell
    			
    			// if is within the index bounds of the board and
    			// 		if the disk is the opposite color of the current turn's color
    			//		if the move is bounded by another piece of the current turn's color
    			if (gameBoard.isValidCell(xCoord, yCoord) && 
    					gameBoard.getCell(xCoord, yCoord).getDisk() == opposingColor &&
    					isBounded(x, y, xCoord, yCoord))
    				valids.add(gameBoard.getCell(xCoord, yCoord));
    		}
    	}
    	
    	return valids;
    }
    
    private boolean isBounded(int centerX, int centerY, int adjX, int adjY) {
    	int xCoord = adjX;
    	int yCoord = adjY;
    	int xDelta = centerX - xCoord;
    	int yDelta = centerY - yCoord;
    	Disk turnColor = (isWhiteTurn()) ? Disk.WHITE : Disk.BLACK;
    
    	while (gameBoard.isValidCell(xCoord, yCoord)) {
    		if (gameBoard.getCell(xCoord, yCoord).getDisk() == turnColor) return true;
    		xCoord -= xDelta;
    		yCoord -= yDelta;
    	}
    	return false;
    }
}
