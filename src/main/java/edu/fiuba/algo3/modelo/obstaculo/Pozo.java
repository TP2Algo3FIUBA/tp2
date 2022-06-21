package edu.fiuba.algo3.modelo.obstaculo;


import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo implements Evento{


    public Pozo(){

    }

    @Override
    public void afectarJugador(Jugador jugador){
    	Vehiculo vehiculo = jugador.getVehiculo();
        vehiculo.chocarContraPozo(jugador);
    }

}
