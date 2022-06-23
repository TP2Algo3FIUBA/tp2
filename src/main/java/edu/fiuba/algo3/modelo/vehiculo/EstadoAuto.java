package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public class EstadoAuto extends EstadoVehiculo {

	public EstadoAuto() {
		super();
	}

	@Override
	public void chocarContraPozo(Jugador jugador){
		jugador.incrementarMovimientos(3);

	}

	@Override
	public Esquina chocarContraPiquete(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino){
		return esquinaInicio;
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

	@Override
	public void atravezarControlPolicialMockeado(Jugador jugador) {
		jugador.incrementarMovimientos(3);
	}

}
