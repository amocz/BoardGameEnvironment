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
public class TicTacToeBoard extends Game implements ActionListener
{
	private static String PLAYER_1;
	private static String PLAYER_2;
	private static int WIDTH;
	private static int HEIGHT;
	private static int COLUMN = 3;
	private static int ROW = 3;
	private static List<Player> players;
	
	private JButton[][] button;
	private JLabel playerTurn;
	private JFrame frame;
	private TicTacToeGameState gamestate;
	
	//Description: set GUI related stuff
	//PreCondition: none
	//PostCondition: Sets size, title, JLabel, JButton, JPanel
	public TicTacToeBoard(List<Player> player)
	{
		super("Tic Tac Toe", player);
		frame = new JFrame();
		HEIGHT = 500;
		WIDTH = 500;
		PLAYER_1 = player.get(0).getName();
		PLAYER_2 = player.get(1).getName();
		players = player;
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setTitle("Tic Tac Toe");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		
		//top
		frame.setLayout(new BorderLayout());
		
		//Center
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(COLUMN, ROW));
		frame.add(grid, BorderLayout.CENTER);
		
		//player turn stats
		playerTurn =  new JLabel(PLAYER_1.toUpperCase() + "'S TURN" );
		frame.add(playerTurn, BorderLayout.NORTH);
		
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
		gamestate = new TicTacToeGameState(players.get(0));
	
	}
	//Description: prints out an x or an o whenever user has played there turn
	//PreCondition: one of the nine buttons on the grid need to be clicked
	//PostCondition: prints out either an o or an x and if winner or tie is found
	//then winner or tie is announced at the top
	int count = 0;
	public void actionPerformed(ActionEvent e)
	{ 
		Player A = players.get(0);
		Player B = players.get(1);
		TicTacToe ttt = new TicTacToe();

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++){
				if(button[i][j] == e.getSource())
				{						
					ttt.make_move(button[i][j], gamestate, playerTurn, A,B);
				}
			}
		}
		//check for winner
		ttt.checkForWinner(button, playerTurn, count, frame, players);

		//check for tie
		ttt.checkForTie(playerTurn, frame, count, button);
		count++;
	}
			 
}

