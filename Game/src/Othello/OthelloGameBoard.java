package Othello;
import GameEnvironment.Cell;
import GameEnvironment.Element;
import GameEnvironment.GameBoard;

import java.util.ArrayList;

public class OthelloGameBoard extends GameBoard<OthelloCell> {

    public OthelloGameBoard(int width, int height) {
        super(width,height);
    }

    // width() returns the width of this Othello board.
    public ArrayList<ArrayList<OthelloCell>> getBoard() {return getBoard();
    }
    
    // width() returns the width of this Othello board.
    public int getWidth() { return getWidth();
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
        return getBoard().get(x).get(y).isEmpty();
    }

    // getCell() returns the contents of the cell (x, y).  The cell
    // will either be "EMPTY", "BLACK", or "WHITE".
    public OthelloCell getCell(int x, int y) {
        return getBoard().get(x).get(y);
    }

    public void setCell(int x, int y, Disk disk) {
        getBoard().get(x).set(y,new OthelloCell(x,y,disk));
    }

    // placeDisk() places a disk on the board in othelloCell (x, y),
    // provided that othelloCell (x, y) is currently empty.
    public void placeElement(int x, int y, Disk disk) {
        if (getBoard().get(x).get(y).isEmpty()) {
            setCell(x, y, disk);
        }
    }

    // flipDisk() flips the disk on the board in cell (x, y),
    // if any -- so, if it was white, it is now black; if it
    // was black, it is now white.
    public void flipDisk(int x, int y) {
    	if (getCell(x, y).isWhite()) {
            setCell(x, y, Disk.BLACK);
        }

    	if (getCell(x, y).isBlack()) {
            setCell(x, y, Disk.WHITE);
        }
    }

    public ArrayList<ArrayList<OthelloCell>> makeEmptyBoard() {
        ArrayList<ArrayList<OthelloCell>> board = new ArrayList<ArrayList<OthelloCell>>();

        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                setCell(i,j,Disk.EMPTY);
            }
        }
        return board;
    }

}
