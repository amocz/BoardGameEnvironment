package tictactoe;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import GameEnvironment.Player;

public class User {

	
	
	public void make_move(JButton button, int count, JLabel playerTurn, String p1, String p2) {
		if(count % 2 == 0) {
			button.setText("X");
			playerTurn.setText(p2.toUpperCase() + "'S TURN");
		}
		else {
			button.setText("O");
			playerTurn.setText(p1.toUpperCase() + "'S TURN");
		}
		
		button.setFont(new Font("Arial", Font.BOLD,75));
		//button[i].setForeground(Color.RED);

		button.setEnabled(false);
		
		
	}
}
