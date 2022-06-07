package edu.fiuba.algo3.modelo;

public abstract class Vehiculo {
    public abstract int aplicarPenalizacion(Pozo obstaculo);

    public abstract void mover(Esquina esquina);

    public abstract void turnosPenalizadosAConductor(int i);
}
