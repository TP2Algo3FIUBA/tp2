package edu.fiuba.algo3.modelo.manzana;

import java.util.ArrayList;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Tablero implements Observable {
	ArrayList<ArrayList<Esquina>> esquinas = new ArrayList();

	private int heigth;
	private int width;

	ArrayList<Cuadra> cuadras = new ArrayList();
	private ArrayList<Observer> observers;

	public Tablero(int width, int heigth) {
		super();
		observers = new ArrayList<Observer>();
		this.width = width;
		this.heigth = heigth;
	}

	public Tablero() {
		super();
		observers = new ArrayList<Observer>();
		this.width = 0;
		this.heigth = 0;
	}

	public void generarTablero(){
		generarEsquinas();
		generarCuadras();
	}

	private void generarEsquinas() {

		for (int filaActual = 0; filaActual < heigth; filaActual++) {
			for (int columnaActual = 0; columnaActual < width; columnaActual++) {

				Esquina esquina;

				if(columnaActual == 0 && filaActual == 0) {
					esquina = new Esquina(filaActual, columnaActual);
				}

				// Genero meta
				else if(columnaActual == heigth - 1 && filaActual == width - 1) {
					esquina = new Esquina(new Meta(), filaActual, columnaActual);
				}

				else {
					esquina = new Esquina(filaActual, columnaActual);
				}

				this.agregarEsquina(filaActual, esquina);

			}
		}
	}
	private void generarCuadras() {

		for (int filaActual = 0; filaActual < heigth; filaActual++) {
			for (int columnaActual = 0; columnaActual < width; columnaActual++) {
				Esquina esquinaInicio = this.obtenerEsquina(filaActual, columnaActual);
				Esquina esquinaDestino;
				Evento evento1 = GeneradorEventos.generarEvento();
				Evento evento2 = GeneradorEventos.generarEvento();

				if (filaActual != width - 1) {
					esquinaDestino = this.obtenerEsquina(filaActual + 1, columnaActual);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento1);
					esquinaInicio.insertarCuadra(new DirSur(), nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento1);
					esquinaDestino.insertarCuadra(new DirNorte(), nuevaCuadraDestinoAInicio);
					agregarCuadra(nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != heigth - 1) {
					esquinaDestino = this.obtenerEsquina(filaActual, columnaActual + 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento2);
					esquinaInicio.insertarCuadra(new DirEste(), nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento2);
					esquinaDestino.insertarCuadra(new DirOeste(), nuevaCuadraDestinoAInicio);
					agregarCuadra(nuevaCuadraDestinoAInicio);
				}
			}
		}
	}

	public Esquina obtenerEsquina(int fila, int columna) {
		return ((esquinas.get(fila)).get(columna));
	}

	public Cuadra obtenerCuadra(int index) {
		return cuadras.get(index);
	}

	public void agregarEsquina(int fila, Esquina nuevaEsquina) {
		if (esquinas.size() < fila + 1)
			esquinas.add(new ArrayList<Esquina>());

		esquinas.get(fila).add(nuevaEsquina);
	}
	public void agregarCuadra(Cuadra nuevaCuadra) {
		cuadras.add(nuevaCuadra);
	}
	public int cantididadCuadras(){
		return cuadras.size();
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		observers.stream().forEach(observer -> observer.change());
	}

	public int getHeigth() {
		return heigth;
	}

	public int getWidth() {
		return width;
	}

}
