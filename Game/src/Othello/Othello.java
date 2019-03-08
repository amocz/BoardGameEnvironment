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

        new GameState(new GameBoard(makeEmptyBoard(), width, height), 0,0, false, "WHITE", null)

    }

    public String determineWinner() {
        return new String();
    }

    public ArrayList<ArrayList<Cell>> makeEmptyBoard() {
        ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();

        for(int i = 0; i < width; i++ ){
            for(int j = 0; j < height; j++){
                Cell cell = new Cell(i,j,"EMPTY");
                board.get(i).get(j) = cell;
            }
        }

        return board;
    }
}
