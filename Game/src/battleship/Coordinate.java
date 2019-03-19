package battleship;

import GameEnvironment.Cell;

public class Coordinate extends Cell {
	
	
   
    public Coordinate(int xCoord, int yCoord) {
		super(xCoord, yCoord);
	}

	//compare coordinate objects
    public boolean compareCoord(Coordinate coordinate){
        if(coordinate.getXCoord() == this.xCoord && coordinate.getXCoord() == this.yCoord){
            return true;
        }
        return false;
    }

    public String toString(){
        return "\nX=" + xCoord + " and Y=" + yCoord;
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
