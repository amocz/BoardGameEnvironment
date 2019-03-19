package battleship;

import java.util.List;

import GameEnvironment.Player;

public class BattleShip extends BattleshipState {
    private SetupState SetupState; //Begining of the game. AttackGrid is OFF and SelfGrid is ON
    private BattleshipState InGameState; //After the game begune. AttackGrid is ON and SelfGrid is OFF
    private BattleshipState EndState; // End of the game
    private BattleshipState state;
    private boolean attackTurn; // make sure each player can only attack ONCE

    private User p1Data;
    private User p2Data;
    private BattleshipBoard p1Screen;
    private BattleshipBoard p2Screen;

    public BattleShip(List<Player> players) {
    	Player firstPlayer = players.get(0);
    	Player secondPlayer = players.get(1);
    	p1Screen = new BattleshipBoard(firstPlayer.getName() + "`Player1", true, this);
    	p2Screen = new BattleshipBoard(secondPlayer.getName() + "`Player2", false, this);
    	p1Data = new User(p1Screen);
    	p1Data = new User(p2Screen);
        SetupState = new SetupState(this, p1Screen, p2Screen);
        InGameState = new InGameState(this, p1Screen, p2Screen);
        EndState = new EndState(this, p1Screen, p2Screen);
        this.state = SetupState; //in order to set the state of the game to the beginning of the game
    }

    public void p1Turn() {
        state.p1Turn();
    }

    public void p2Turn() {
        state.p2Turn();
    }

    // method to transfer the game from Setup to the in-game
    public BattleshipState getInGameState() {
        return InGameState;
    }

    // method to transfer the game from in-game to the end of the game
    public BattleshipState getEndState() {
        return EndState;
    }

    // method to set the state of the game to the desired state
    public void setState(BattleshipState state) {
        this.state = state;
    }

    public void setAttackTurn(boolean isPlayerTurn){
        this.attackTurn = isPlayerTurn;
    }

    public boolean getAttackTurn() {
        return attackTurn;
    }
    
    public User getPlayer1Data() {
        return p1Data;
    }
    
    public User getPlayer2Data() {
        return p2Data;
    }


    public BattleshipBoard getP1Sreen() {
        return p1Screen;
    }

    public BattleshipBoard getP2Sreen() {
        return p2Screen;
    }


	
}
