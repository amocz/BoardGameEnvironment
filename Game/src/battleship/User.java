package battleship;


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class User {
    private BattleshipBoard player;
    int xNumber = 8;
    int yNumber = 8;
    private int[][] attackData = new int[xNumber][yNumber];
    private int[][] selfData = new int[xNumber][yNumber];
    private int numberOfShipSunk = 0;
    private ArrayList<Ship> fleet = new ArrayList<Ship>();
    private int totalNumberOfShip = 3;
    
    JPanel panel = new JPanel();
    
    User( BattleshipBoard player){
        this.player = player;

    }

    
    /*All the adding and deleting data methods */

    // Creates a new ship and adds to the fleet array
    public void addShip(Coordinate a){    	
            if (isOvelap(a) ) {
            	JOptionPane.showMessageDialog(panel, "overlaps");
                }
            else if(shipsLeft() < totalNumberOfShip){
                fleet.add(new Ship(a));
                setSelfData(a);
            }
        }
    

    //remove ship from fleet array
    public void deleteShip(Coordinate a) {
        Ship temp = new Ship(a);
        for (int i = 0; i < fleet.size(); i++) {
            if (fleet.get(i).compareShip(temp)) {
                fleet.remove(i);
            }
        }
    }

    //remove ships from selfData table
    public void deleteShipInSelfGrid(Coordinate a) {
        selfData[a.getXCoord()][a.getYCoord()]=0;

    }

    //add ships to selfData table
    public void addShipInSelfGrid(Coordinate a) {
        selfData[a.getXCoord()][a.getYCoord()]=1;
   
    }

    /*
    	attackShip searched goes through the array and tries to attack every point of every ship. 
    	If there is a match it will be marked in the ship object
    */
    public void attackShip(Coordinate hitCord) {
        Iterator itr = fleet.iterator();
        while (itr.hasNext()){
            Ship temp = (Ship)itr.next();
            temp.Hit(hitCord); // Hit the point in the ship
        }
    }

    
    
    // returns number of ships left
    public int shipsLeft(){
        int temp = fleet.size();
        return temp;
    }
    
    

    /*All the setter methods */
    public void setAttackData(int x, int y, String result) {
        if(result.equals("success")){
            attackData[x][y] = 1;
        }
        else if(result.equals("failure")){
            attackData[x][y] = 2;
        }
    }


    public void setSelfData(Coordinate a){
        selfData[a.getXCoord()][a.getYCoord()]=1;

     
    }

    
    /*All the getter methods */
    public int getNumberOfOwnShipSunk() {
        return numberOfShipSunk;
    }

    public ArrayList<Ship> getFleet(){
        return fleet;
    }

    public int[][] getSelfData(){
        return selfData;
    }
    
    public int[][] getAttackData(){
        return attackData;
    }

    
    public int getDataFromCell(int x, int y){
        for (int i = 0; i <xNumber; i++) {
            for (int j = 0; j < yNumber; j++) {
                if(i == x && j ==y){
                    return selfData[i][j];
                }
            }
        }
        return -1;
    }

    
    
    
    
    /*All the boolean methods to check for state*/

    
    // isHit returns true if there is a ship at the point that was hit
    public boolean isHit(Coordinate point){
        for (int i=0;i<fleet.size();){
            Ship temp = fleet.get(i);
            if(temp.isHit(point)){
                return true;
            }
            else{
                i++; // increase the counter if the the ship i didn't contain a point
            }
        }
        return false; 
    }

    
    // isPlayerLost determines if the player lost based on the fleet arraylist size
    public boolean isPlayerLost(){
        if(fleet.size()==0){
            return true; // Player lost
        }
        else{
            return false;
        }
    }

    
    // Boolean method returns true if the Ship was sunk
    public boolean isSunk(Coordinate hitCord){
        for (int i=0;i<fleet.size();){
            Ship temp = fleet.get(i);
            if(temp.isShipSunk()){
                numberOfShipSunk++;
                fleet.remove(i);
                return true;
            }
            else{
                i++; // increase the counter if the ship wasn't sunk
            }
        }
        return false;
    }
   
    
    // checks if player clicks the same cell to deploy his ship
    public boolean isOvelap(Coordinate a){
        boolean isA = false;

        for (int i = 0; i < xNumber; i++) {
            for (int j = 0; j < yNumber; j++)
            {
                if((a.getXCoord()==i&&a.getYCoord()==j)){
                    if(getDataFromCell(i,j) == 1){
                        isA = true;
                    }
                    else{
                        isA = false;
                    }
                }   
            }
        }
        if(isA){
            return true;
        }
        return false;
    }

}
