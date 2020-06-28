package cangreburguersLocas;

import android.os.Handler;

public class MovimientoAutomatico implements Runnable {

	private Handler botonAutomatico;
	private CangreburguersLocasGame game;

	public MovimientoAutomatico() {
		botonAutomatico = new Handler();
	}

	public void iniciarMovimientoAutomatico(CangreburguersLocasGame game) {
		this.game = game;
		botonAutomatico.postDelayed(this, 200);
	}

	public void run() {
		if (game.personajeVivo()) {
			game.avanzarHamburguesa();
			botonAutomatico.postDelayed(this, 200);
		}
	}

}
