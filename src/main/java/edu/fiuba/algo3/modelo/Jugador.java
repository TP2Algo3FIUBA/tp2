package edu.fiuba.algo3.modelo;

public class Jugador {
    private int movimientos;
    private Esquina posicion;
    private Moto vehiculo; // Cambiar

    public Jugador (Moto v){
        vehiculo = v;
        movimientos = 10; // supuesto
    }

    public void moverHaciaLaDerecha() {
        posicion = posicion.moverJugadorHaciaDerecha(this);
    }

    public int movimientosRestantes() {
        return movimientos;
    }

    public void cambiarPosicion(Esquina nuevaPosicion) {
        posicion = nuevaPosicion;
    }

    public void aplicarPenalizacion(Pozo obstaculo) {
        movimientos = movimientos + vehiculo.aplicarPenalizacion(obstaculo);
    }
}
