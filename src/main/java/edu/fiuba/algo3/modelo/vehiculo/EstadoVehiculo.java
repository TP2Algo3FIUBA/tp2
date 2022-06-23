package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public abstract class EstadoVehiculo {
    public abstract EstadoVehiculo aplicarSorpresaCambioVehiculo();

    public abstract void chocarContraPozo(Jugador jugador);

    public abstract Esquina chocarContraPiquete(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino);

    public abstract void atravezarControlPolicial(Jugador jugador);

    public abstract void atravezarControlPolicialMockeado(Jugador jugador);
}
