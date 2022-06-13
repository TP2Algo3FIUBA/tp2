package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Moto extends Vehiculo {

	public Moto() {
		super();
	}

	@Override
	public void chocarContraPozo(Jugador jugador){
		jugador.incrementarMovimientos(3);
	}

	@Override
	public boolean chocarContraPiquete(Jugador jugador) {
		jugador.incrementarMovimientos(2);
        return true;
    }


}
