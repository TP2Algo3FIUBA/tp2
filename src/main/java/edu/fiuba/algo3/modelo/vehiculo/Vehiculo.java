package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.EsquinaNoValidaException;
import edu.fiuba.algo3.modelo.manzana.EstadoEsquina;

public class Vehiculo {

	//public Jugador conductor;
	private Esquina esquinaActual;
	private EstadoVehiculo estadoVehiculo;

	public Vehiculo(EstadoVehiculo unEstadoVehiculo) {
		esquinaActual = new Esquina(); // para inicializarlo en un estado valido
		estadoVehiculo = unEstadoVehiculo; // supuesto - caso inicial es un Auto
	}

	public void setEsquinaActual(Esquina esquinaActual) {
		if(esquinaActual== null){throw new EsquinaNoValidaException();}
		this.esquinaActual = esquinaActual;
	}

	public void moverseAEsquina(Jugador jugador, Direccion direccion) {
		this.esquinaActual.moverVehiculo(jugador, direccion);
	}

	public Esquina getEsquinaActual() {
		return esquinaActual;
	}

	public void chocarContraPozo(Jugador jugador) {
		estadoVehiculo.chocarContraPozo(jugador);
	}

	public Esquina chocarContraPiquete(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino){
		return estadoVehiculo.chocarContraPiquete(jugador, esquinaInicio, esquinaDestino);
	}

	public void aplicarSorpresaCambioVehiculo() {
		estadoVehiculo = estadoVehiculo.aplicarSorpresaCambioVehiculo();
	}

	public void chocharControlPolicial(Jugador jugador) {
		// TODO Auto-generated method stub
		estadoVehiculo.atravezarControlPolicial(jugador);
	}

	// Solo se utiliza para los test
	public EstadoVehiculo getEstadoVehiculo() {
		return this.estadoVehiculo;
	}


	public void chocharControlPolicialMockeado(Jugador jugador) {
		estadoVehiculo.atravezarControlPolicialMockeado(jugador);
	}

	public EstadoEsquina checkearEsquinaEstado() {
		return this.esquinaActual.checkearEstado();
	}

	/*public void atravezarControlPolicial(Jugador jugador) {
		estadoVehiculo.atravezarControlPolicial(jugador);
	}

	public void aplicarSorpresaDesfavorable(Jugador jugador) {
		//jugador.incrementarMovimientos((jugador.getMovimientos()) * (25 / 100)); // ! viola encapsulamiento
		jugador.chocarContraSorpresaDesfavofable();
	}

	public void aplicarSorpresaFavorable(Jugador jugador) {
		//jugador.incrementarMovimientos((jugador.getMovimientos()) * (20 / 100) * (-1));// ! viola encapsulamiento
		jugador.chocarContraSorpresaFavorable();
	}*/

}
