package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SorpresaFavorable implements Evento{
    public SorpresaFavorable () {

    }

		@Override
		public boolean afectarJugador(Jugador jugador) {

			jugador.sorpresaFavorable();
			return true;
		}
}
