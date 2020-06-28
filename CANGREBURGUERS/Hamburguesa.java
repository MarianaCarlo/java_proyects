package cangreburguersLocas;

import java.util.Random;

public class Hamburguesa {
	private CangreburguersLocasGame game;
	private Personaje personaje;
	private int fila = 0;
	private int columna = 0;

	public Hamburguesa(CangreburguersLocasGame game, Personaje personaje) {
		this.personaje = personaje;
		this.game = game;
	}

	public void reinicializarCoordenadas() {
		game.borrarHamburguesa(fila, columna);
		this.fila = 0;
		Random rnd = new Random();
		this.columna = rnd.nextInt(5);

		game.dibujarHamburguesa(fila, columna);
	}

	public void caer() {
		game.borrarHamburguesa(fila, columna);
		fila++;
		game.dibujarHamburguesa(fila, columna);
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return this.columna;
	}

}
