package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Cuadra {
    private final Obstaculo obstaculo;

    public Cuadra(Obstaculo unObstaculo) {
        this.obstaculo = unObstaculo;
    }

    public void trancita(Vehiculo unVehiculo) {
        unVehiculo.atravezarCuadra();
        obstaculo.penalizar(unVehiculo);
    }
}
