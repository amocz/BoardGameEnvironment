package battleship;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/*
	Screen to attack enemy's
 */
public class AttackGrid extends BattleGrid {
    private String name;
    private int isP2Sunk = 0;
    private int isP1Sunk = 0;
    private boolean isAttackGridListener ;
    private BattleShip battleShip;
    private BattleshipBoard player;
    private JPanel thePanel = null;
    
    public AttackGrid(String name,BattleShip battleShip,BattleshipBoard battleshipBoard) {
        super();
        this.name = name.split("`")[1];
        this.player = battleshipBoard;
        this.battleShip = battleShip;

    }

    @Override
    protected JPanel getCell()
    {
        JPanel panel = new JPanel();
        
        // set the attack screen's grid as red and fill in with white
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        
        // set the attack(top) screen size 
        panel.setPreferredSize(new Dimension(screenSize, screenSize));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isAttackGridListener) {

                    Point i = panel.getLocation();
                    double xPos = (i.getX() / screenSize + 1);
                    int x = (int) xPos;
                    double yPos = (i.getY() / screenSize + 1);
                    int y = (int) yPos;

                    if (name.equals("Player1")) {
                        if(!battleShip.getAttackTurn()) {
                            battleShip.setAttackTurn(true);
                            Coordinate hit = new Coordinate(x, y);
                            battleShip.getPlayer2Data().attackShip(hit);

                            boolean success = battleShip.getPlayer2Data().isHit(hit);
                            if (success) {
                                battleShip.getPlayer1Data().setAttackData(x, y, "success");
                                draw();
                            } else {
                                battleShip.getPlayer1Data().setAttackData(x, y, "failure");
                                draw();
                            }

                            boolean isSunk = battleShip.getPlayer2Data().isSunk(hit);
                            if (isSunk) {
                            	isP2Sunk++;
                                battleShip.getP1Sreen().enemyShipSunk.setText(Integer.toString(isP2Sunk));
                                JOptionPane.showMessageDialog(panel, "A ship was detected! \nclick OK to transfer turn to player 2n");
                                player.hideScreen();
                                battleShip.getP2Sreen().showScreen();
                                String ownShipSunkPlayer2 = Integer.toString(battleShip.getPlayer2Data().getNumberOfOwnShipSunk());
                                battleShip.getP2Sreen().ownShipSunk.setText(ownShipSunkPlayer2);
                            }
                        }
                        boolean lost = battleShip.getPlayer2Data().isPlayerLost();
                            if (lost) {
                                battleShip.setState(battleShip.getEndState());
                                JOptionPane.showMessageDialog(panel, "Congratulations player 1 WON! \nClick OK to Exit the game");
                                battleShip.p1Turn();
                            }

                        }
                        if (name.equals("Player2")) {
                            if(battleShip.getAttackTurn()) {
                                battleShip.setAttackTurn(false);
                                Coordinate hit = new Coordinate(x, y);
                                battleShip.getPlayer1Data().attackShip(hit);

                                boolean success = battleShip.getPlayer1Data().isHit(hit);
                                if (success) {
                                    battleShip.getPlayer2Data().setAttackData(x, y, "success");
                                    draw();
                                } else {
                                    battleShip.getPlayer2Data().setAttackData(x, y, "failure");
                                    draw();
                                }

                                boolean isSunk = battleShip.getPlayer1Data().isSunk(hit);
                                if (isSunk) {
                                	isP1Sunk++;
                                    battleShip.getP2Sreen().enemyShipSunk.setText(Integer.toString(isP1Sunk));
                                    JOptionPane.showMessageDialog(panel, "A ship was detected! \nclick OK to transfer turn to player 1");
                                    player.hideScreen();
                                    battleShip.getP1Sreen().showScreen();
                                    String ownShipSunkPlayer1 = Integer.toString(battleShip.getPlayer1Data().getNumberOfOwnShipSunk());
                                    battleShip.getP1Sreen().ownShipSunk.setText(ownShipSunkPlayer1);
                                }
                            }
                                boolean lost = battleShip.getPlayer1Data().isPlayerLost();
                                if (lost) {
                                    battleShip.setState(battleShip.getEndState());
                                    JOptionPane.showMessageDialog(panel, "Congratulations player 2 WON! \nClick OK to Exit the game");
                                    battleShip.p2Turn();
                                }
                            }
                        }


            }
        });

        return panel;
    }
    public void setAttackGridListener (boolean attackGridListener){
        this.isAttackGridListener = attackGridListener;

    }
    public void getJpanel(Point newPoint){
        thePanel = this.getComponentAt(newPoint);
    }

    public void draw(){

        int[][] temp=null;
        if(name.equals("Player1")){
            temp = battleShip.getPlayer1Data().getAttackData();
        }
        else if(name.equals("Player2")){
            temp = battleShip.getPlayer2Data().getAttackData();
        }

        for (int i = 0; i < gridSieze+1 ; i++) {
            for (int j = 0; j < gridSieze+1 ; j++)
            {
                if(temp[i][j]==1){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);

                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.YELLOW);
                }
                if(temp[i][j]==2){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);

                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.BLACK);

                }
            }
        }
    }

    public int numberToPanel(int s){
        int temp = (s-1)*screenSize;
        return temp;
    }

    public boolean getAttackGridListener() {
        return isAttackGridListener;
    }
}
