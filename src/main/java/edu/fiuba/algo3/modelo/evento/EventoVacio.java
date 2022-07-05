package edu.fiuba.algo3.modelo.evento;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public class EventoVacio implements Evento {

	@Override
	public Esquina afectarJugador(Jugador vehiculoEnLaCuadra, Esquina esquinaInicio, Esquina esquinaDestino) {
		return esquinaDestino;
	}

	@Override
	public String getName() {
		return "cuadra";
	}

}
