package battleship;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



/**
 Represents the player's own grid
 */
public class DefenseGrid extends BattleGrid {
    private String gridType = "selfGrid";
    private boolean isSelfGridListener;
    private String name;
    private Point firstPoint = new Point(0,0);
    private BattleShip battleShip;
    private JPanel thePanel = new JPanel();


    public DefenseGrid(String name,BattleShip battleShip) {
        super();
        this.name = name.split("`")[1];
        this.battleShip = battleShip;
    }

    public void getJpanel(Point newPoint){
        thePanel = this.getComponentAt(newPoint);
    }
    

    
    @Override
    protected JPanel getCell()
    {

        JPanel firstCell = new JPanel();
        firstCell.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
        
        // set the defense(bottom) screen size
        firstCell.setPreferredSize(new Dimension(screenSize, screenSize)); 
        firstCell.setBackground(Color.white);
        
     
        firstCell.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(isSelfGridListener) {
                    firstPoint = firstCell.getLocation();
                    double xPos = (firstPoint.getX()/screenSize+1);
                    int x = (int) xPos;
                    double yPos = (firstPoint.getY()/screenSize+1);
                    int y = (int) yPos;

  
                    Coordinate a = new Coordinate(x,y);


                    if(name.equals("Player1")){
                        battleShip.getPlayer1Data().addShip(a); // Create new ship object
                        draw();
                    }
                    if(name.equals("Player2")){
                        battleShip.getPlayer2Data().addShip(a); // Create new ship object
                        draw();
                    }
                }
            }
        });
        return firstCell;
    }
    public void setSelfGridListener (boolean selfGridListener){
        this.isSelfGridListener = selfGridListener;
    }

    public void draw(){


        int[][] temp=null;
        if(name.equals("Player1")){
            temp = battleShip.getPlayer1Data().getSelfData();
        }
        else if(name.equals("Player2")){
            temp = battleShip.getPlayer2Data().getSelfData();
        }

        for (int i = 0; i < gridSieze + 1 ; i++) {
            for (int j = 0; j < gridSieze +1 ; j++)
            {
               if(temp[i][j]==1){
                    int x = numberToPanel(i);
                    int y = numberToPanel(j);

                    Point p = new Point(x,y);
                    getJpanel(p);
                    thePanel.setBackground(Color.GREEN);
               }
               if(temp[i][j]==0){
                   int x = numberToPanel(i);
                   int y = numberToPanel(j);

                   Point p = new Point(Math.abs(x),Math.abs(y));
                   getJpanel(p);

                   thePanel.setBackground(Color.white);

                }
            }
        }
    }
    
    
    public int numberToPanel(int s){
        int temp = ( s - 1 )*screenSize;
        return temp;
    }


    public boolean getSelfGridListener() {
        return isSelfGridListener;
    }
    public String getGridType(){
        return gridType;
    }
}
