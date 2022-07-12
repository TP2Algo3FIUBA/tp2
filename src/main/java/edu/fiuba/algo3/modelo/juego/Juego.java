package edu.fiuba.algo3.modelo.juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
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
	
	public void obtenerHighScores() {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File("resources/puntajes.yml").getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Yaml yaml = new Yaml();
		Map<String, Object> data = yaml.load(inputStream);
		System.out.println(data);
	}

	public void finalizarPartida() {
		System.out.println("Guardando puntajes");
		Map<String, Object> dataJugadores = new HashMap<>();
		Map<String, Object> dataJugador = new HashMap<>();
		Map<String, Object> dataMovimientos = new HashMap<>();
		
		dataMovimientos.put("Puntaje", this.jugador.getMovimientos());
		dataJugador.put(this.nombreJugador, dataMovimientos);
		dataJugadores.put("Jugadores", dataJugador);
		
		PrintWriter writer;
		
		DumperOptions options = new DumperOptions();
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    options.setPrettyFlow(true);
    Yaml yaml = new Yaml(options);
    Yaml previousYaml = new Yaml();	

		try {
			InputStream file = new FileInputStream(new File("resources/puntajes.yml").getAbsolutePath());
			writer = new PrintWriter(new File("resources/puntajes.yml").getAbsolutePath());
			Map previousData = previousYaml.load(file);
			
			yaml.dump(dataJugadores, writer);
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
