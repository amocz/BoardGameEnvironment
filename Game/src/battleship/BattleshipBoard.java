package battleship;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BattleshipBoard extends JFrame {
    int size;
    boolean isP1Start = true;
    boolean isP2Start = true;
    BattleShip battleShip;
    JLabel ownShipSunk;
    JLabel shipBeginning;
    JLabel enemyShipSunk;
    String name;
    
    
    

    public BattleshipBoard(String name, boolean show, BattleShip battleShip) {
    	
    	
    	String playerTag = name.split("`")[1];
    	String displayName = name.split("`")[0];
        //super(name);
        
        this.battleShip = battleShip;
        this.setLayout(new GridLayout(2,2));
        JButton next = new JButton("next");
       
        
        
        
        // add AttackGrid
        this.add(new AttackGrid(name,battleShip, this));
        
        
        
        
        // add next button to change turns between players
        this.add(next);
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(playerTag.equals("Player1")){
                    size = battleShip.getPlayer1Data().getFleet().size();
                    if(isP1Start){
                    	
                        shipBeginning.setText(Integer.toString(size));
                        isP1Start = false;
                    }
                    if(!isP1Start){
                        battleShip.p1Turn();
                    }
                    hideScreen();
                    battleShip.getP2Sreen().showScreen();
                }
                if(playerTag.equals("Player2")){
                    size = battleShip.getPlayer2Data().getFleet().size();
                    if(isP2Start){
                        shipBeginning.setText(Integer.toString(size));
                        isP2Start = false;
                    }
                    if(!isP2Start){
                        battleShip.getP2Sreen();
                    }
                    hideScreen();
                    battleShip.getP1Sreen().showScreen();
                }
            }
        });

        
        // add DefenseGrid
        this.add(new DefenseGrid(name,battleShip));
        
                
        // body of the player status
        Box verticalBox = Box.createVerticalBox();

        Box horizontalBox0 = Box.createHorizontalBox();
        horizontalBox0.add(new JLabel("\n" + displayName + "\n"));
        verticalBox.add(horizontalBox0);

        Box horizontalBox1 = Box.createHorizontalBox();
        horizontalBox1.add(new JLabel("My Active Ships : "));
        shipBeginning = new JLabel(""+Integer.toString(size));
        horizontalBox1.add(shipBeginning);
        verticalBox.add(horizontalBox1);

        Box horizontalBox2 = Box.createHorizontalBox();
        horizontalBox2.add(new JLabel("My Sunk Ships : "));
        ownShipSunk = new JLabel(""+Integer.toString(size));
        horizontalBox2.add(ownShipSunk);
        verticalBox.add(horizontalBox2);

        Box horizontalBox3 = Box.createHorizontalBox();
        horizontalBox3.add(new JLabel("Enemy's Sunk Ships : "));
        enemyShipSunk = new JLabel(""+Integer.toString(size));
        horizontalBox3.add(enemyShipSunk);
        verticalBox.add(horizontalBox3);
        
        // add the player status box
        this.add(verticalBox);       
        this.pack();
        this.setVisible(show);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showScreen(){
        this.setVisible(true);
    }

    public void hideScreen() {

        this.setVisible(false);
    }

    public DefenseGrid getSelfGrid(){
        for(Component child : this.getContentPane().getComponents()){
            if(child instanceof DefenseGrid ){
                return (DefenseGrid)child;
            }
        }
        return null;
    }

    public AttackGrid getAttackGrid(){
        for(Component child : this.getContentPane().getComponents()){
            if(child instanceof AttackGrid ){
                return (AttackGrid) child;
            }

        }
        return null;
    }
    public JButton getNextButton(){
        for(Component child : this.getContentPane().getComponents()){
            if(child instanceof JButton ){
                return (JButton) child;
            }

        }
        return null;
    }
    public boolean getIsPlayer2Start() {
        return isP2Start;
    }
}
