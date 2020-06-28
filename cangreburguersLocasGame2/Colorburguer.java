package cangreburguersLocasGame2;

public class Colorburguer extends Hamburguesa {
//	private boolean seDuplica;

	public Colorburguer(CangreburguersLocasGame2 game, String prefijo) {
		super(game, prefijo);
	}

	@Override
	public int obtenerPuntos() {
		if (getGame().getDuplicarPuntos()) {
			return 20;
		} else {
			return 10;
		}
		//ICPC: return = seDuplica ? 20 : 10;
	}
}
