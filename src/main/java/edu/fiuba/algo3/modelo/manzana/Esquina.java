package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;

import java.util.ArrayList;
import java.util.HashMap;

public class Esquina implements Observable {//Positionable, Observable {
	private final HashMap<String, Cuadra> cuadras;
	private EstadoEsquina estado;

	// Agregado para la interfaz
	private ArrayList<Observer> observers;
	private Position position;
	
	public Esquina() {
		this.cuadras = new HashMap<>();
		this.estado = new NoMeta();
		this.position = new Position(0,0);
	}

	public Esquina(EstadoEsquina estado, int posFil, int posCol) {
		this.cuadras = new HashMap<>();
		this.estado = estado;
		this.position = new Position(posFil,posCol);
		observers = new ArrayList<Observer>();
	}

	public Esquina(int posFil, int posCol) {
		this.cuadras = new HashMap<>();
		this.position = new Position(posFil,posCol);
		observers = new ArrayList<Observer>();
	}

	public void moverVehiculo(Jugador jugador, Direccion direccion) {

		Cuadra cuadraAdirijirse = cuadras.get(direccion.toString());
		if (cuadraAdirijirse == null) {
			throw new CuadraInexistenteException();
		}

		jugador.incrementarMovimientos(1);

		cuadraAdirijirse.moverVehiculo(jugador, this);
	}

	public void insertarCuadra(Direccion direccion, Cuadra cuadra) {
		cuadras.put(String.valueOf(direccion), cuadra);
	}
	
	public EstadoEsquina checkearEstado() {
		return estado;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
		notifyObservers();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers() {
		observers.stream().forEach(observer -> observer.change());
	}

	public String getEsquinaName() {
		return "esquina";
	}
}
