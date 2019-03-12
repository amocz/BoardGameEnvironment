package game;


public class Player {
	private String name;
	private int score;
	
	Player(){
		this.name = "";
		this.score = 0;
	}

	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	} 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
