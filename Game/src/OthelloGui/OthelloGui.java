package OthelloGui;
import Othello.Othello;
import Othello.OthelloGameBoard;
import Othello.OthelloGameState;
import Othello.Disk;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.ImageIcon;

public class OthelloGui extends JFrame {
    private JPanel panel;
    private JPanel menu;
    private OthelloGameBoard board;
    private Othello game;
    private JLabel blackScore;
    private JLabel whiteScore;

    public OthelloGui(Othello game, OthelloGameState currentGameState) {
        this.game = game;
        this.setBoard(currentGameState.getGameBoard());
        initialize();
        this.setVisible(true);
    }

    public OthelloGui(OthelloGameState gs) {
        this.setBoard(gs.getGameBoard());
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

                ImageIcon black = new ImageIcon(getClass().getResource("../OthelloGui/black.png"));
                ImageIcon white = new ImageIcon(getClass().getResource("../OthelloGui/white.png"));

                if(game.getCurrentGameState().getGameBoard().getCell(i,j).getDisk() == Disk.BLACK){
                    JLabel disk = new JLabel(black);
                    cell.add(disk);
                }
                if(game.getCurrentGameState().getGameBoard().getCell(i,j).getDisk() == Disk.WHITE){
                    JLabel disk = new JLabel(white);
                    cell.add(disk);
                }

                panel.add(cell);
                panel.setVisible(true);
            }

            panel.addMouseListener(new MouseListener() {
                public void mouseClicked (MouseEvent e){
                    int i = e.getY() / 74;
                    int j = e.getX() / 74;

                    if (game.getCurrentGameState().isValidMove(i, j)) {
                        game.getCurrentGameState().makeMove(i, j);
                        game.getCurrentGameState().getGameBoard().print();
                        ImageIcon picture = new ImageIcon(getClass().getResource("../OthelloGui/" + game.getCurrentGameState().getPlayerTurn() +".png"));
                        JLabel disk = new JLabel(picture);
                        JPanel boardPanel = (JPanel) panel.getComponent((i * 8) + j);
                        boardPanel.add(disk);

                        blackScore.setText("Black Score: " + Integer.toString(game.getCurrentGameState().getBlackScore()) + "  | ");
                        whiteScore.setText("White Score: " + Integer.toString(game.getCurrentGameState().getWhiteScore()));
                        game.getGameStates().add(new OthelloGameState(game.getCurrentGameState().getGameBoard(), game.getCurrentGameState().getBlackScore(), game.getCurrentGameState().getWhiteScore(), game.getCurrentGameState().isGameOver(), game.getCurrentGameState().changePlayer()));
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
        blackScore = new JLabel("Black Score: " + Integer.toString(game.getCurrentGameState().getBlackScore()) + "  | ");
        whiteScore = new JLabel("White Score: " + Integer.toString(game.getCurrentGameState().getWhiteScore()));

        menu.add(blackScore);
        menu.add(whiteScore);

        add(panel, BorderLayout.CENTER);
        add(menu, BorderLayout.SOUTH);

        setTitle("Othello");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Othello game = new Othello(8, 8);
        OthelloGameState currentGameState = game.getCurrentGameState();
        OthelloGui q = new OthelloGui(game,currentGameState);
    }
}