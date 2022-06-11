package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.sorpresa.Sorpresa;

public abstract class Vehiculo {

    private Esquina posicion;

    public Vehiculo(Esquina unaPosicion) {
        posicion = unaPosicion;
    }

    public int movArriba() {
        return posicion.dirijirseAPos("arriba", this);
    }

    public int movAbajo() {
        // posicion = algo
        return posicion.dirijirseAPos("abajo", this);
    }

    public int movDerecha() {
        return posicion.dirijirseAPos("derecha", this);
    }

    public int movIzquierda() {
        // posicion = algo
        return posicion.dirijirseAPos("izquierda", this);
    }

    public int posicion() {
        return posicion.coordenada();
    }

    public void actualizarPosicion(Esquina unaEsquina) {
        posicion = unaEsquina;
    }

    public abstract int atravezarObstaculo(Obstaculo unObstaculo);

    public abstract int atravezarSorpresa(Sorpresa sorpresa);

}
