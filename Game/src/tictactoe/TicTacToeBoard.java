package tictactoe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameEnvironment.Player;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TicTacToeBoard extends JFrame implements ActionListener
{
	public static final String PLAYER_1 = "PLAYER 1 WON";
	public static final String PLAYER_2 = "PLAYER 2 WON";
	public static final String PLAYER_1_TURN = "PLAYER 1 TURN";
	public static final String PLAYER_2_TURN = "PLAYER 2 TURN";
	public static final String TIE = "IT'S A TIE";
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int COLUMN = 3;
	public static final int ROW = 3;
	
	private JButton[][] button;
	private JLabel playerTurn;
	
	//Description: set GUI related stuff
	//PreCondition: none
	//PostCondition: Sets size, title, JLabel, JButton, JPanel
	public TicTacToeBoard()
	{
		super();
		
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		this.setTitle("Tic Tac Toe");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		//top
		setLayout(new BorderLayout());
		
		//Center
		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(COLUMN, ROW));
		this.add(grid, BorderLayout.CENTER);
		
		//player turn stat
		playerTurn =  new JLabel(PLAYER_1_TURN);
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
					p.make_move(button[i][j], count, playerTurn);
				}
			}
		}
		//check for winner
		TicTacToe ttt = new TicTacToe();
		ttt.checkForWinner(button, playerTurn, count, this);

		//check for tie
		ttt.checkForTie(playerTurn, this, count, button);

		count++;			
	}
	

	

	
			 
}

