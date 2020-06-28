package cangreburguersLocas;

import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;
import edu.upb.lp.progra.adapterFiles.UI;
import cangreburguersLocas.CangreburguersLocasGame;

public class CangreburguersLocasUI implements UI {
	private AndroidGameGUI gui;
	private boolean haEmpezado = false;

	private CangreburguersLocasGame game = new CangreburguersLocasGame(this);
	private cangreburguersLocas.ScoreManager scoreManager;

	public CangreburguersLocasUI(AndroidGameGUI gui) {
		this.gui = gui;
		int highScore = gui.retrieveInt("HighScore");
		scoreManager = new cangreburguersLocas.ScoreManager(this, highScore);
	}

	public void onButtonPressed(String name) {
		if (name.equals("Start")) {
			game.comenzarJuego();
			haEmpezado = true;

		} else if (name.equals("Restart")) {
			if (haEmpezado == true) {
				scoreManager.checkHighScore(game.getMisPuntos());
				game.comenzarJuego();
				game.dibujarPersonaje(2);
			}
		}
		updateInterface();
	}

	public void onCellPressed(int vertical, int horizontal) {
		if (horizontal == 0) {
			game.izquierda();
		} else if (horizontal == 4) {
			game.derecha();
		}
	}

	public void initialiseInterface() {
		gui.configureGrid(5, 5, 0, 0, 20);
		gui.setBottomSectionProportion(0.2);
		for (int v = 0; v < 5; v++) {
			for (int h = 0; h < 5; h++) {
				gui.setImageOnCell(v, h, ("cocina" + v) + h);
			}

		}
		gui.setImageOnCell(4, 2, ("bobesponja" + 4) + 2);

		gui.addButton("Start", 20, 50);
		gui.addButton("Restart", 20, 50);
		gui.addTextField("Score", "Score: " + game.getMisPuntos(), 20, 50);
		updateInterface();
	}

	public void updateInterface() {
		gui.updateTextField("Score", "Score: " + game.getMisPuntos());

	}

	public void borrarPersonaje(int columna) {
		gui.setImageOnCell(4, columna, ("cocina" + 4) + columna);
	}

	public void dibujarPersonaje(int columna) {
		gui.setImageOnCell(4, columna, ("bobesponja" + 4) + columna);

	}

	public void borrarHamburguesa(int fila, int columna) {
		gui.setImageOnCell(fila, columna, ("cocina" + fila + "" + columna));

	}

	public void dibujarHamburguesa(int fila, int columna) {
		gui.setImageOnCell(fila, columna, ("cb" + fila + "" + columna));
	}


	public void showLongMessage(String message) {
		gui.reproduceSound("ping");
		gui.showTemporaryMessage(message, true);
	}

	public void endGame(int highScore) {
		gui.reproduceSound("ping");
		gui.reproduceSound("ping");
		game = new CangreburguersLocasGame(this);
		updateInterface();
	}

	public void showFinalMessage() {
		gui.showTemporaryMessage("Game ended\nYour score: " + game.getUltimosPuntos() + " (Spongebob)", true);
	}

}
