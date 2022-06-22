package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public class SorpresaCambioDeVehiculo implements Evento{
    public SorpresaCambioDeVehiculo() {

    }

	@Override
	public Esquina afectarJugador(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino) {
		jugador.aplicarSorpresaCambioVehiculo();
		return esquinaDestino;
	}
}
