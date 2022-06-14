package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Evento{
    public Piquete(){

    }

    @Override
    public boolean afectarJugador(Jugador jugador){
        Vehiculo vehiculo = jugador.getVehiculo(); // cambiar
        return vehiculo.chocarContraPiquete(jugador);
    }
}
