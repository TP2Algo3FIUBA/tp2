package edu.fiuba.algo3.modelo.juego;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.*;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.GeneradorTablero;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Juego {

	// private MapView view;
	private int tamanioTablero = 3;
	private Jugador jugador;
	private Tablero tablero;
	private String nombreJugador;

	public Juego(Jugador jugador, Tablero tablero) {
		this.tablero = tablero;
		this.jugador = jugador;
	}

	public void moverJugadorEnDireccion(Direccion direccion) {
		try {
			this.jugador.moverEnDireccion(direccion);
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
	}

	private void inicializarJuego() {
		this.jugador = new Jugador(new Vehiculo(new EstadoAuto()));
		this.tablero = GeneradorTablero.generarTablero(tamanioTablero);
//		this.tablero.spawnearJugador(jugador);
		spawnearJugadorEn(0, 0);
	}

	public void finalizarPartida() {
		System.out.println("Guardando puntajes");
		Map<String, Object> dataJugador = new HashMap<>();
		dataJugador.put("Jugador", this.nombreJugador);
		dataJugador.put("Puntaje", this.jugador.getMovimientos());
		PrintWriter writer;
		Yaml yaml = new Yaml();

		try {
			writer = new PrintWriter(new File("resources/puntajes.yml").getAbsolutePath());
			yaml.dump(dataJugador, writer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Esquina obtenerEsquina(int i, int i1) {
		return tablero.obtenerEsquina(i, i1);
	}

	public boolean Ganado() {
		return jugador.posicionActual().checkearEstado() instanceof Meta;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getNombreJugador() {
		return this.nombreJugador;
	}

	public void reiniciar() {
		this.spawnearJugadorEn(0, 0);
		this.jugador.setPosition(new Position(0, 0));
		this.jugador.resetearMovimientos();
		this.jugador.notifyObservers();
	}
}
