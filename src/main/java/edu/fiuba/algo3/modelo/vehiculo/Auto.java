package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;


public class Auto extends Vehiculo {

    public Auto(Jugador jugador) {
        super(jugador);
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
        this.conductor.incrementarMovimientos(3);
    }

    @Override
    public void atravezarPiquete() {
        this.conductor.incrementarMovimientos(0);
        // tiene que pegar la vuelta
    }

}
