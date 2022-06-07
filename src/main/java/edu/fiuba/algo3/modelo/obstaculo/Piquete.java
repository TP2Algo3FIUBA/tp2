package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete extends Obstaculo {
    @Override
    public void penalizar(Vehiculo unVehiculo) {
        unVehiculo.atravezarPiquete();
    }
}