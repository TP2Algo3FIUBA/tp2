package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class CuatroPorCuatro extends Vehiculo {

	private int pozosAtravezados;

	public CuatroPorCuatro() {
		super();
		this.pozosAtravezados = 0;
	}

	@Override
	public boolean chocarContraPozo(Jugador jugador){
		this.pozosAtravezados++;
		if(this.pozosAtravezados==3){
			jugador.incrementarMovimientos(2);
		}
		jugador.incrementarMovimientos(0);
		return true;
	}

	@Override
	public boolean chocarContraPiquete(Jugador jugador){
		//throw new HayUnPiqueteException();
		return false;
	}

	@Override
	public Vehiculo aplicarSorpresaCambioVehiculo() {
		return (new Moto());
	}

}
