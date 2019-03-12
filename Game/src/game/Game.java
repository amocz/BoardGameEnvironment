package game;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.border.EmptyBorder;

import tictactoe.TicTacToeBoard;

//import tictactoe.TicTacToe;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;

public class Game extends JFrame implements ActionListener
{	
	private JButton TTTbutton;
	private JButton BSbutton;
	private JButton Mbutton;
	private JButton Obutton;
	private JButton playerProfile;
	private JPanel panel;
	private Player p1, p2;
	
	//Description: set GUI related stuff
	public Game()
	{
		super();
		p1 = new Player();
		p2 = new Player();
		this.setSize(500, 500);
		this.setResizable(false);
		this.setTitle("Game Environment");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		panel = new JPanel();
		
		this.add(panel);
		panel.setBackground(new Color(49,79,79));
		
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(new EmptyBorder(new Insets(50, 150, 150, 150)));
		
		//game buttons
		Icon tic = new ImageIcon(getClass().getResource("tic.png"));
		TTTbutton = new JButton("Tic-Tac-Toe", tic);
		panel.add(TTTbutton);
		TTTbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalStrut(10));
		TTTbutton.setMaximumSize(new Dimension(200, 100));
		TTTbutton.setEnabled(true);
		TTTbutton.addActionListener(this);
		
		Icon battle = new ImageIcon(getClass().getResource("battle.jpg"));
		BSbutton = new JButton("BattleShip", battle);
		panel.add(BSbutton);
		BSbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalStrut(10));
		BSbutton.setMaximumSize(new Dimension(200, 100));
		BSbutton.setEnabled(true);
		BSbutton.addActionListener(this);
		
		Icon memory = new ImageIcon(getClass().getResource("memory.png"));
		Mbutton = new JButton("Memory", memory);
		panel.add(Mbutton);
		Mbutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalStrut(10));
		Mbutton.setMaximumSize(new Dimension(200, 100));
		Mbutton.setEnabled(true);
		Mbutton.addActionListener(this);
		
		Icon othello = new ImageIcon(getClass().getResource("othello.png"));
		Obutton = new JButton("Othello", othello);
		panel.add(Obutton);
		Obutton.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(Box.createVerticalStrut(10));
		Obutton.setMaximumSize(new Dimension(200, 100));
		Obutton.setEnabled(true);
		Obutton.addActionListener(this);	
		
		
		playerProfile = new JButton("Player Profiles");
		panel.add(playerProfile);
		playerProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
		playerProfile.setEnabled(true);
		playerProfile.addActionListener(this);
		
		inputPlayerName(panel);

	}
	
  private void inputPlayerName(JPanel panel) {
	  
      JTextField p1username = new JTextField(10);
      JTextField p2username = new JTextField(10);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Player 1 Name:"));
      myPanel.add(p1username);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Player 2 Name:"));
      myPanel.add(p2username);
           
      
      
      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter Player's Usernames", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {
         p1.setName(p1username.getText());
         p2.setName(p2username.getText());
      }
    }
		
	public void actionPerformed(ActionEvent e){
		if(TTTbutton == e.getSource())
		{
			//TicTacToeBoard t = new TicTacToeBoard();
			//t.setVisible(true);
		}
		else if(BSbutton == e.getSource())
		{
		}
		else if(Mbutton == e.getSource())
		{
		}
		else if(Obutton == e.getSource())
		{
		}
		else if(playerProfile == e.getSource()) {
			String message = "Player 1: " + p1.getName() + 
					"\n Player 1 Score: " + p1.getScore() +
					"\n\n Player 2:" + p2.getName() +
					"\n Player 2 Score: " + p2.getScore();
					
			JOptionPane.showMessageDialog(panel,
				    message,
				    "Player Profile",
				    JOptionPane.PLAIN_MESSAGE);

		}
		
	}
	

}
