package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;


public class Auto extends Vehiculo {
    private final Jugador conductor;

    public Auto(Jugador jugador) {
        this.conductor = jugador;
    }



    @Override
    public void mover(Esquina esquina) {
        esquina.arribar(this);
    }

    @Override
    public int cantidadDeMovimientos() {
        return this.conductor.cantidadDeMovimientos();
    }

    @Override
    public void atravezarPozo() {
        this.conductor.incrementarMovimiento(3);
    }

    @Override
    public void atravezarPiquete() {
        this.conductor.incrementarMovimiento(2);
    }

}
