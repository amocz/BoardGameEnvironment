package Memory;
import java.util.ArrayList;
import java.util.List;

import GameEnvironment.GameState;
import GameEnvironment.Player;

public class MemoryGameState extends GameState {
    private int flippedCount;
    private int cardsLeft;
    private ArrayList<ArrayList<MemoryElement>> gameboard;
    
    public MemoryGameState() {
        super();
        this.gameboard = new ArrayList<>();
        //this.flippedCount = 0;
        //this.cardsLeft = 0;
    }
    
    public void nextTurn(List<Player> list, Player player) {
        int index = list.indexOf(player);
        if (index == list.size()-1) {
            super.setPlayerTurn(list.get(0));
        } else {
            super.setPlayerTurn(list.get(index+1));
        }
    }
    
    public void flipCards() {}
    
    public void isValidFlip() {}
    
    public boolean matchCards(MemoryElement me0, MemoryElement me1) {
        if (me0 != me1 && !me0.isMatched() && !me1.isMatched() && me0.getValue().equals(me1.getValue())) {
            return true;
        }
        return false;
    }
    
    public boolean isGameFinished() {
        for (ArrayList<MemoryElement> row: gameboard) {
            for (MemoryElement card: row) {
                if (!card.isMatched()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getFlippedCount() {
        return flippedCount;
    }

    public void setFlippedCount(int flippedCount) {
        this.flippedCount = flippedCount;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public void setCardsLeft(int cardsLeft) {
        this.cardsLeft = cardsLeft;
    }

    public ArrayList<ArrayList<MemoryElement>> getGameboard() {
        return gameboard;
    }

    public void setGameboard(ArrayList<ArrayList<MemoryElement>> gameboard) {
        this.gameboard = gameboard;
    }
    
    public void printGameBoard() {
        for (ArrayList<MemoryElement> al: this.gameboard) {
            System.out.println(al.toString());
        } 
    }
    
    
}
