package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testJugador {
    @Test
    public void unJugadorRecienInicializadoTieneCeroMovimientos() {
        Jugador jugador = new Jugador(new Moto());

        assertEquals(0, jugador.getMovimientos());
    }

    @Test
    public void unJugadorInicializadoConUnaMotoTieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new Moto());

        assertTrue(jugador.getVehiculo() instanceof Moto);
    }
    @Test
    public void unJugadorInicializadoConUnAutoTieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new Auto());

        assertTrue(jugador.getVehiculo() instanceof Auto);
    }
    @Test
    public void unJugadorInicializadoConUn4x4TieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new CuatroPorCuatro());

        assertTrue(jugador.getVehiculo() instanceof CuatroPorCuatro);
    }

    @Test
    public void unJugadorSeIniciaEnUnaEsquinaCorrecta() {
        Jugador jugador = new Jugador(new CuatroPorCuatro());

        Esquina esquina = new Esquina();

        jugador.spawnearVehiculoEn(esquina);

        assertEquals(esquina, jugador.posicionActual());
    }
}
