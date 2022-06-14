package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Tablero;

public class Juego {

    private Jugador jugador;
    private Tablero tablero;

    public Juego(Jugador unJugador, Tablero unTablero) {
        jugador = unJugador;
        tablero = unTablero;
    }

    public void moverJugadorEnDireccion(String direccion) {
    	try {
        jugador.moverEnDireccion(direccion);
    	} catch(CuadraInexistenteException e){
    		
    	}
    }

    public Esquina obtenerPosicionJugador() {
        return  jugador.posicionActual();
    }

    public void spawnearJugadorEn(int fila, int columna) {
        Esquina esquinaSpawn = tablero.obtenerEsquina(fila, columna);
        jugador.spawnearVehiculoEn(esquinaSpawn);
    }

    public int cantMovJugador() {
        return this.jugador.getMovimientos();
    }
}
