package edu.fiuba.algo3.modelo;

public class Esquina {

    private Interseccion interseccionSuperior;
    private Interseccion interseccionInferior;
    private Interseccion interseccionIzquierda;
    private Interseccion interseccionDerecha;
    public Esquina () {

    }

    public void asignarInterseccionIzquierda(Interseccion interseccion) {
        interseccionIzquierda = interseccion;
    }

    public void asignarInterseccionDerecha(Interseccion interseccion) {
        interseccionDerecha = interseccion;
    }

    public Esquina moverJugadorHaciaDerecha(Jugador jugador) {
        return interseccionDerecha.moverAOpuesto(this, jugador);
    }
}
