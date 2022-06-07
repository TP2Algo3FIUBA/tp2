package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;


public class CuatroPorCuatro extends Vehiculo{

    private int pozosAtravezados;

    public CuatroPorCuatro(Jugador jugaddor) {
        super(jugaddor);
        this.pozosAtravezados=0;
    }

    @Override
    public void mover(Esquina esquina) {
        esquina.arribar(this);
    }


    @Override
    public void atravezarPozo() {
        this.pozosAtravezados ++;
        if(this.pozosAtravezados==3){
            conductor.incrementarMovimiento(2);
        }
    }

    @Override
    public void atravezarPiquete() {
        this.conductor.incrementarMovimiento(0);
    }

    @Override
    public int cantidadDeMovimientos() {
        return this.conductor.cantidadDeMovimientos();
    }


}
