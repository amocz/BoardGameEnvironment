package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import GameEnvironment.Player;

public class TicTacToe 
{
	//Description: checks for winner
	//PreCondition: needs "OOO" or "XXX" in a row
	//PostCondtion: returns true if winner is found otherwise false if not found
	public boolean check_win(JButton[][] button) {

		//check horizontal wins
		if(button[0][0].getText().equals(button[0][1].getText()) 
				&& button[0][1].getText().equals(button[0][2].getText()) 
				&& button[0][0].getText().equals("")==false)
		{
			button[0][0].setBackground(Color.RED);
			button[0][1].setBackground(Color.RED);
			button[0][2].setBackground(Color.RED);
			return true;
		}
		else if(button[1][0].getText().equals(button[1][1].getText()) 
				&& button[1][1].getText().equals(button[1][2].getText()) 
				&& button[1][0].getText().equals("")==false)
		{
			button[1][0].setBackground(Color.RED);
			button[1][1].setBackground(Color.RED);
			button[1][2].setBackground(Color.RED);
			return true;
		}
		else if(button[2][0].getText().equals(button[2][1].getText()) 
				&& button[2][1].getText().equals(button[2][2].getText()) 
				&& button[2][0].getText().equals("")==false)
		{
			button[2][0].setBackground(Color.RED);
			button[2][1].setBackground(Color.RED);
			button[2][2].setBackground(Color.RED);
			return true;
		}
		//checks vertical win
		else if(button[0][0].getText().equals(button[1][0].getText()) 
				&& button[1][0].getText().equals(button[2][0].getText()) 
				&& button[0][0].getText().equals("")==false)
		{
			button[0][0].setBackground(Color.RED);
			button[1][0].setBackground(Color.RED);
			button[2][0].setBackground(Color.RED);
			return true;
		}
		else if(button[0][1].getText().equals(button[1][1].getText()) 
				&& button[1][1].getText().equals(button[2][1].getText()) 
				&& button[0][1].getText().equals("")==false)
		{
			button[0][1].setBackground(Color.RED);
			button[1][1].setBackground(Color.RED);
			button[2][1].setBackground(Color.RED);
			return true;
		}
		else if(button[0][2].getText().equals(button[1][2].getText()) 
				&& button[1][2].getText().equals(button[2][2].getText()) 
				&& button[0][2].getText().equals("")==false)
		{
			button[0][2].setBackground(Color.RED);
			button[1][2].setBackground(Color.RED);
			button[2][2].setBackground(Color.RED);
			return true;
		}
		//checks diagonal wins
		else if(button[0][0].getText().equals(button[1][1].getText()) 
				&& button[1][1].getText().equals(button[2][2].getText()) 
				&& button[0][0].getText().equals("")==false)
		{
			button[0][0].setBackground(Color.RED);
			button[1][1].setBackground(Color.RED);
			button[2][2].setBackground(Color.RED);
			return true;
		}
		else if(button[0][2].getText().equals(button[1][1].getText()) 
				&& button[1][1].getText().equals(button[2][0].getText()) 
				&& button[0][2].getText().equals("")==false)
		{
			button[0][2].setBackground(Color.RED);
			button[1][1].setBackground(Color.RED);
			button[2][0].setBackground(Color.RED);
			return true;
		}

		return false;

		
	}
	
	public void printWinner(int count, JFrame frame, List<Player> p) {
		if(count % 2 == 0)
		{
			playerWins(frame, p.get(0).getName().toUpperCase() + " WINS");
			p.get(0).setScore(p.get(0).getScore() + 1);
		}
		else
		{
			playerWins(frame, p.get(1).getName().toUpperCase() + " WINS");
			p.get(1).setScore(p.get(1).getScore() + 1);
		}
	}
	
	//prints out the winner
	public void playerWins(JFrame frame, String PLAYER_WIN)
	{
		JLabel playerWin = new JLabel(PLAYER_WIN);
		frame.add(playerWin, BorderLayout.NORTH);
	}
	
	public void checkForWinner(JButton[][] button, JLabel playerTurn, int count, JFrame frame, List<Player> p) {
		if(check_win(button))
		{
			//so players can't click anymore buttons when winner is announced
			for(int i = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{ 
					button[i][j].setEnabled(false);
				}
			}
			playerTurn.setVisible(false);
			
			printWinner(count, frame, p);
			
		}
	}
	
	public void checkForTie(JLabel playerTurn, JFrame frame, int count, JButton[][] button) {
		if(count == 8 && (!check_win(button)))
		{
			playerTurn.setVisible(false);
			JLabel tie = new JLabel("IT'S A TIE");
			frame.add(tie, BorderLayout.NORTH);
		}
	}
	
	public void make_move(JButton button, TicTacToeGameState gamestate, JLabel playerTurn, Player p1, Player p2) {
		TicTacToeElement elementX = new TicTacToeElement("X");
		TicTacToeElement elementO = new TicTacToeElement("O");

		if(gamestate.getPlayerTurn() == p1) {
			button.setText(elementX.getName());
			playerTurn.setText(p2.getName().toUpperCase() + "'S TURN");
			gamestate.setPlayerTurn(p2);
		}
		else {
			button.setText(elementO.getName());
			playerTurn.setText(p1.getName().toUpperCase() + "'S TURN");
			gamestate.setPlayerTurn(p1);

		}
		
		button.setFont(new Font("Arial", Font.BOLD,75));

		button.setEnabled(false);
		
		
	}
	
	
}