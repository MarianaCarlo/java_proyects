package cangreburguersLocasGame2;

public class Patricio extends Personaje {

	public Patricio(CangreburguersLocasGame2 game) {
		super(game, "Patricio");
	}

	@Override
	public void accion() {
		// Si deja caer hamburguesas no pierde
		getGame().invulnerabilidad();
	}
	
	@Override
	public String getNombre() {
		return "patricio";
	}
	
	@Override
	public void anularAccion(){
		getGame().noInvulnerable();
	}

}
