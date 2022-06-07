package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;

public class Moto extends Vehiculo {


    public Moto(Jugador jugaddor) {
        super(jugaddor);
       /* objetosAChocar = new HashMap<>();
        objetosAChocar.put(Pozo.class, (x) -> collideWithAsteriod(x));
        objetosAChocar.put(Piquete.class, (x) -> collideWithStation(x));*/

    }

    @Override
    public void mover(Esquina esquina) {
        esquina.arribar(this);
    }

    @Override
    public void atravezarPozo() {
        this.conductor.incrementarMovimientos(3);
    }

    @Override
    public void atravezarPiquete() {
        this.conductor.incrementarMovimientos(2);
    }

    @Override
    public int cantidadDeMovimientos() {
        return this.conductor.cantidadDeMovimientos();
    }
}
