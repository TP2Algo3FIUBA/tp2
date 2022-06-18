package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.direcciones.DirEste;
import edu.fiuba.algo3.direcciones.DirNorte;
import edu.fiuba.algo3.direcciones.DirOeste;
import edu.fiuba.algo3.direcciones.DirSur;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
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

    @Test
    public void unJugadorSeEncuentraConSorpresaFavorable() {
        Jugador jugador = new Jugador(new Auto());

        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Esquina esquinaC = new Esquina();
        Cuadra cuadraA_B = new Cuadra(esquinaA, esquinaB);
        Cuadra cuadraB_C = new Cuadra(esquinaB, esquinaC, new SorpresaFavorable());

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        esquinaA.insertarCuadra(Este, cuadraA_B);
        esquinaB.insertarCuadra(Oeste, cuadraA_B);
        esquinaB.insertarCuadra(Este, cuadraB_C);
        esquinaC.insertarCuadra(Oeste, cuadraB_C);

        jugador.spawnearVehiculoEn(esquinaA);
        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Este);

        assertEquals(2, jugador.getMovimientos());
    }
}
