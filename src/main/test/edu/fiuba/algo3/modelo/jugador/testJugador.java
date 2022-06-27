package edu.fiuba.algo3.modelo.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testJugador {
    /*@Test
    public void unJugadorRecienInicializadoTieneCeroMovimientos() {
        Jugador jugador = new Jugador(new EstadoMoto());

        assertEquals(0, jugador.getMovimientos());
    }

    @Test
    public void unJugadorInicializadoConUnaMotoTieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new EstadoMoto());

        assertTrue(jugador.getVehiculo() instanceof EstadoMoto);
    }
    @Test
    public void unJugadorInicializadoConUnAutoTieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new EstadoAuto());

        assertTrue(jugador.getVehiculo() instanceof EstadoAuto);
    }
    @Test
    public void unJugadorInicializadoConUn4x4TieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new EstadoCuatroPorCuatro());

        assertTrue(jugador.getVehiculo() instanceof EstadoCuatroPorCuatro);
    }

    @Test
    public void unJugadorSeIniciaEnUnaEsquinaCorrecta() {
        Jugador jugador = new Jugador(new EstadoCuatroPorCuatro());

        Esquina esquina = new Esquina();

        jugador.spawnearVehiculoEn(esquina);

        assertEquals(esquina, jugador.posicionActual());
    }

    @Test
    public void unJugadorSeEncuentraConSorpresaFavorable() {
        Jugador jugador = new Jugador(new EstadoAuto());

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
    }*/
}
