package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public interface EstadoVehiculo {
     EstadoVehiculo aplicarSorpresaCambioVehiculo();

    void chocarContraPozo(Jugador jugador);

     Esquina chocarContraPiquete(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino);

    void atravezarControlPolicial(Jugador jugador);

     void atravezarControlPolicialMockeado(Jugador jugador);

    String getName();
}
