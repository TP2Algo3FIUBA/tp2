package edu.fiuba.algo3.modelo.manzana;

import java.util.ArrayList;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.evento.GeneradorEventos;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modeloOpcional.*;
import edu.fiuba.algo3.vista.MapView;
import edu.fiuba.algo3.vista.ObstaculosView;

public class Tablero implements Observable {
	ArrayList<ArrayList<Esquina>> filas = new ArrayList(); // TO DO cambiar nombre a esquinas o algo mejor

	private static final int heigth = 8;
	private static final int width = 8;
	private HashMap<String, Esquina> esquinas;

	ArrayList<ArrayList<Cuadra>> filasCuadras = new ArrayList();
	private ArrayList<Observer> observers;
	private Esquina meta;

	public Tablero() {
		//Para la interfaz
		super();
		observers = new ArrayList<Observer>();
		esquinas = new HashMap<String, Esquina>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				esquinas.put(new Position(i, j).toString(), new Esquina());
			}

		}
		//Para el modelo
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
					esquina = new Esquina();
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
				Evento evento = GeneradorEventos.generarEvento();

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

	public void positionate(Positionable positionable, Position position) {
		esquinas.get(position.toString()).occupy(positionable);
		positionable.setPosition(position);
	}
	public void positionate(Jugador positionable, Position position) {
		Esquina esquina = esquinas.get(position.toString());
		esquina.occupy(positionable);
		positionable.setPosition(position);
		positionable.spawnearVehiculoEn(esquina);
	}

	public int getHeigth() {
		return heigth;
	}

	public int getWidth() {
		return width;
	}

	public void movePositionableToLeft(Jugador positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX() - 1, positionable.getPosition().getY()));
	}

	public void movePositionableToRigth(Jugador positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX() + 1, positionable.getPosition().getY()));
	}

	public void movePositionableToUp(Jugador positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX(), positionable.getPosition().getY() - 1));

	}

	public void movePositionableToDown(Jugador positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX(), positionable.getPosition().getY() + 1));
	}

	private void movePositionableTo(Jugador positionable, Position position) {
		Esquina fromMove = esquinas.get(positionable.getPosition().toString());
		if (!fromMove.hasOccupant(positionable)) {
			throw new RuntimeException("There is no target!");
		}
		positionate(positionable, position);
		fromMove.dropOccupant();
	}

	public void moverPosicionable(Direccion direccion, Jugador jugador) {}


	public void renderObstaculos(MapView mapView) {

		for(int i =0 ; i< heigth; i++ ){
			for (int j =0; j<width;j++){
				Evento evento;
				if (!((evento = filasCuadras.get(i).get(j).getObstaculo()) instanceof EventoVacio)){
					ObstaculosView obs = new ObstaculosView(this,mapView,evento, i,j);
					if(evento instanceof Piquete){
						obs.changePlayerSkin("piquete");
					}
					if(evento instanceof Pozo){
						obs.changePlayerSkin("pozo");
					}
					if(evento instanceof ControlPolicial){
						obs.changePlayerSkin("controlpolicial");
					}

				}

			}
		}

	}
}
