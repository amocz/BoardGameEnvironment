package Othello;

import GameEnvironment.GameState;
import GameEnvironment.Player;

import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class Othello {
    private ArrayList<OthelloGameState> gameState;
    public static String PLAYER_1;
    public static String PLAYER_2;
    private static List<Player> players;
    private int width;
    private int height;

    public Othello(int width, int height, List<Player> players) {
        gameState = new ArrayList<OthelloGameState>();
        this.width = width;
        this.height = height;
        this.players = players;
        PLAYER_1 = players.get(0).getName() + " (WHITE)";
        PLAYER_2 = players.get(1).getName() + " (BLACK)";
        makeNewGame();
    }

    public void makeNewGame() {
        OthelloGameBoard gb = new OthelloGameBoard(width, height);
        gameState.add(new OthelloGameState(gb));
    }

    public String determineWinner(OthelloGameState gameState) {
        if (gameState.getBlackScore() > gameState.getWhiteScore())
        {
            int score = players.get(0).getScore();
            players.get(1).setScore(players.get(0).getScore() );
            return "BLACK";
        }
        if (gameState.getBlackScore() < gameState.getWhiteScore()){
            players.get(0).setScore(1 + players.get(1).getScore());
            return "WHITE";
        }
        return "TIE";
    }

    public OthelloGameState getCurrentGameState()
    {
        return gameState.get(gameState.size() - 1);
    }

    public ArrayList<OthelloGameState> getGameStates()
    {
        return gameState;
    }

    public boolean isGameOver() {
        return gameState.get(gameState.size() - 1).isGameOver();
    }

/**
    public static void main(String args[]) {
        Othello game = new Othello(8, 8);
        OthelloGameState currentGameState = game.gameState.get(game.gameState.size() - 1);
        Scanner reader = new Scanner(System.in);
        
        System.out.println(currentGameState.getPlayerTurn() + "'s TURN!");
        System.out.println("WHITE: " + currentGameState.getWhiteScore() + "\tBLACK: " + currentGameState.getBlackScore());
    	currentGameState.getGameBoard().print();
    	
        while (!game.isGameOver()) {
            System.out.println("Enter an x coordinate for the move: ");
            int x = reader.nextInt();
            System.out.println("Enter a y coordinate for the move: ");
            int y = reader.nextInt();
            
            System.out.println(currentGameState.getPlayerTurn() + "'s TURN!");
            System.out.println("WHITE: " + currentGameState.getWhiteScore() + "\tBLACK: " + currentGameState.getBlackScore());
        	currentGameState.getGameBoard().print();
            
            currentGameState.makeMove(x, y);
            currentGameState.checkScore();
            currentGameState.checkGameOver();
        }
        
        String winner = game.determineWinner(currentGameState);
        if (winner.equals("TIE")) {
        	System.out.println("IT'S A " + winner);
        }
        else {
        	System.out.println(winner + " WINS!");
        }
        
        reader.close();
    }
*/
}

