package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SorpresaCambioDeVehiculo implements Evento{
    public SorpresaCambioDeVehiculo() {

    }

		@Override
		public boolean afectarJugador(Jugador jugador) {
			jugador.aplicarSorpresaCambioVehiculo();
			return true;
		}
}
