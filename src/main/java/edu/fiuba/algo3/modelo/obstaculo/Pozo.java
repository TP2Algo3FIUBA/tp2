package edu.fiuba.algo3.modelo.obstaculo;


import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo extends Obstaculo {


    public Pozo(){


    }

    @Override
    public void penalizar( Vehiculo unVehiculo) {
        unVehiculo.atravezarPozo();
    }
}
