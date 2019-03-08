package Othello;
import java.util.ArrayList;

public class GameBoard {

    private ArrayList<ArrayList<Cell>> board;
    private int width;
    private int height;

    public GameBoard(ArrayList<ArrayList<Cell>> board, int width, int height){
        this.board = board;
        this.width = width;
        this.height = height;
    }

    // width() returns the width of this Othello board.
    public int getWidth(){
        return width;
    }

    // height() returns the height of this Othello board.
    public int getHeight() {
        return height;
    }

    // isValidCell() returns true if the given (x, y) is a valid
    // cell on this board -- i.e., if (x, y) is in the boundaries
    // of the board -- or false otherwise.
    public boolean isValidCell(int x, int y){ //IMPLEMENT
        return false;
    }

    // isCellEmpty() returns true if the given (x, y) is empty.
    public boolean isCellEmpty(int x, int y){
        return board.get(x).get(y).isEmpty();
    }

    // getCell() returns the contents of the cell (x, y).  The cell
    // will either be "EMPTY", "BLACK", or "WHITE".
    public Cell getCell(int x, int y){
        return board.get(x).get(y);
    }

    public Cell setCell(int x, int y, Cell cell){
        board.get(x).get(y) = cell;
    }

    // placeDisk() places a disk on the board in cell (x, y),
    // provided that cell (x, y) is currently empty.  If the
    // cell is not currently empty.

    public void placeDisk(int x, int y, Cell cell){
        if(isCellEmpty()) {
            board.get(x).get(y) = cell;
        }
    }

    // flipDisk() flips the disk on the board in cell (x, y),
    // if any -- so, if it was white, it is now black; if it
    // was black, it is now white.
    public void flipDisk(int x, int y){ //IMPLEMENT

    }


}
