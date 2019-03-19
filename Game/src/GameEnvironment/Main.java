package GameEnvironment;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) 
	{
		ArrayList<String> logPlayer = new ArrayList<String>();
		String line;

		try {
			BufferedReader input = new BufferedReader(new FileReader("gameLog.txt"));
			if(!input.ready()) {
				throw new IOException();
			}
			while((line = input.readLine()) != null) {
				logPlayer.add(line);
			}
			input.close();
		}catch(IOException e) {
			System.out.println();
		}
		
//		for(int i = 0; i < logPlayer.size(); i++) {
//			System.out.println(logPlayer.get(i));
//		}
			
		GUI g = new GUI(logPlayer);
		g.setVisible(true);
		

	}
}
