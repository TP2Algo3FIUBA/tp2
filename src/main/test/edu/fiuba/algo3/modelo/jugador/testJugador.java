package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.EstadoCuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testJugador {
    @Test
    public void unJugadorRecienInicializadoTieneCeroMovimientos() {
        Jugador jugador = new Jugador(new Vehiculo(new EstadoMoto()));

        assertEquals(0, jugador.getMovimientos());
    }

    @Test
    public void unJugadorInicializadoConUnaMotoTieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new Vehiculo(new EstadoMoto()));

        assertTrue(jugador.getVehiculo().getEstadoVehiculo() instanceof EstadoMoto);
    }
    @Test
    public void unJugadorInicializadoConUnAutoTieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new Vehiculo(new EstadoAuto()));

        assertTrue(jugador.getVehiculo().getEstadoVehiculo() instanceof EstadoAuto);
    }
    @Test
    public void unJugadorInicializadoConUn4x4TieneElVehiculoBienInicializado() {
        Jugador jugador = new Jugador(new Vehiculo(new EstadoCuatroPorCuatro()));

        assertTrue(jugador.getVehiculo().getEstadoVehiculo() instanceof EstadoCuatroPorCuatro);
    }

    @Test
    public void unJugadorSeIniciaEnUnaEsquinaCorrecta() {
        Jugador jugador = new Jugador(new Vehiculo(new EstadoMoto()));

        Esquina esquina = new Esquina();

        jugador.spawnearVehiculoEn(esquina);

        assertEquals(esquina, jugador.posicionActual());
    }

    @Test
    public void unJugadorSeEncuentraConSorpresaFavorable() {
        Jugador jugador = new Jugador(new Vehiculo(new EstadoMoto()));

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
    @Test
    void testJugadorAvanzaContraControlPolicialConAuto(){
        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.incrementarMovimientos(1);
        jugador.atravezarControlPolicial(jugador);
        assertTrue(jugador.getMovimientos()>0);
    }
    @Test
    void testJugadorAvanzaContraControlPolicialConMoto(){
        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );

        jugador.incrementarMovimientos(1);
        jugador.atravezarControlPolicial(jugador);
        assertTrue(jugador.getMovimientos()>0);
        assertEquals(jugador.getVehiculoName(),"moto");
    }
    @Test
    void testJugadorAvanzaContraControlPolicialCon4x4(){
        Jugador jugador = new Jugador( new Vehiculo(new EstadoCuatroPorCuatro()) );

        jugador.incrementarMovimientos(1);
        jugador.atravezarControlPolicial(jugador);
        assertTrue(jugador.getMovimientos()>0);
        assertEquals(jugador.getVehiculoName(),"4x4");
    }
    @Test
    void getPositionTest(){
        Jugador jugador = new Jugador( new Vehiculo(new EstadoCuatroPorCuatro()) );

        Position position = new Position(0,0) ;
        assertTrue(jugador.getPosition() instanceof Position);

        jugador.setPosition(position);
        assertEquals(jugador.getPosition(),position);

        assertEquals(jugador.getVehiculoName(),"4x4");
        jugador.resetearMovimientos();
        assertEquals(jugador.getMovimientos(),0);
    }
}
