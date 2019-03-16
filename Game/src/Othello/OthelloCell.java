package Othello;

import GameEnvironment.Cell;

public class OthelloCell extends Cell{
    private Disk disk;

    public OthelloCell(int xCoord, int yCoord, Disk disk){
        super(xCoord,yCoord);
        this.disk = disk;
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
}
