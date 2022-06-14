package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Auto extends Vehiculo {

	public Auto() {
		super();
	}

	@Override
	public boolean chocarContraPozo(Jugador jugador){
		jugador.incrementarMovimientos(3);
		return true;
	}

	@Override
	public boolean chocarContraPiquete(Jugador jugador){
		//throw new HayUnPiqueteException();
		return false;
	}

	@Override
	public Vehiculo aplicarSorpresaCambioVehiculo() {
		return (new CuatroPorCuatro());
	}

	@Override
	public void atravezarControlPolicial(Jugador jugador) {
		double probabilidadPenalizacion = Math.random();
		if (probabilidadPenalizacion <= 0.5) {
			jugador.incrementarMovimientos(3);
		}
	}
}
