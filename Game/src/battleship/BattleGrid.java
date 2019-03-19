package battleship;

import javax.swing.*;
import java.awt.*;


public abstract class BattleGrid extends JPanel {
    private JPanel JP;
    JPanel self;
    int screenSize = 35;
    int gridSieze = 7;
    
    public BattleGrid() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        self = new JPanel();
        self.setLayout(new GridLayout(0, gridSieze));

        for (int i = 0; i < gridSieze; i++) {
            for (int j = 0; j < gridSieze; j++) {
            	JP = getCell();
                self.add(JP);
            }
        }
        this.add(self);
    }

    //return the cell that selected at point p
    public JPanel getComponentAt( Point p) {
        Component comp = null;
        for (Component child : self.getComponents()) {
            if (child.getBounds().contains(p)) {
                comp = child;
            }
        }
        return (JPanel)comp;
    }
    

    protected abstract JPanel getCell();
}
