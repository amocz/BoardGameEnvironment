package Othello;

import GameEnvironment.Element;

public class Cell extends Element{
    private int xCoord;
    private int yCoord;
    private String color;


    public Cell(int xCoord, int yCoord, String color){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.color = color;
        setPiecename("Disk");
    }

    public boolean isEmpty() {
    	return color.equals("EMPTY");
    }

    public boolean isWhite() {
    	return color.equals("WHITE");
    }

    public boolean isBlack() {
    	return color.equals("BLACK");
    }
}
