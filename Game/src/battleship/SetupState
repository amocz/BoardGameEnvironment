package battleship;

public class SetupState extends BattleshipState {

    SetupState(BattleShip battleShip,BattleshipBoard player1,BattleshipBoard player2){
        this.player1 = player1;
        this.player2 = player2;
        this.battleShip = battleShip;
    }


	//turn ON SelfGrid for player 1
    public void p1Turn (){
        player1.getSelfGrid().setSelfGridListener(true);
    }

    //turn OFF SelfGrid for player 2
    public void p2Turn (){
        player2.getSelfGrid().setSelfGridListener(true);
        battleShip.setState(battleShip.getInGameState());
       
    }

}
