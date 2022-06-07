package edu.fiuba.algo3.modelo;


public class Pozo extends Obstaculo{
    public Pozo(){

    }

    @Override
    public void penalizar( Vehiculo unVehiculo) {
        unVehiculo.turnosPenalizadosAConductor(3);
    }
}
