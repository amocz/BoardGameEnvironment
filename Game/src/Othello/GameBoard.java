package Othello;
import GameEnvironment.Grid;

import java.util.ArrayList;

public class GameBoard extends Grid {

    private ArrayList<ArrayList<Cell>> board;
    public GameBoard(int width, int height) {
        super(width,height);
        this.board = makeEmptyBoard();
    }

    // width() returns the width of this Othello board.
    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }
    
    // width() returns the width of this Othello board.
    public int getWidth() {
        return getWidth();
    }

    // height() returns the height of this Othello board.
    public int getHeight() {
        return getHeight();
    }

    // isValidCell() returns true if the given (x, y) is a valid
    // cell on this board -- i.e., if (x, y) is in the boundaries
    // of the board -- or false otherwise.
    public boolean isValidCell(int x, int y) { //IMPLEMENT
        return x < getWidth() & y < getHeight();
    }

    // isCellEmpty() returns true if the given (x, y) is empty.
    public boolean isCellEmpty(int x, int y) {
        return board.get(x).get(y).isEmpty();
    }

    // getCell() returns the contents of the cell (x, y).  The cell
    // will either be "EMPTY", "BLACK", or "WHITE".
    public Cell getCell(int x, int y) {
        return board.get(x).get(y);
    }

    public void setCell(int x, int y, Cell cell) {
        board.get(x).set(y, cell);
    }

    // placeDisk() places a disk on the board in cell (x, y),
    // provided that cell (x, y) is currently empty.
    public void placeDisk(int x, int y, Cell cell) {
    	setCell(x, y, cell); // redundant, but whatever
    }

    // flipDisk() flips the disk on the board in cell (x, y),
    // if any -- so, if it was white, it is now black; if it
    // was black, it is now white.
    public void flipDisk(int x, int y) {
    	if (getCell(x, y).isWhite()) setCell(x, y, new Cell(x, y, "BLACK"));
    	if (getCell(x, y).isBlack()) setCell(x, y, new Cell(x, y, "WHITE"));
    }

    private ArrayList<ArrayList<Cell>> makeEmptyBoard() {
        ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();

        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                setCell(i, j, new Cell(i, j, "Empty"));
            }
        }
        return board;
    }

}
