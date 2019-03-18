package Othello;

import GameEnvironment.Cell;

public class OthelloCell{
    private int xCoord;
    private int yCoord;
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
        if(disk == Disk.EMPTY)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isWhite() {
        if(disk == Disk.WHITE)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isBlack() {
        if(disk == Disk.BLACK)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        if(disk == Disk.EMPTY)
        {
            return "0";
        }
        if(disk == Disk.BLACK)
        {
            return "1";
        }
        else
        {
            return "2";
        }

    }
}
