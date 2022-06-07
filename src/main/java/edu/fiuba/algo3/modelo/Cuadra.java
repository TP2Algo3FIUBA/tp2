package edu.fiuba.algo3.modelo;

public class Cuadra {
    private final Obstaculo obstaculo;

    public Cuadra(Obstaculo unObstaculo) {
        this.obstaculo = unObstaculo;
    }

    public void trancita(Vehiculo unVehiculo) {
        obstaculo.penalizar(unVehiculo);
    }
}
