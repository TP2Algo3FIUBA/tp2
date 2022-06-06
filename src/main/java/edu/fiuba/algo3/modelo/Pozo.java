package edu.fiuba.algo3.modelo;

public class Pozo extends Obstaculo{
    public Pozo(){

    }

    @Override
    public void aplicarPenalizacion(Jugador jugador) {
        jugador.aplicarPenalizacion(this);
    }
}
