package cangreburguersLocasGame2;

public abstract class Personaje {
	private CangreburguersLocasGame2 game;
	private String nombre;
	private int columna = 2;
	private boolean vivo = false;
	
	public Personaje(CangreburguersLocasGame2 game, String nombre) {
		this.game = game;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getColumna() {
		return columna;
	}

	public boolean isVivo() {
		return vivo;
	}
	
	
	public CangreburguersLocasGame2 getGame() {
		return game;
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
	
	public abstract void accion();

	public abstract void anularAccion();
	
}
