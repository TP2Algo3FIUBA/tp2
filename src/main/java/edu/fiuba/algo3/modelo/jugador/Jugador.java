package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.EstadoEsquina;
import edu.fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modeloOpcional.Observable;
import edu.fiuba.algo3.modeloOpcional.Observer;
import edu.fiuba.algo3.modeloOpcional.Position;
import edu.fiuba.algo3.modeloOpcional.Positionable;

import java.util.ArrayList;

public class Jugador implements Positionable, Observable {
	private int movimientos = 0;

	private ArrayList<Observer> observers;
	private Vehiculo vehiculo;
	private Position position;

	public Jugador(Vehiculo unVehiculo) {
		super();
		vehiculo = unVehiculo;
		observers = new ArrayList<Observer>();
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void incrementarMovimientos(int movimientos) {
		this.movimientos += movimientos;
	}

	public void moverEnDireccion(Direccion direccion) {
		vehiculo.moverseAEsquina(this, direccion); // ! raro
//		return (vehiculo.getEsquinaActual().checkearEstado());
	}
	
	public void setEsquinaActual(Esquina esquinaActual) {
		vehiculo.setEsquinaActual(esquinaActual);	
	}

	public Esquina posicionActual() {
		return vehiculo.getEsquinaActual();
	}

	public void spawnearVehiculoEn(Esquina unaEsquina) {
		vehiculo.setEsquinaActual(unaEsquina);
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void aplicarSorpresaCambioVehiculo() {
		vehiculo.aplicarSorpresaCambioVehiculo();
	}

	public void sorpresaFavorable() {
		this.movimientos = (int) Math.round((movimientos)*0.8) ;
		//No tendria porque estar el -1 aca, cuando se aplica sorpresa, directamente no se tiene q sumar movimientos
		//Tenemos que reever toda la logica de como sumar puntos.

	}

	public void sorpresaDesfavorable() {
		this.movimientos = (int) Math.round((movimientos)*1.25);
	}

	// Solo se utiliza para los test
	public EstadoVehiculo getEstadoVehiculo() {
		return this.vehiculo.getEstadoVehiculo();
	}

	public void chocarContraSorpresaFavorable() {;
		this.incrementarMovimientos((this.getMovimientos()) * (25 / 100));
	}

	public void chocarContraSorpresaDesfavofable() {
		this.incrementarMovimientos((this.movimientos) * (20 / 100) * (-1));
	}

	public void atravezarControlPolicial(Jugador jugador) {
		this.vehiculo.chocharControlPolicial(jugador);
	}

	public void atravezarControlPolicialMockeado(Jugador jugador) {
		this.vehiculo.chocharControlPolicialMockeado(jugador);
	}
	
	public EstadoEsquina checkearEsquinaEstado() {
		return this.vehiculo.checkearEsquinaEstado();
	}

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
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

	public String getVehiculoName() {
		return this.vehiculo.getEstadoName();
	}
}
