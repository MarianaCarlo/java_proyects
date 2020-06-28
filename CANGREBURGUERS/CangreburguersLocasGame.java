package cangreburguersLocas;

public class CangreburguersLocasGame {
	private CangreburguersLocasUI ui;
	private Personaje personaje;
	private Hamburguesa hamburguesa;
	private MovimientoAutomatico temporizador;
	private int misPuntos;
	private int ultimosPuntos;

	public CangreburguersLocasGame(CangreburguersLocasUI ui) {
		this.ui = ui;
		personaje = new Personaje("bobesponja", this);
		hamburguesa = new Hamburguesa(this, personaje);
		personaje.setHamburguesa(hamburguesa);
		temporizador = new MovimientoAutomatico();
		misPuntos = 0;
	}

	public void borrarPersonaje(int columna) {
		ui.borrarPersonaje(columna);
	}

	public void izquierda() {
		if (personaje.isVivo()) {
			personaje.moverse(true);
		}
	}

	public void derecha() {
		if (personaje.isVivo()) {
			personaje.moverse(false);
		}
	}

	public void dibujarPersonaje(int columna) {
		ui.dibujarPersonaje(columna);
	}

	public void borrarHamburguesa(int fila, int columna) {
		ui.borrarHamburguesa(fila, columna);
	}

	public void dibujarHamburguesa(int fila, int columna) {
		ui.dibujarHamburguesa(fila, columna);
	}

	public void comenzarJuego() {
		personaje.vivir();
		ui.dibujarHamburguesa(hamburguesa.getFila(), hamburguesa.getColumna());
		temporizador.iniciarMovimientoAutomatico(this);
		misPuntos = 0;

	}

	public boolean personajeVivo() {
		return personaje.isVivo();
	}

	public void avanzarHamburguesa() {
		if (hamburguesa.getFila() == 4) {
			borrarHamburguesa(hamburguesa.getFila(), hamburguesa.getColumna());
			personaje.morir();
			this.borrarPersonaje(personaje.getColumna());
			ultimosPuntos = misPuntos;
			ui.showFinalMessage();

		} else if (hamburguesa.getFila() == 3 && personaje.getColumna() == hamburguesa.getColumna()) {
			hamburguesa.reinicializarCoordenadas();
			misPuntos = misPuntos + 5;
			ui.updateInterface();
		} else {
			hamburguesa.caer();
		}
	}

	public int columnaHamburguesa() {
		return hamburguesa.getColumna();
	}

	public int getMisPuntos() {
		return misPuntos;
	}

	public int getUltimosPuntos() {
		return ultimosPuntos;
	}
}
