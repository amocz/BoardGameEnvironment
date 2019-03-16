package GameEnvironment;

import java.util.ArrayList;

public abstract class GameBoard<T extends Cell> {

    private ArrayList<ArrayList<T>> board;
    private int width;
    private int height;

    public GameBoard()
    {
        this.board = makeEmptyBoard();
        this.width = 0;
        this.height = 0;
    }

    public GameBoard(int width, int height) {
        this.board = makeEmptyBoard();
        this.width = width;
        this.height = height;
    }

    // width() returns the width of this Othello board.
    public ArrayList<ArrayList<T>> getBoard() {
        return board;
    }

    // width() returns the width of this Othello board.
    public int getWidth() {
        return width;
    }

    // height() returns the height of this Othello board.
    public int getHeight() {
        return height;
    }

    // isValidCell() returns true if the given (x, y) is a valid
    // cell on this board -- i.e., if (x, y) is in the boundaries
    // of the board -- or false otherwise.
    public boolean isValidCell(int x, int y) {
        return x < getWidth() & y < getHeight();
    }

    // isCellEmpty() returns true if the given (x, y) is empty.
    public abstract boolean isCellEmpty(int x, int y);

    // getCell() returns the contents of the cell (x, y).
    public abstract T getCell(int x, int y);

    public abstract ArrayList<ArrayList<T>> makeEmptyBoard();

}
