package cangreburguersLocasGame2;

public class Calamardo extends Personaje {

	public Calamardo(CangreburguersLocasGame2 game) {
		super(game, "Calamardo");
	}

	@Override
	public void accion() {
		//Calamardo puede atrapar las podrida
		getGame().atraparPodridas();
		
	}
	
	@Override
	public String getNombre() {
		return "calamardo";
	}
	
	@Override
	public void anularAccion(){
		getGame().noAtraparPodridas();
	}

}
