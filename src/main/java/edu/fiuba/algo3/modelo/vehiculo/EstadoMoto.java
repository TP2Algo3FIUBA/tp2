package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public class EstadoMoto implements EstadoVehiculo {

	public EstadoMoto() {

	}

	@Override
	public void chocarContraPozo(Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}

	@Override
	public Esquina chocarContraPiquete(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino){
		jugador.incrementarMovimientos(2);
		return esquinaDestino;
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

	@Override
	public void atravezarControlPolicialMockeado(Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}

	@Override
	public String getName() {
		return "moto";
	}

}
