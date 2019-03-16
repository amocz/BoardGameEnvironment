package GameEnvironment;

public abstract class Cell {
    private int xCoord;
    private int yCoord;

    public Cell(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public abstract boolean isEmpty();
}