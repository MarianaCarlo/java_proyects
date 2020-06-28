package cangreburguersLocasGame2;

import java.util.Random;

public abstract class Hamburguesa {
	private CangreburguersLocasGame2 game;
	private int fila = 0;
	private int columna;
	private String prefijo;

	public Hamburguesa(CangreburguersLocasGame2 game, String prefijo) {
		this.game = game;
		this.prefijo = prefijo;
		Random rnd = new Random();
		columna = rnd.nextInt(5);
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return this.columna;
	}

	public CangreburguersLocasGame2 getGame() {
		return game;
	}

	public void caer() {
		game.borrarHamburguesaEnPantalla(fila, columna);
		if (fila < 4) {
			fila++;
			game.dibujarHamburguesa(prefijo, fila, columna);
		} else {
			caerAlPiso();
		}
	}

	public void caerAlPiso() {
		game.cayoAlPiso();
	}

	public String getPrefijo() {
		return prefijo;
	}

	public abstract int obtenerPuntos();

}
