package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ControlPolicial implements Evento {

	@Override
	public Esquina afectarJugador(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino) {
    	jugador.atravezarControlPolicial(jugador);
    	return esquinaDestino;
	}

	@Override
	public String getName() {
		return "controlpolicial";
	}
}