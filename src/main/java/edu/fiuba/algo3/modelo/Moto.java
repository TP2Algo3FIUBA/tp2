package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo{
    public Moto() {

    }

    @Override
    public int aplicarPenalizacion(Pozo obstaculo) {
        return -3;
    }
}
