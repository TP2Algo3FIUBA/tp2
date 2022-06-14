package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testObstaculos {
    @Test
    void testPiqueteJugadorNoPuedeSeguirAvanzandoSiTieneUnAuto(){
        Jugador jugador= new Jugador(new Auto());
        Piquete piquete = new Piquete();

        assertEquals(piquete.afectarJugador(jugador), false);
    }
    @Test
    void testPiqueteJugadorNoPuedeSeguirAvanzandoSiTieneUnaCuatroPoCuatro(){
        Jugador jugador= new Jugador(new CuatroPorCuatro());
        Piquete piquete = new Piquete();

        assertEquals(piquete.afectarJugador(jugador), false);
    }
    @Test
    void testPiqueteLeSumaMovimientosAlJugadorSiTieneUnaMoto(){
        Jugador jugador= new Jugador(new Moto());
        Piquete piquete = new Piquete();

        assertEquals(piquete.afectarJugador(jugador), true);
        assertEquals(jugador.getMovimientos(), 2);
    }
}
