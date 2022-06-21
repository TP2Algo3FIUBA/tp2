package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class EstadoMoto extends EstadoVehiculo {

	public EstadoMoto() {
		super();
	}

	@Override
	public void chocarContraPozo(Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}

	@Override
	public void chocarContraPiquete(Jugador jugador) {
		jugador.incrementarMovimientos(2);
	}

	@Override
	public EstadoVehiculo aplicarSorpresaCambioVehiculo() {
		return (new EstadoAuto());
	}

	@Override
	public void atravezarControlPolicial(Jugador jugador) {
		double probabilidadPenalizacion = Math.random();
		if (probabilidadPenalizacion <= 0.8) {
			jugador.incrementarMovimientos(3);
		}

	}

}
