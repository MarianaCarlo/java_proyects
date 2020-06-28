package cangreburguersLocasGame2;

import android.os.Handler;

public class MovimientoAutomatico2 implements Runnable {
	
	private Handler botonAutomatico;
	private CangreburguersLocasGame2 game;
	private boolean started = false;

	public MovimientoAutomatico2() {
		botonAutomatico = new Handler();
	}
	
	public void iniciarMovimientoAutomatico(CangreburguersLocasGame2 game) {
		if (!started) {
			this.game = game;
			botonAutomatico.postDelayed(this, 300);
			started = true;
		}
	}
	
	public void continuarMovimientoAutomatico() {
		//botonAutomatico.postDelayed(this, 300);
		started = true;
	}

	public void detenerMovimientoAutomatico() {
		started = false;
	}
	
	public void continuarMovimiento() {
		started = true;
	}
	
	@Override
	public void run() {
		if (started && game.personajeVivo()) {
				try {
					game.avanzarHamburguesa();
				} catch (ElCrustaceoCascarudoYaNoTieneCangreburguersException e) {
					game.ganarJuego();
				}
			botonAutomatico.postDelayed(this, 300);
		}
	}
	
}
