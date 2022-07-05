package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;

import java.util.HashMap;

public class Esquina implements Observable {//Positionable, Observable {
	private final HashMap<String, Cuadra> cuadras;
	private EstadoEsquina estado;
	private Position position;

//	private Jugador jugadorEnLaEsquina;
	
	public Esquina() {
		this.cuadras = new HashMap<>();
		this.estado = new NoMeta();
//		jugadorEnLaEsquina = null;
	}

	public Esquina(EstadoEsquina estado) {
		this.cuadras = new HashMap<>();
		this.estado = estado;
		this.position = new Position(2,2);
//		jugadorEnLaEsquina = null;
	}

	public Esquina(int posX, int posY) {
		this.cuadras = new HashMap<>();
		this.position = new Position(posX,posY);
//		jugadorEnLaEsquina = null;
	}

	public void moverVehiculo(Jugador jugador, Direccion direccion) {
//		System.out.println(direccion.toString());

		Cuadra cuadraAdirijirse = cuadras.get(direccion.toString());
		if (cuadraAdirijirse == null) {
			throw new CuadraInexistenteException();
//			return;
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
	}

	//private Positionable occupant;

	/*public void occupy(Positionable occupant) {
		if (this.occupant != null) {
			throw new RuntimeException();
		}
		this.occupant = occupant;
	}

	public boolean hasOccupant(Positionable occupant) {
		return occupant == this.occupant;
	}

	public void dropOccupant() {
		occupant = null;
	}*/

	@Override
	public void addObserver(Observer observer) {

	}

	@Override
	public void notifyObservers() {

	}
}
