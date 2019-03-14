package tictactoe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameEnvironment.Game;
import GameEnvironment.Player;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
public class TicTacToeBoard extends JFrame implements ActionListener
{
	public static String PLAYER_1;
	public static String PLAYER_2;
	public static int WIDTH;
	public static int HEIGHT;
	public static int COLUMN = 3;
	public static int ROW = 3;
	public static List<Player> players;
	
	private JButton[][] button;
	private JLabel playerTurn;
	
	//Description: set GUI related stuff
	//PreCondition: none
	//PostCondition: Sets size, title, JLabel, JButton, JPanel
	public TicTacToeBoard(Game gb)
	{
		super();
		HEIGHT = gb.getGrid().getHeight();
		WIDTH = gb.getGrid().getWidth();
		PLAYER_1 = gb.getPlayers().get(0).getName();
		PLAYER_2 = gb.getPlayers().get(1).getName();
		players = gb.getPlayers();
		
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setTitle(gb.getName());
		
		//top
		setLayout(new BorderLayout());
		
		//Center
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(COLUMN, ROW));
		this.add(grid, BorderLayout.CENTER);
		
		//player turn stats
		playerTurn =  new JLabel(PLAYER_1.toUpperCase() + "'S TURN" );
		add(playerTurn, BorderLayout.NORTH);
		
		//creates 9 buttons
		button = new JButton[COLUMN][ROW];		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				button[i][j] = new JButton("");
				grid.add(button[i][j]);
				button[i][j].setEnabled(true);
				button[i][j].addActionListener(this);
			}
		}
	}
	//Description: prints out an x or an o whenever user has played there turn
	//PreCondition: one of the nine buttons on the grid need to be clicked
	//PostCondition: prints out either an o or an x and if winner or tie is found
	//then winner or tie is announced at the top
	int count = 0;
	public void actionPerformed(ActionEvent e)
	{ 
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++){
				if(button[i][j] == e.getSource())
				{	
					User p = new User();
					p.make_move(button[i][j], count, playerTurn, PLAYER_1, PLAYER_2);
				}
			}
		}
		//check for winner
		TicTacToe ttt = new TicTacToe();
		ttt.checkForWinner(button, playerTurn, count, this, players);

		//check for tie
		ttt.checkForTie(playerTurn, this, count, button);

		count++;			
	}
	

	

	
			 
}

