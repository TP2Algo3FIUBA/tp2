package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class SorpresaDesfavorable implements Evento{
    public SorpresaDesfavorable() {

    }

	@Override
	public void afectarJugador(Jugador jugador) {
		jugador.sorpresaDesfavorable();
	}
}
