package cangreburguersLocasGame2;

public class Cangreburguer extends Hamburguesa {

	public Cangreburguer(CangreburguersLocasGame2 game) {
		super(game,"");
	}
	
	@Override
	public int obtenerPuntos() {
		return 5;
	}
}
