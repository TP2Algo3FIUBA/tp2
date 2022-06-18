package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.EsquinaNoValidaException;

public abstract class Vehiculo {

	//public Jugador conductor;
	private Esquina esquinaActual;

	public Vehiculo() {
		esquinaActual = new Esquina(); //

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

	public abstract boolean chocarContraPozo(Jugador jugador);

	public abstract boolean chocarContraPiquete(Jugador jugador);
	
	public abstract void atravezarControlPolicial(Jugador jugador);

	public abstract Vehiculo aplicarSorpresaCambioVehiculo();

	public void sorpresaFavorable(Jugador jugador) {
		jugador.incrementarMovimientos((jugador.getMovimientos()) * (20 / 100) * (-1));// ! viola encapsulamiento
	}

	public void sorpresaDesfavorable(Jugador jugador) {
		jugador.incrementarMovimientos((jugador.getMovimientos()) * (25 / 100)); // ! viola encapsulamiento
	}

	public void atravezarControlPolicial() {
		// TODO Auto-generated method stub
		
	}



}
