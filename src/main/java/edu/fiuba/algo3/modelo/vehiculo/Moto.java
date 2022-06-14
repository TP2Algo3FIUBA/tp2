package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Moto extends Vehiculo {

	public Moto() {
		super();
	}

	@Override
	public boolean chocarContraPozo(Jugador jugador) {
		jugador.incrementarMovimientos(3);
		return true;
	}

	@Override
	public boolean chocarContraPiquete(Jugador jugador) {
		jugador.incrementarMovimientos(2);
		return true;
	}

	@Override
	public Vehiculo aplicarSorpresaCambioVehiculo() {
		return (new Auto());
	}

	@Override
	public void atravezarControlPolicial(Jugador jugador) {
		double probabilidadPenalizacion = Math.random();
		if (probabilidadPenalizacion <= 0.8) {
			jugador.incrementarMovimientos(3);
		}

	}

}
