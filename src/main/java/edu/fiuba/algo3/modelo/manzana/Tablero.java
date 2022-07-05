package edu.fiuba.algo3.modelo.manzana;

import java.util.ArrayList;

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
	ArrayList<ArrayList<Esquina>> filas = new ArrayList(); // TO DO cambiar nombre a esquinas o algo mejor

	private static final int heigth = 8;
	private static final int width = 8;

	ArrayList<ArrayList<Cuadra>> filasCuadras = new ArrayList();
	private ArrayList<Observer> observers;
	private Esquina meta;

	public Tablero() {
		super();
		observers = new ArrayList<Observer>();

		generarEsquinas();
		generarCuadras();
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

				}

				if(columnaActual == heigth - 1 && filaActual == width - 1) {
					esquina = new Esquina(new Meta());
				}

				else {
					esquina = new Esquina(columnaActual, filaActual);// esquina = new Esquina(); va del reves?
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
				Evento evento = GeneradorEventos.generarEvento(); // new EventoVacio(); //

				if (filaActual != 0) {
					esquinaDestino = this.obtenerEsquina(filaActual - 1, columnaActual);
					Cuadra nuevaCuadraInicioADestino = new Cuadra(esquinaInicio, esquinaDestino, evento); // y aca en lugar de un obstaculo le pasas un evento
					esquinaInicio.insertarCuadra(new DirNorte(), nuevaCuadraInicioADestino);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio, evento);
					esquinaDestino.insertarCuadra(new DirSur(), nuevaCuadraDestinoAInicio);

					agregarCuadra(filaActual,nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != 0) {
					esquinaDestino = this.obtenerEsquina(filaActual, columnaActual - 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento);
					esquinaInicio.insertarCuadra(new DirOeste(), nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento);
					esquinaDestino.insertarCuadra(new DirOeste(), nuevaCuadraDestinoAInicio);
					agregarCuadra(filaActual,nuevaCuadraDestinoAInicio);
				}

				if (filaActual != width - 1) {
					esquinaDestino = this.obtenerEsquina(filaActual + 1, columnaActual);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento);
					esquinaInicio.insertarCuadra(new DirSur(), nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento);
					esquinaDestino.insertarCuadra(new DirNorte(), nuevaCuadraDestinoAInicio);
					agregarCuadra(filaActual,nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != heigth - 1) {
					esquinaDestino = this.obtenerEsquina(filaActual, columnaActual + 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento);
					esquinaInicio.insertarCuadra(new DirEste(), nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento);
					esquinaDestino.insertarCuadra(new DirOeste(), nuevaCuadraDestinoAInicio);
					agregarCuadra(filaActual,nuevaCuadraDestinoAInicio);
				}
			}
		}
	}

	public Esquina obtenerEsquina(int fila, int columna) {
		return ((filas.get(fila)).get(columna));
	}

	public void agregarEsquina(int fila, Esquina nuevaEsquina) {
		if (filas.size() < fila + 1)
			filas.add(new ArrayList<Esquina>());

		filas.get(fila).add(nuevaEsquina);
	}
	public void agregarCuadra(int fila, Cuadra nuevaCuadra) {
		if (filasCuadras.size() < fila + 1)
			filasCuadras.add(new ArrayList<Cuadra>());

		filasCuadras.get(fila).add(nuevaCuadra);
	}
	
	public void spawnearJugador(Jugador jugador) {
		jugador.spawnearVehiculoEn(this.obtenerEsquina(0, 0));
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
