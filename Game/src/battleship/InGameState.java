package battleship;

public class InGameState extends BattleshipState{


    InGameState(BattleShip battleShip,BattleshipBoard player1,BattleshipBoard player2){
        this.battleShip = battleShip;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void p1Turn (){
        player1.getSelfGrid().setSelfGridListener(false);
        player1.getAttackGrid().setAttackGridListener(true);
    }
    public void p2Turn (){
        player2.getSelfGrid().setSelfGridListener(false);
        player2.getAttackGrid().setAttackGridListener(true);
    }
}
