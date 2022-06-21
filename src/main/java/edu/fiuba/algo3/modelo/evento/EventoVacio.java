package edu.fiuba.algo3.modelo.evento;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public class EventoVacio implements Evento {

	@Override
	public void afectarJugador(Jugador vehiculoEnLaCuadra) {
		return;
	}

}
