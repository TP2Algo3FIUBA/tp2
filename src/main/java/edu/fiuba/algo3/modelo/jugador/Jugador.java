package edu.fiuba.algo3.modelo.jugador;


public class Jugador {
    private int movimientos = 0;
    // supuesto


    public Jugador (){

    }

    public void incrementarMovimientos(int i) {
        movimientos += i;
    }

    public int cantidadDeMovimientos() {
        return this.movimientos;
    }

}
