package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public abstract class Vehiculo {

    Jugador conductor;

    public Vehiculo(Jugador jugaddor) {
        conductor = jugaddor;
    }


    public abstract void mover(Esquina esquina);

    public abstract void atravezarPozo();

    public abstract void atravezarPiquete();

    public abstract int cantidadDeMovimientos();

    public  void atravezarCuadra(){
        this.conductor.incrementarMovimientos(1);
    }
}
