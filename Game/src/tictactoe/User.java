package tictactoe;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import GameEnvironment.Player;

public class User {

	
	public void make_move(JButton button, int count, JLabel playerTurn) {
		if(count % 2 == 0) {
			button.setText("X");
			playerTurn.setText("PLAYER 2 TURN");
		}
		else {
			button.setText("O");
			playerTurn.setText("PLAYER 1 TURN");
		}
		
		button.setFont(new Font("Arial", Font.BOLD,75));
		//button[i].setForeground(Color.RED);

		button.setEnabled(false);
		
		
	}
}
