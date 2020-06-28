package cangreburguersLocas;

public class ScoreManager {
	private int score = 0;
	private CangreburguersLocasUI ui;
	private CangreburguersLocasGame game;
	private int highScore;

	public ScoreManager(CangreburguersLocasUI cangreburguersLocasUI, int highScore, CangreburguersLocasGame game) {
		this.ui = cangreburguersLocasUI;
		this.highScore = highScore;
		this.game = game;
	}

	public void checkHighScore(int score) {
		ui.endGame(highScore);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
