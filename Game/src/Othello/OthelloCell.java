package Othello;

import GameEnvironment.Cell;
import java.util.ArrayList;

public class OthelloCell{
    private int xCoord, yCoord;
    private Disk disk;

    public OthelloCell(int xCoord, int yCoord, Disk disk){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.disk = disk;
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public Disk getDisk(){
        return disk;
    }
    
    public void setDisk(Disk disk){
        this.disk = disk;
    }

    public boolean isEmpty() {
        return disk == Disk.EMPTY;
    }

    public boolean isWhite() {
        return disk == Disk.WHITE;
    }

    public boolean isBlack() {
        return disk == Disk.BLACK;
    }

    public String toString()
    {
        if (disk == Disk.EMPTY) return "0";
        if (disk == Disk.WHITE) return "1";
        return "2";
    }

}
