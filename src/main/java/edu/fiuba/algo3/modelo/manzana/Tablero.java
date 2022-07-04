package edu.fiuba.algo3.modelo.manzana;

import java.util.ArrayList;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modeloOpcional.*;

public class Tablero implements Observable {
	ArrayList<ArrayList<Esquina>> filas = new ArrayList(); // TO DO cambiar nombre a esquinas o algo mejor

	private static final int heigth = 6;
	private static final int width = 6;
	private HashMap<String, Esquina> esquinas;
	private ArrayList<Observer> observers;
	private Esquina meta;

	public Tablero() {
		super();
		observers = new ArrayList<Observer>();
		esquinas = new HashMap<String, Esquina>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				esquinas.put(new Position(i, j).toString(), new Esquina());
			}

		}
		/*for (int filaActual = 0; filaActual < width; filaActual++) {
			for (int columnaActual = 0; columnaActual < heigth; columnaActual++) {

				Esquina esquina;

				if(columnaActual == 0 && filaActual == 0) {

				}

				if(columnaActual == heigth - 1 && filaActual == width - 1) {
					esquina = new Esquina(new Meta());
					this.meta = esquina;
				}

				else {
					esquina = new Esquina();
				}
				esquina.setPosition( new Position(columnaActual,filaActual));
				this.agregarEsquina(filaActual, esquina);
			}
		}*/
	}

	public Esquina obtenerEsquina(int fila, int columna) {
		return ((filas.get(fila)).get(columna));
	}

	public void agregarEsquina(int fila, Esquina nuevaEsquina) {
		if (filas.size() < fila + 1)
			filas.add(new ArrayList<Esquina>());

		filas.get(fila).add(nuevaEsquina);
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

	public int getHeigth() {
		return heigth;
	}

	public int getWidth() {
		return width;
	}

	public void movePositionableToLeft(Positionable positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX() - 1, positionable.getPosition().getY()));
	}

	public void movePositionableToRigth(Positionable positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX() + 1, positionable.getPosition().getY()));
	}

	public void movePositionableToUp(Positionable positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX(), positionable.getPosition().getY() - 1));
	}

	public void movePositionableToDown(Positionable positionable) {
		movePositionableTo(positionable,
				new Position(positionable.getPosition().getX(), positionable.getPosition().getY() + 1));
	}

	private void movePositionableTo(Positionable positionable, Position position) {
		Esquina fromMove = esquinas.get(positionable.getPosition().toString());
		if (!fromMove.hasOccupant(positionable)) {
			throw new RuntimeException("There is no target!");
		}
		positionate(positionable, position);
		fromMove.dropOccupant();
	}
}
