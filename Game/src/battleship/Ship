package battleship;

public class Ship {

    Coordinate a;


    // Boolean should be true if the point was hit by another player
    boolean aHit;


    // Constructor
    Ship(Coordinate a){
        this.a = a;
    }

    
    //compare ships to check if they are the same    
    public boolean compareShip(Ship ship){
        if(ship.getA().compareCoord(this.a)){
            return true;
        }
        return false;
    }
	
    
    public Coordinate getA() {
        return a;
    }

    //call hit to attack the ship
    public void Hit(Coordinate hit){
        if(hit.getYCoord() == a.getYCoord() && hit.getXCoord() == a.getXCoord()){
            aHit =true;
        }


    }


    public boolean isHit(Coordinate hit){
        if(hit.getXCoord() == a.getXCoord()&&hit.getYCoord() == a.getYCoord()){
            return true;
        }

        return false;
    }



    //check if the ship is sunk
    public boolean isShipSunk(){
        if(aHit){
            return true;
        }
        else{
            return false;
        }
    }
}
