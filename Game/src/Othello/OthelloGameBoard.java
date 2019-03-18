package Othello;
import GameEnvironment.Cell;
import GameEnvironment.Element;
import GameEnvironment.GameBoard;

import java.util.*;

public class OthelloGameBoard {

    private int width;
    private int height;
    private ArrayList<ArrayList<OthelloCell>> board;

    public OthelloGameBoard(int width, int height) {

        this.width = width;
        this.height = height;

        makeEmptyBoard();

    }

    public OthelloGameBoard(OthelloGameBoard current)
    {
        board = current.getBoard();
        width = current.getWidth();
        height = current.getHeight();
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public ArrayList<ArrayList<OthelloCell>> getBoard()
    {
        return board;
    }

    // isValidCell() returns true if the given (x, y) is a valid
    // cell on this board -- i.e., if (x, y) is in the boundaries
    // of the board -- or false otherwise.
    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < getHeight() && y >= 0 && y < getWidth();
    }

    // isCellEmpty() returns true if the given (x, y) is empty.
    public boolean isCellEmpty(int x, int y) {
        return board.get(x).get(y).isEmpty();
    }

    // getCell() returns the contents of the cell (x, y).  The cell
    // will either be "EMPTY", "BLACK", or "WHITE".
    public OthelloCell getCell(int x, int y) {
        return board.get(x).get(y);
    }

    public void setCell(int x, int y, Disk disk) {
        board.get(x).set(y, new OthelloCell(x,y,disk));
    }

    // placeDisk() places a disk on the board in othelloCell (x, y),
    // provided that othelloCell (x, y) is currently empty.
    public void placeElement(int x, int y, Disk disk) {
        if (board.get(x).get(y).isEmpty()) setCell(x, y, disk);
    }

    // flipDisk() flips the disk on the board in cell (x, y),
    // if any -- so, if it was white, it is now black; if it
    // was black, it is now white.
    public void flipDisk(int x, int y) {
        if (getCell(x, y).isWhite()) setCell(x, y, Disk.BLACK);
        else if (getCell(x, y).isBlack()) setCell(x, y, Disk.WHITE);
    }

    public void makeEmptyBoard()
    {
        this.board = new ArrayList<ArrayList<OthelloCell>>();

        for(int i = 0; i < height; i++)
        {
            ArrayList<OthelloCell> list = new ArrayList<OthelloCell>();
            board.add(list);
        }

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                board.get(i).add(new OthelloCell(i,j,Disk.EMPTY));
            }
        }

        setCell(3,3,Disk.WHITE);
        setCell(3,4,Disk.BLACK);
        setCell(4,3,Disk.BLACK);
        setCell(4,4,Disk.WHITE);

    }

    public void print()
    {
        for(int i = 0; i < height; i++)
        {
        	System.out.print("    ");
            for(int j = 0; j < width; j++)
            {
                System.out.print(" " + getCell(i,j).toString());
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
