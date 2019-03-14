package tictactoe;

import java.util.ArrayList;
import GameEnvironment.GameState;
import GameEnvironment.Element;
import GameEnvironment.Player;

public class TicTacToeGameState extends GameState{
    private ArrayList<ArrayList<Element>> boardstate = new ArrayList<ArrayList<Element>>();
    private Player playerTurn;

    public TicTacToeGameState(ArrayList<ArrayList<Element>> boardstate, Player playerTurn) {
        this.boardstate = boardstate;
        this.playerTurn = playerTurn;
    }
    
    public TicTacToeGameState(Player A) {
        this.playerTurn = A;
    }

    public ArrayList<ArrayList<Element>> getBoardstate() {
        return boardstate;
    }

    public void setBoardstate(ArrayList<ArrayList<Element>> boardstate) {
        this.boardstate = boardstate;
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }
}
