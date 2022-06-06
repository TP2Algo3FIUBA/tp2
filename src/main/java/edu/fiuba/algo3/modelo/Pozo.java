package edu.fiuba.algo3.modelo;

public class Pozo {
    public Pozo(){

    }

    public void aplicarPenalizacion(Jugador jugador) {
        jugador.aplicarPenalizacion(this);
    }
}
