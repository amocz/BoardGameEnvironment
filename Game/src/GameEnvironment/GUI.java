package GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.border.EmptyBorder;

import Memory.MemoryGUI;
import OthelloGui.OthelloGui;
import tictactoe.TicTacToeBoard;

import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;

public class GUI extends JFrame implements ActionListener
{	
	private JButton TTTbutton;
	private JButton BSbutton;
	private JButton Mbutton;
	private JButton Obutton;
	private JButton playerProfile;
	private JPanel panel;
	private Player p1, p2;
	List<Player> players = new ArrayList<Player>();
	ArrayList<String> logPlayer = new ArrayList<String>();
	
	
	//Description: set GUI related stuff
	public GUI(ArrayList<String> logPlayer)
	{
		super();
		this.logPlayer = logPlayer;
		this.setSize(500, 500);
		this.setResizable(false);
		this.setTitle("Game Environment");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

			
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
		
		this.addWindowListener( new WindowAdapter()
		 {
		   public void windowClosing(WindowEvent e)
		    {
			   updateLogToFile();  
		    }
		  });

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
         p1 = new Player(p1username.getText());
         p2 = new Player(p2username.getText());
         players.add(p1);
         players.add(p2);
         addPlayerToLog(p1username.getText());
         addPlayerToLog(p2username.getText());

      }
    }
  
  	public void addPlayerToLog(String pname) {
  		boolean isNameFound = false;
  		for(int i = 0; i< logPlayer.size(); i++) {
  			String name = logPlayer.get(i).substring( 0, logPlayer.get(i).indexOf(","));
  			if(name.equals(pname)) {
  				isNameFound = true;
  			}
  		}
  		if(!isNameFound) {
  			logPlayer.add(pname + ",0");
  		}
  	}
  	
  	public void updateLogToFile() {
  		
  		int overallp1Score =0;
		int overallp2Score=0;
		for(int i = 0; i< logPlayer.size(); i++) {
  			String name = logPlayer.get(i).substring( 0, logPlayer.get(i).indexOf(","));
  			if(name.equals(p1.getName())) {
  				overallp1Score = Integer.parseInt(logPlayer.get(i).substring(logPlayer.get(i).indexOf(",") + 1));
  				overallp1Score = overallp1Score + p1.getScore();
  				logPlayer.set(i, name + "," + Integer.toString(overallp1Score));
  			}
  			if(name.equals(p2.getName())) {
  				overallp2Score = Integer.parseInt(logPlayer.get(i).substring(logPlayer.get(i).indexOf(",") + 1));
  				overallp2Score = overallp2Score + p2.getScore();
  				logPlayer.set(i, name + "," + Integer.toString(overallp2Score));

  			}
  		}
		
		try {
			FileWriter fw = new FileWriter("gameLog.txt");
			Writer output = new BufferedWriter(fw);
			for(int i = 0; i < logPlayer.size(); i++) {
				output.write(logPlayer.get(i) + "\n");
				if(i == logPlayer.size()) {
					output.write(System.getProperty( "line.separator" ));
				}
			}
			output.close();
		}catch(Exception e){
			System.out.println("exception caught");
		}
  	}

		
	public void actionPerformed(ActionEvent e){
		if(TTTbutton == e.getSource())
		{
			new TicTacToeBoard(players);
		}
		else if(BSbutton == e.getSource())
		{
		}
		else if(Mbutton == e.getSource())
		{
		    new MemoryGUI(players);
		}
		else if(Obutton == e.getSource())
		{
			new OthelloGui(players);
		}
		else if(playerProfile == e.getSource()) {
			int overallp1Score =0;
			int overallp2Score=0;
			for(int i = 0; i< logPlayer.size(); i++) {
	  			String name = logPlayer.get(i).substring( 0, logPlayer.get(i).indexOf(","));
	  			if(name.equals(p1.getName())) {
	  				overallp1Score = Integer.parseInt(logPlayer.get(i).substring(logPlayer.get(i).indexOf(",") + 1));
	  			}
	  			if(name.equals(p2.getName())) {
	  				overallp2Score = Integer.parseInt(logPlayer.get(i).substring(logPlayer.get(i).indexOf(",") + 1));
	  			}
	  		}
	  		
			String message = "Player 1: " + p1.getName() + 
					"\nPlayer 1 Score(Now): " + p1.getScore() +
					"\nPlayer 1 Overall Score(Saved): " + overallp1Score + 
					"\n\nPlayer 2:" + p2.getName() +
					"\nPlayer 2 Score(Now): " + p2.getScore() + 
					"\nPlayer 2 Overall Score(Saved): " + overallp2Score;
					
			JOptionPane.showMessageDialog(panel,
				    message,
				    "Player Profile",
				    JOptionPane.PLAIN_MESSAGE);

		}
	}
}

