package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public abstract class Vehiculo {

    private Jugador conductor;

    public Vehiculo(Jugador jugaddor) {
        conductor = jugaddor;
    }


    public abstract void mover(Esquina esquina);

    public abstract void atravezarPozo();

    public abstract void atravezarPiquete();

    public abstract int cantidadDeMovimientos();

    public  void atravezarCuadra(){
        this.conductor.incrementarMovimiento(1);
    }
}
