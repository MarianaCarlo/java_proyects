package cangreburguersLocasGame2;
import cangreburguersLocasGame2.ElCrustaceoCascarudoYaNoTieneCangreburguersException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CangreburguersLocasGame2 {
	private CangreburguersLocas2UI ui;
	private Personaje personajeEnPantalla;
	private Hamburguesa hamburguesaEnPantalla;
	private int cantidadDeHamburguesas;
	private Queue<Hamburguesa> cola;
	private MovimientoAutomatico2 temporizador;
	private int score;
	private HashSet<String> set = new HashSet<String>();
	private boolean invulnerabilidad = false;
	private boolean duplicarPuntos = false;
	private boolean atraparPodridas = false;
	private int scoreParaDesactivarSuperpoder = Integer.MAX_VALUE;
	private int scoreParaReactivarBotonDeSuperpoder = Integer.MAX_VALUE;

	public CangreburguersLocasGame2(CangreburguersLocas2UI ui) {
		this.ui = ui;
		temporizador = new MovimientoAutomatico2();
		score = 0;
		crearCalamardo();
		crearBobEsponja();
		crearPatricio();
		crearCola();
	}

	public void crearCalamardo() {
		this.personajeEnPantalla = new Calamardo(this);
	}

	public void crearBobEsponja() {
		this.personajeEnPantalla = new BobEsponja(this);
	}

	public void crearPatricio() {
		this.personajeEnPantalla = new Patricio(this);
	}
	
	private Colorburguer crearColorBurguer() {
		Random rnd = new Random();
		int i = rnd.nextInt(5);
		String[] colores = { "v", "a", "r", "n", "b" };
		return new Colorburguer(this, colores[i]);
	}

	private CangreburguerPremiada crearCangrePremiada() {
		Random rnd = new Random();
		int i = rnd.nextInt(4);
		String[] personajes = { "dc", "g", "cp", "sm" };
		return new CangreburguerPremiada(this, personajes[i]);
	}

	public void borrarPersonaje(int columna) {
		ui.borrarPersonaje(columna);
	}

	public void dibujarPersonaje(int columna) {
		ui.dibujarPersonaje(columna, personajeEnPantalla.getNombre());
	}

	public void borrarHamburguesaEnPantalla(int fila, int columna) {
		ui.borrarHamburguesaEnPantalla(fila, columna);
	}

	public void dibujarHamburguesa(String prefijo, int fila, int columna) {
		ui.dibujarHamburguesaEnPantalla(prefijo, fila, columna);
	}

	public int columnaHamburguesa() {
		return hamburguesaEnPantalla.getColumna();
	}

	public int getScore() {
		return score;
	}
	public void izquierda() {
		if (personajeEnPantalla.isVivo()) {
			personajeEnPantalla.moverse(true);
		}
	}

	public void derecha() {
		if (personajeEnPantalla.isVivo()) {
			personajeEnPantalla.moverse(false);
		}
	}

	public boolean personajeVivo() {
		return personajeEnPantalla.isVivo();
	}

	public void comenzarJuego() {
		personajeEnPantalla.vivir();
		//dibujarPersonaje(2);
		hamburguesaEnPantalla = cola.poll();
		ui.dibujarHamburguesaEnPantalla(hamburguesaEnPantalla.getPrefijo(), hamburguesaEnPantalla.getFila(),
				hamburguesaEnPantalla.getColumna());
		temporizador.iniciarMovimientoAutomatico(this);
		//score = 0;
		

	}

	public void avanzarHamburguesa() throws ElCrustaceoCascarudoYaNoTieneCangreburguersException{
		if (cantidadDeHamburguesas <= 304) {
			if (hamburguesaEnPantalla.getFila() == 3
					&& personajeEnPantalla.getColumna() == hamburguesaEnPantalla.getColumna()) {
				borrarHamburguesaEnPantalla(hamburguesaEnPantalla.getFila(), hamburguesaEnPantalla.getColumna());
				if (cola.size() >= 1) {
					hamburguesaEnPantalla = cola.poll();
				} else {
					throw new ElCrustaceoCascarudoYaNoTieneCangreburguersException();
				}
				dibujarHamburguesa(hamburguesaEnPantalla.getPrefijo(), hamburguesaEnPantalla.getFila(),
						hamburguesaEnPantalla.getColumna());
				score = score + hamburguesaEnPantalla.obtenerPuntos();
				if (score >= scoreParaDesactivarSuperpoder) {
					personajeEnPantalla.anularAccion();
					scoreParaDesactivarSuperpoder = Integer.MAX_VALUE;
				} else if (score >= scoreParaReactivarBotonDeSuperpoder) {
					ui.activarBotonSuperpoder();
					scoreParaReactivarBotonDeSuperpoder = Integer.MAX_VALUE;
				}
				ui.updateInterface();
			} else {
				hamburguesaEnPantalla.caer();
			}
		} 

	}


	public void crearCola() {
		Random r = new Random();
		cola = new LinkedList<Hamburguesa>();
		cantidadDeHamburguesas = 304;
			for (int c = 0; c <= cantidadDeHamburguesas / 6; c++) {
				cola.offer(new Cangreburguer(this));
			}
			for (int c = 0; c <= cantidadDeHamburguesas / 3; c++) {
				double a = r.nextDouble();
				if (a < 0.5) {
					cola.offer(new Cangreburguer(this));
				} else {
					cola.offer(crearColorBurguer());
				}
			}
			for (int c = 0; c <= cantidadDeHamburguesas; c++) {
				double a = r.nextDouble();
				if (a < 0.3) {
					cola.offer(new Cangreburguer(this));
				} else if (a < 0.2) {
					cola.offer(crearColorBurguer());
				} else if (a < 0.2) {
					cola.offer(crearCangrePremiada());
				} else {
					cola.offer(new Podriburguer(this, "pb"));
				}
			} 
	}

	public void cayoAlPiso() {
		if (!invulnerabilidad) {
			personajeEnPantalla.morir();
			this.borrarPersonaje(personajeEnPantalla.getColumna());
			ui.showMessage("Perdiste");
		} else {
			hamburguesaEnPantalla = cola.poll();
			dibujarHamburguesa(hamburguesaEnPantalla.getPrefijo(), hamburguesaEnPantalla.getFila(),
					hamburguesaEnPantalla.getColumna());
		}
	}

	public void detenerMovimiento() {
		temporizador.detenerMovimientoAutomatico();
	}
	
	public void continuarMovimiento() {
		temporizador.continuarMovimientoAutomatico();
	}

	public void ganarPremio(String prefijo) {
		set.add(prefijo);
		if (set.size() == 4) {
			detenerMovimiento();
			ganarJuego();
		}
	}

	public void invulnerabilidad() {
		invulnerabilidad = true;
	}
	
	public void noInvulnerable() {
		invulnerabilidad = false;
	}

	public boolean getDuplicarPuntos() {
		return duplicarPuntos;
	}

	public void duplicarPuntos() {
		duplicarPuntos = true;
	}
	
	public void noDuplicarPuntos() {
		duplicarPuntos = false;
	}

	public void superpoder() {
		personajeEnPantalla.accion();
		scoreParaDesactivarSuperpoder  = score + 50;
		scoreParaReactivarBotonDeSuperpoder  = score + 100;
	}

	public void atraparPodridas() {
		atraparPodridas = true;
	}
	
	public void noAtraparPodridas() {
		atraparPodridas = false;
	}
	
	public boolean getAtraparPodridas() {
		return atraparPodridas;
	}
	
	public void ganarJuego() {
		ui.showMessage("ganaste");
	}
	
}
