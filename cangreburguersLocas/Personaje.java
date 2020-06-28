package cangreburguersLocas;

public class Personaje {
	private CangreburguersLocasGame game;
	private String nombre;
	private Hamburguesa hamburguesa;
	private int columna = 2;
	private boolean vivo = false;

	public Personaje(String nombre, CangreburguersLocasGame game) {
		this.nombre = nombre;
		this.game = game;
	}

	public void setHamburguesa(Hamburguesa hamburguesa) {
		this.hamburguesa = hamburguesa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setComida(Hamburguesa comida) {
		this.hamburguesa = comida;
	}

	public void moverse(boolean izquierda) {
		game.borrarPersonaje(columna);

		if (izquierda && columna > 0) {
			columna--;
		} else if (!izquierda && columna < 4) {
			columna++;
		}
		game.dibujarPersonaje(columna);
	}

	public void morir() {
		vivo = false;
	}

	public void vivir() {
		vivo = true;
	}

	public int getColumna() {
		return columna;
	}

	public boolean isVivo() {
		return vivo;
	}

}
