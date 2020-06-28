package cangreburguersLocasGame2;

public class BobEsponja extends Personaje {

	public BobEsponja(CangreburguersLocasGame2 game) {
		super(game, "BobEsponja");
	}
	
	@Override
	public void accion() {
		//Duplica los puntos de las cangreburguers de colores
		getGame().duplicarPuntos();
	}
	
	@Override
	public String getNombre() {
		return "bobesponja";
	}
	
	@Override
	public void anularAccion(){
		getGame().noDuplicarPuntos();
	}

}
