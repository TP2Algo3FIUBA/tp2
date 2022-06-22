package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public class EstadoCuatroPorCuatro extends EstadoVehiculo {

	private int pozosAtravezados;

	public EstadoCuatroPorCuatro() {
		super();
		this.pozosAtravezados = 0;
	}

	@Override
	public void chocarContraPozo(Jugador jugador) {
		this.pozosAtravezados++;
		if (this.pozosAtravezados == 3) {
			jugador.incrementarMovimientos(2);
			this.pozosAtravezados = 0;
		}
		jugador.incrementarMovimientos(0);
	}

	@Override
	public Esquina chocarContraPiquete(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino){
		return esquinaInicio;
		// throw new HayUnPiqueteException();
	}

	@Override
	public EstadoVehiculo aplicarSorpresaCambioVehiculo() {
		return (new EstadoMoto());
	}

	@Override
	public void atravezarControlPolicial(Jugador jugador) {
		double probabilidadPenalizacion = Math.random();
		if (probabilidadPenalizacion <= 0.3) {
			jugador.incrementarMovimientos(3);
		}

	}

}
