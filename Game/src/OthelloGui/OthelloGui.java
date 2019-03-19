package OthelloGui;
import GameEnvironment.Player;
import Othello.Othello;
import Othello.OthelloGameBoard;
import Othello.OthelloGameState;
import Othello.Disk;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.*;
import javax.swing.ImageIcon;

public class OthelloGui extends JFrame {
    private JPanel panel;
    private JPanel menu;
    private OthelloGameBoard board;
    private Othello game;
    private OthelloGameState currentGameState;
    private JLabel blackScore;
    private JLabel whiteScore;
    private JLabel playerTurn;
    private static List<Player> players;

    public OthelloGui(List<Player> players) {

        game = new Othello(8, 8, players);
        currentGameState = game.getGameStates().get(game.getGameStates().size() - 1);
        setBoard(currentGameState.getGameBoard());
        initialize();
        this.setVisible(true);
    }

    public void setBoard(OthelloGameBoard gb) {
        this.board = gb;
    }

    public void initialize() {
        setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        panel.setBackground(Color.green.darker().darker().darker());

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {

                JPanel cell = new JPanel(new BorderLayout());
                cell.setSize(70, 70);
                cell.setBackground(new Color(0, 153, 0));
                cell.setBorder(BorderFactory.createLineBorder(Color.gray.darker().darker()));

                ImageIcon black = new ImageIcon(getClass().getResource("../OthelloGui/BLACK.png"));
                ImageIcon white = new ImageIcon(getClass().getResource("../OthelloGui/WHITE.png"));

                if(currentGameState.getGameBoard().getCell(i,j).getDisk() == Disk.BLACK){
                    JLabel disk = new JLabel(black);
                    cell.add(disk);
                }
                if(currentGameState.getGameBoard().getCell(i,j).getDisk() == Disk.WHITE){
                    JLabel disk = new JLabel(white);
                    cell.add(disk);
                }

                panel.add(cell);
                panel.setVisible(true);
            }

            panel.addMouseListener(new MouseListener() {
                public void mouseClicked (MouseEvent e){
                    int x = e.getX() / 74;
                    int y = e.getY() / 74;


                    if(!game.isGameOver())
                    {
                        if (game.getCurrentGameState().isValidMove(y, x)) {
                            game.getCurrentGameState().makeMove(y, x);
                            //game.getCurrentGameState().getGameBoard().print();
                            update();
                        }
                    }
                    else
                    {
                        if(game.determineWinner(currentGameState).equals("TIE"))
                        {
                            JOptionPane.showMessageDialog(null, "It's a TIE!");
                            System.exit(0);
                        }
                        if(game.determineWinner(currentGameState).equals("BLACK"))
                        {
                            JOptionPane.showMessageDialog(null, "BLACK WINS");
                            System.exit(0);
                        }
                        if(game.determineWinner(currentGameState).equals("WHITE"))
                        {
                            JOptionPane.showMessageDialog(null, "WHITE WINS");
                            System.exit(0);
                        }
                    }
                }
                public void mousePressed (MouseEvent e){
                }
                public void mouseReleased (MouseEvent e){
                }
                public void mouseEntered (MouseEvent e){
                }
                public void mouseExited (MouseEvent e){
                }
            });
        }
        menu = new JPanel(new FlowLayout());
        JPanel turnPanel = new JPanel(new FlowLayout());

        playerTurn = new JLabel(("Turn: " + currentGameState.getPlayerTurn()));
        blackScore = new JLabel("Black's Score: " + Integer.toString(currentGameState.getBlackScore()) + "  | ");
        whiteScore = new JLabel("White's Score: " + Integer.toString(currentGameState.getWhiteScore()) + "  |");

        turnPanel.add(playerTurn);
        menu.add(blackScore);
        menu.add(whiteScore);
        menu.add(turnPanel);

        add(panel, BorderLayout.CENTER);
        add(menu, BorderLayout.SOUTH);

        setTitle("Othello");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void update()
    {
        ImageIcon black = new ImageIcon(getClass().getResource("../OthelloGui/BLACK.png"));
        ImageIcon white = new ImageIcon(getClass().getResource("../OthelloGui/WHITE.png"));

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                JPanel tiles = (JPanel) panel.getComponent((i * 8) + j);

                tiles.removeAll();

                if (currentGameState.getGameBoard().getCell(i, j).getDisk() == Disk.BLACK) {
                    JLabel disk = new JLabel(black);
                    tiles.add(disk);
                }
                if (currentGameState.getGameBoard().getCell(i, j).getDisk() == Disk.WHITE) {
                    JLabel disk = new JLabel(white);
                    tiles.add(disk);
                }
            }
        }
        playerTurn.setText("Turn: " + currentGameState.getPlayerTurn());
        blackScore.setText("Black's Score: " + Integer.toString(currentGameState.getBlackScore()) + "  | ");
        whiteScore.setText("White's Score: " + Integer.toString(currentGameState.getWhiteScore()) + "  |");
    }
/**
    public static void main(String[] args) {
        Othello game = new Othello(8, 8);
        OthelloGameState currentGameState = game.getGameStates().get(game.getGameStates().size() - 1);
        OthelloGui othello = new OthelloGui(game,currentGameState);
    }
 */
}