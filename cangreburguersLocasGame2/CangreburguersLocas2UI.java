package cangreburguersLocasGame2;

import edu.upb.lp.progra.adapterFiles.UI;
import edu.upb.lp.progra.adapterFiles.AndroidGameGUI;

import cangreburguersLocasGame2.CangreburguersLocasGame2;

public class CangreburguersLocas2UI implements UI {
	private AndroidGameGUI gui;
	private CangreburguersLocasGame2 game = new CangreburguersLocasGame2(this);
	boolean haEmpezado = false;
	public CangreburguersLocas2UI(AndroidGameGUI gui) {
		this.gui = gui;
	}

	@Override
	public void onButtonPressed(String name) {
		if (name.equals("Elegir Personaje")) {
			gui.removeAllButtons();
			gui.addButton("Calamardo", 20, 50);
			gui.addButton("Bob Esponja", 20, 50);
			gui.addButton("Patricio", 20, 50);

		} else if (name.equals("Calamardo")) {
			gui.setImageOnCell(4, 2, ("calamardo" + 4) + 2);
			game.crearCalamardo();
			gui.removeAllButtons();
			gui.addButton("Start", 20, 50);
			gui.addButton("SuperPoder", 20, 50);

		} else if (name.equals("Bob Esponja")) {
			gui.setImageOnCell(4, 2, ("bobesponja" + 4) + 2);
			game.crearBobEsponja();
			gui.removeAllButtons();
			gui.addButton("Start", 20, 50);
			gui.addButton("SuperPoder", 20, 50);

		} else if (name.equals("Patricio")) {
			gui.setImageOnCell(4, 2, ("patricio" + 4) + 2);
			game.crearPatricio();
			gui.removeAllButtons();
			gui.addButton("Start", 20, 50);
			gui.addButton("SuperPoder", 20, 50);

		} else if (name.equals("Start")) {
			game.comenzarJuego();
			gui.removeButton("Start");
			gui.addButton("Restart", 20, 50);
			haEmpezado = true;
		
		} else if (name.equals("Restart")) {
			gui.removeTextField("ganaste");
			gui.removeTextField("Perdiste");
			gui.removeAllButtons();
			gui.addButton("Elegir Personaje", 20, 50);
			game.detenerMovimiento();
			game = new CangreburguersLocasGame2(this);
			initialiseInterface();

		} else if (name.equals("SuperPoder")) {
			game.superpoder();
			//gui.reproduceSound("intro");
			gui.removeButton("SuperPoder");
		}
		updateInterface();
	}

	@Override
	public void onCellPressed(int vertical, int horizontal) {
		if (horizontal == 0) {
			game.izquierda();
		} else if (horizontal == 4) {
			game.derecha();
		}
	}

	@Override
	public void initialiseInterface() {
		gui.configureGrid(5, 5, 0, 0, 20);
		gui.setBottomSectionProportion(0.2);
		for (int v = 0; v < 5; v++) {
			for (int h = 0; h < 5; h++) {
				gui.setImageOnCell(v, h, ("cocina" + v) + h);
			}

		}
		gui.addTextField("Score", "Score: " + game.getScore(), 20, 50);

		if (!game.personajeVivo()) {
			gui.addButton("Elegir Personaje", 20, 50);

		} else {
			gui.addButton("Start", 20, 50);
			gui.addButton("Restart", 20, 50);
			gui.addButton("SuperPoder", 20, 50);
		}

		updateInterface();
	}

	public void updateInterface() {
		gui.updateTextField("Score", "Score: " + game.getScore());
	}

	public void activarBotonSuperpoder() {
		gui.addButton("SuperPoder", 20, 50);
	}

	public void borrarPersonaje(int columna) {
		gui.setImageOnCell(4, columna, ("cocina" + 4) + columna);
	}

	public void dibujarPersonaje(int columna, String imagen) {
		gui.setImageOnCell(4, columna, (imagen + 4) + columna);
	}

	public void borrarHamburguesaEnPantalla(int fila, int columna) {
		gui.setImageOnCell(fila, columna, ("cocina" + fila + "" + columna));

	}

	public void dibujarHamburguesaEnPantalla(String prefijo, int fila, int columna) {
		gui.setImageOnCell(fila, columna, ("cb" + prefijo + fila + "" + columna));
	}

	public void showMessage(String message) {
		gui.showTemporaryMessage(message, true);
	}
	
}
