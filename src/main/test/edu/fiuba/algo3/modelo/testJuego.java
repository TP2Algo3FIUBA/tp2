package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testJuego {

    @Test
    public void juagdorMueveAEsquinaInexistente(){
        Juego juego = new Juego(new Jugador(new Vehiculo(new EstadoAuto())),new Tablero());

        juego.moverJugadorEnDireccion(new DirOeste());
        juego.cantMovJugador();
        assertEquals(juego.cantMovJugador(),0);
    }

    @Test
    public void jugaodorNoHaGanado(){
        Juego juego = new Juego(new Jugador(new Vehiculo(new EstadoAuto())),new Tablero());

        juego.moverJugadorEnDireccion(new DirOeste());
        juego.cantMovJugador();
        assertEquals(juego.Ganado(),false);
    }
    @Test
    public void nombreDelJugador(){
        Juego juego = new Juego(new Jugador(new Vehiculo(new EstadoAuto())),new Tablero());
        juego.setNombreJugador("Lucas");
        assertEquals(juego.getNombreJugador(),"Lucas");
    }
    @Test
    public void nombreDelJugador2(){
        Juego juego = new Juego(new Jugador(new Vehiculo(new EstadoAuto())),new Tablero());
        juego.setNombreJugador("Boris");
        assertEquals(juego.getNombreJugador(),"Boris");
    }

    @Test
    public void obtenerUnaPosicionActualQueSeaEsquina(){
        Juego juego = new Juego(new Jugador(new Vehiculo(new EstadoAuto())),new Tablero());
        assertEquals(juego.obtenerPosicionJugador() instanceof Esquina,true);
    }
}
