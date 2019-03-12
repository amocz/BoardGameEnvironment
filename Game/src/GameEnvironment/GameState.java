package GameEnvironment;

public abstract class GameState {
    private String[][] boardstate;
    private Player playerTurn;

    public GameState() {
        this.boardstate = null;
        this.playerTurn = null;
    }

    public String[][] getBoardstate() {
        return boardstate;
    }

    public void setBoardstate(String[][] boardstate) {
        this.boardstate = boardstate;
    }

    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }
}
