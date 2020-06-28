package cangreburguersLocasGame2;

public class CangreburguerPremiada extends Hamburguesa {

	public CangreburguerPremiada(CangreburguersLocasGame2 game, String prefijo) {
		super(game, prefijo);
	}

	@Override
	public int obtenerPuntos() {
		//Ganar premio
		getGame().ganarPremio(getPrefijo());
		return 5;
	}
	
	@Override
	public void caerAlPiso() {
		// No pasa nada
	}

}
