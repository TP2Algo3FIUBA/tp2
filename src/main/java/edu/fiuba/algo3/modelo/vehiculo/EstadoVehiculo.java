package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;

public abstract class EstadoVehiculo {
    public abstract EstadoVehiculo aplicarSorpresaCambioVehiculo();

    public abstract void chocarContraPozo(Jugador jugador);

    public abstract void chocarContraPiquete(Jugador jugador);

    public abstract void atravezarControlPolicial(Jugador jugador);
}
