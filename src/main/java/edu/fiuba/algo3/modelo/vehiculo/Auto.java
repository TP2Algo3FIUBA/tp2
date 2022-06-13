package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Auto extends Vehiculo {

	public Auto() {
		super();
	}

	@Override
	public void chocarContraPozo(Jugador jugador){
		jugador.incrementarMovimientos(3);
	}

	@Override
	public boolean chocarContraPiquete(Jugador jugador){
		//throw new HayUnPiqueteException();
		return false;
	}
}
