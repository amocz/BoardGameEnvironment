package battleship;

import GameEnvironment.GameState;

public abstract class BattleshipState extends GameState{
	
    protected BattleShip battleShip;
    protected BattleshipBoard player1;
    protected BattleshipBoard player2;

    //method for player1 turn to play
    abstract void p1Turn ();
    //method for player1 turn to play
    abstract void p2Turn ();
	

}
