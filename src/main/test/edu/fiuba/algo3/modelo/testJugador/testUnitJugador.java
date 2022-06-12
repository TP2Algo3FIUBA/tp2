package edu.fiuba.algo3.modelo.testJugador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testUnitJugador {
    @Test
    public void UnJugadorRecienInicializadoTieneCeroMovimientos() {
        Jugador jugador = new Jugador(new Moto());

        assertEquals(0, jugador.getMovimientos());
    }
    
    @Test
    public void UnIncrementarMovimientosDelJugador() {
        Jugador jugador = new Jugador(new Moto());
        jugador.incrementarMovimientos(5);

        assertEquals(jugador.getMovimientos(), 5);
    }

}
