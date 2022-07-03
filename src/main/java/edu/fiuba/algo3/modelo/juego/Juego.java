package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.GeneradorTablero;
import edu.fiuba.algo3.modelo.manzana.Meta;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Juego {

	private int tamanioTablero = 3;
	private Jugador jugador;
	private Tablero tablero;

//    public Juego(Jugador unJugador, Tablero unTablero) {
//        jugador = unJugador;
//        tablero = unTablero;
//    }

	public Juego() {
	}

	public void moverJugadorEnDireccion(Direccion direccion) {
		try {
			jugador.moverEnDireccion(direccion);
		} catch (CuadraInexistenteException e) {

		}
	}

	public Esquina obtenerPosicionJugador() {
		return jugador.posicionActual();
	}

	public void spawnearJugadorEn(int fila, int columna) {
		Esquina esquinaSpawn = tablero.obtenerEsquina(fila, columna);
		jugador.spawnearVehiculoEn(esquinaSpawn);
	}

	public int cantMovJugador() {
		return this.jugador.getMovimientos();
	}

	public void correrJuego() {
		
		inicializarJuego();

//    while((!jugador.checkearEsquinaEstado().equals(new Meta()))) {
//    	 //controlador que determina donde mover el jugador.
//    }
		
		//finalizarPartida(); //guarda en un txt o ymal o json el nombre de jugador y su puntaje
	}

	private void inicializarJuego() {
		this.jugador = new Jugador(new Vehiculo(new EstadoAuto()));
		this.tablero = GeneradorTablero.generarTablero(tamanioTablero);
//		this.tablero.spawnearJugador(jugador);
		spawnearJugadorEn(0, 0);
	}
}
