package edu.fiuba.algo3.modelo.evento;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public interface Evento {
    Esquina afectarJugador(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino);

    String getName();
}
