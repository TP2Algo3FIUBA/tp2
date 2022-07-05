package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Evento{
    public Piquete(){

    }

    @Override
    public Esquina afectarJugador(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino){
        Vehiculo vehiculo = jugador.getVehiculo(); // cambiar 
        return (vehiculo.chocarContraPiquete(jugador, esquinaInicio, esquinaDestino));
    }

    @Override
    public String getName() {
        return "piquete";
    }
}
