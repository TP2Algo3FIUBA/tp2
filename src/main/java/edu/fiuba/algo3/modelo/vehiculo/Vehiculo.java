package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public abstract class Vehiculo {

	//public Jugador conductor;
	private Esquina esquinaActual;

	public Vehiculo() {
		//conductor = null; // !!!
		esquinaActual = null; // !!!
	}

	/*public Jugador getConductor() {
		return conductor;
	}

	public void setConductor(Jugador conductor) {
		this.conductor = conductor;
	}*/

	public void setEsquinaActual(Esquina esquinaActual) {
		this.esquinaActual = esquinaActual;
	}

	public void moverseAEsquina(Jugador jugador, String direccion) {
		this.esquinaActual.moverVehiculo(jugador, direccion);
	}

	public Esquina getEsquinaActual() {
		return esquinaActual;
	}

	public abstract void chocarContraPozo(Jugador jugador);

	public abstract boolean chocarContraPiquete(Jugador jugador);

	public void sorpresaFavorable(Jugador jugador) {
		jugador.incrementarMovimientos((jugador.getMovimientos()) * (20 / 100) * (-1));// ! viola encapsulamiento
	}

	public void sorpresaDesfavorable(Jugador jugador) {
		jugador.incrementarMovimientos((jugador.getMovimientos()) * (25 / 100)); // ! viola encapsulamiento
	}

}
