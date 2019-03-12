package Othello;

public class Cell {
    private int xCoord;
    private int yCoord;
    private String disk;


    public Cell(int xCoord, int yCoord, String disk){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.disk = disk;
    }

    public boolean isEmpty() {
    	return disk.equals("EMPTY");
    }

    public boolean isWhite() {
    	return disk.equals("WHITE");
    }

    public boolean isBlack() {
    	return disk.equals("BLACK");
    }
}
