package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public abstract class Vehiculo {

	public Jugador conductor;
	private Esquina esquinaActual;

	public Vehiculo() {
		conductor = null;
		esquinaActual = null;
	}

	public void incrementarMovimientos(int movimientos) {
		conductor.incrementarMovimientos(movimientos);
	}

	public Jugador getConductor() {
		return conductor;
	}

	public void setConductor(Jugador conductor) {
		this.conductor = conductor;
	}

	public void setEsquinaActual(Esquina esquinaActual) {
		this.esquinaActual = esquinaActual;
	}

	public void moverseAEsquina(String direccion) {
		this.esquinaActual.moverVehiculo(direccion);
	}

	public Esquina getEsquinaActual() {
		return esquinaActual;
	}

	public abstract void chocarContraPozo();

	public abstract void chocarContraPiquete();

	public void sorpresaFavorable() {
		incrementarMovimientos((conductor.getMovimientos()) * (20 / 100) * (-1));
	}

	public void sorpresaDesfavorable() {
		incrementarMovimientos((conductor.getMovimientos()) * (25 / 100));
	}
}
