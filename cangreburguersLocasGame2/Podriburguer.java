package cangreburguersLocasGame2;

public class Podriburguer extends Hamburguesa {

	public Podriburguer(CangreburguersLocasGame2 game, String prefijo) {
		super(game, "pb");
	}

	@Override
	public int obtenerPuntos() {
		if (getGame().getAtraparPodridas()) {
			return 5;
		} else {
			return -5;
		}
	}

	@Override
	public void caerAlPiso() {
		// No pasa nada
		getGame().comenzarJuego();
		
		
	}

}
