package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class EstadoAuto extends EstadoVehiculo {

	public EstadoAuto() {
		super();
	}

	@Override
	public void chocarContraPozo(Jugador jugador){
		jugador.incrementarMovimientos(3);

	}

	@Override
	public void chocarContraPiquete(Jugador jugador){
		//throw new HayUnPiqueteException();
	}

	@Override
	public EstadoVehiculo aplicarSorpresaCambioVehiculo() {
		return (new EstadoCuatroPorCuatro());
	}

	@Override
	public void atravezarControlPolicial(Jugador jugador) {
		double probabilidadPenalizacion = Math.random();
		if (probabilidadPenalizacion <= 0.5) {
			jugador.incrementarMovimientos(3);
		}
	}
}
