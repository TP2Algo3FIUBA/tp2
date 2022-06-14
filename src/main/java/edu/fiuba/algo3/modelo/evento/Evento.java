package edu.fiuba.algo3.modelo.evento;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public interface Evento {
    boolean afectarJugador(Jugador jugador);

}
