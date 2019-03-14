package GameEnvironment;

import java.util.ArrayList;

public abstract class GameState {
    private ArrayList<ArrayList<Element>> boardstate = new ArrayList<ArrayList<Element>>();
    private Player playerTurn;

    public GameState() {
        this.boardstate = null;
        this.playerTurn = null;
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
