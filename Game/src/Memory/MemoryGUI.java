package Memory;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import GameEnvironment.Player;

public class MemoryGUI {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private static JLabel firstPlayerScore;
    private static JLabel secondPlayerScore;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel scorePanel;

    private int ROW_LENGTH = 4;
    
    public MemoryGUI(List<Player> players) {
        prepareGUI();
        MemoryGame memoryGame = getMemoryGame(players, ROW_LENGTH);
        memoryGame.setPlayers(players);
        showScores(memoryGame);
        showGridLayoutDemo(memoryGame, ROW_LENGTH);  
    }
    
    private void prepareGUI(){
        mainFrame = new JFrame("Memory");
        mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(0, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        firstPlayerScore = new JLabel("",JLabel.LEFT);
        secondPlayerScore = new JLabel("",JLabel.RIGHT );
        statusLabel = new JLabel("",JLabel.CENTER);        
        scorePanel = new JPanel();
        
        /*mainFrame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
           }        
        });  */  
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(scorePanel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);  
     }
    
    void showScores(MemoryGame memoryGame) {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(1,2);
        panel.setLayout(layout);
        Player firstPlayer = memoryGame.getPlayers().get(0);
        Player secondPlayer = memoryGame.getPlayers().get(1);
        firstPlayerScore.setText(firstPlayer.getName() + "'s Score: " + firstPlayer.getGameScore() + "         | ");      
        secondPlayerScore.setText(secondPlayer.getName() + "'s Score: " + secondPlayer.getGameScore()); 
        panel.add(firstPlayerScore);
        panel.add(secondPlayerScore);
        scorePanel.add(panel);
        mainFrame.setVisible(true);  
    }
    
    
    void showGridLayoutDemo(MemoryGame memoryGame, int size) {
        Player firstPlayer = memoryGame.getPlayers().get(0);
        Player secondPlayer = memoryGame.getPlayers().get(1);
        
        headerLabel.setText("Player Turn: " + memoryGame.getGamestate().getPlayerTurn().getName());  
      
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        GridLayout layout = new GridLayout(0,size);
       
        panel.setLayout(layout);        
        
        
        ArrayList<JButton> buttonList = new ArrayList<JButton>();
        for(int i = 0; i < size * size; i++) {
            JButton button = new JButton();
            buttonList.add(button);
        }
        ArrayList<ArrayList<MemoryElement>> cards = ((MemoryGameState) memoryGame.getGamestate()).getGameboard();

        int tmp = 0;
        for (int i= 0; i<size; i++){
            for (int j = 0; j<size; j++){
                final int index0 = i;
                final int index1 = j;
                final int index2 = tmp;
                buttonList.get(tmp).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonList.get(index2).setText(((MemoryElement)cards.get(index0).get(index1)).getValue());
                        
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                compareStaging(memoryGame, ((MemoryElement)cards.get(index0).get(index1)), buttonList.get(index2), headerLabel, firstPlayer, secondPlayer);
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                }
                            }
                        });
                        
                    }
                });
                panel.add(buttonList.get(tmp));
                tmp++;
            }
        }
        controlPanel.add(panel);
        mainFrame.setVisible(true);  
    }
    
    static MemoryElement toCompare = null;
    static JButton toCompareButton = null;
    
    public static void compareStaging(MemoryGame memoryGame, MemoryElement me, JButton button, JLabel headerLabel, Player firstPlayer, Player secondPlayer) { //, String textChange) {
        Player currentPlayer = memoryGame.getGamestate().getPlayerTurn();
        if (toCompare == null) {
            toCompare = me;
            toCompareButton = button;
        } else {
            if (new MemoryGameState().matchCards(toCompare, me)) {
                toCompareButton.setEnabled(false);
                button.setEnabled(false);
                toCompare.setIsMatched(true);
                me.setIsMatched(true);
                currentPlayer.setGameScore(currentPlayer.getGameScore() + 1);
            } else {
                toCompareButton.setText("");
                button.setText("");
                ((MemoryGameState)memoryGame.getGamestate()).nextTurn(memoryGame.getPlayers(), currentPlayer);
            }
            toCompare = null;
        }
        if (((MemoryGameState)memoryGame.getGamestate()).isGameFinished()) {
            if (firstPlayer.getGameScore() > secondPlayer.getGameScore()) {
                headerLabel.setText("Game Finished! - " + firstPlayer.getName() + " WINS");
                firstPlayer.setScore(firstPlayer.getScore() + 1);
            } else if (secondPlayer.getGameScore() > firstPlayer.getGameScore()) {
                headerLabel.setText("Game Finished! - " + secondPlayer.getName() + " WINS");
                secondPlayer.setScore(secondPlayer.getScore() + 1);
            } else {
                headerLabel.setText("Game Finished! - TIE");
                firstPlayer.setScore(firstPlayer.getScore() + 1);
                secondPlayer.setScore(secondPlayer.getScore() + 1);
            }
        } else if (toCompare == null) {
            headerLabel.setText("Player Turn: " + memoryGame.getGamestate().getPlayerTurn().getName());
        }
        firstPlayerScore.setText(firstPlayer.getName() + "'s Score: " + firstPlayer.getGameScore() + "         | ");
        secondPlayerScore.setText(secondPlayer.getName() + "'s Score: " + secondPlayer.getGameScore());
    }
    
    public MemoryGame getMemoryGame(List<Player> players, int row_size) {
        MemoryGame memoryGame = new MemoryGame(players);

        int size = row_size;
        int totalNum = size * size;

        // populate index arraylist
        ArrayList<String> items = new ArrayList<String>(totalNum);
        for (int i = 0; i < totalNum/2; i++){
            items.add(Integer.toString(i+1));
        }
        for (int i = totalNum/2; i < totalNum; i++){
            items.add(Integer.toString(i+1- totalNum/2));
        }
        

        //Shuffle ArrayList
        Collections.shuffle(items);

        //populate Board with ME
        int tmp = 0;
        ArrayList<ArrayList<MemoryElement>> xByxBoard = new ArrayList<>();
        for (int i = 0; i< size; i++){
            ArrayList<MemoryElement> row = new ArrayList();
            for (int j = 0; j<size; j++){
                MemoryElement me = new MemoryElement();
                me.setValue(items.get(tmp));
                me.setIsMatched(false);
                row.add(me);
                tmp++;
            }
            xByxBoard.add(row);
        }
        MemoryGameState mgs = new MemoryGameState();
        mgs.setGameboard(xByxBoard);
        memoryGame.setGamestate(mgs);
        
        memoryGame.initialize();
        return memoryGame;
    }
}
