package cangreburguersLocas;

public class ScoreManager {
	private CangreburguersLocasUI ui;
	private int highScore;

	public ScoreManager(CangreburguersLocasUI cangreburguersLocasUI, int highScore) {
		this.ui = cangreburguersLocasUI;
		this.highScore = highScore;
	
	}

	public void checkHighScore(int score) {
		ui.endGame(highScore);
	}


}
