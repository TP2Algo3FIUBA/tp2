package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;

import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.EstadoCuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testObstaculos {
    @Test
    void testPiqueteJugadorNoPuedeSeguirAvanzandoSiTieneUnAuto(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Evento evento = new Piquete();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, evento);

        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();
        esquinaA.insertarCuadra(Este, cuadra);
        esquinaB.insertarCuadra(Oeste, cuadra);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        jugador.moverEnDireccion(Este);
        assertEquals(esquinaA, jugador.posicionActual());

    }

    @Test
    void testPiqueteJugadorNoPuedeSeguirAvanzandoSiTieneUnaCuatroPoCuatro(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Evento evento = new Piquete();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, evento);

        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();
        esquinaA.insertarCuadra(Este, cuadra);
        esquinaB.insertarCuadra(Oeste, cuadra);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoCuatroPorCuatro()) );
        jugador.spawnearVehiculoEn(esquinaA);

        jugador.moverEnDireccion(Este);
        assertEquals(esquinaA, jugador.posicionActual());

    }

    @Test
    void testPiqueteLeSumaMovimientosAlJugadorSiTieneUnaMoto(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Evento evento = new Piquete();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, evento);

        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();
        esquinaA.insertarCuadra(Este, cuadra);
        esquinaB.insertarCuadra(Oeste, cuadra);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        jugador.moverEnDireccion(Este);
        assertEquals(esquinaB, jugador.posicionActual());
        assertEquals(jugador.getMovimientos(), 3);
    }

    @Test
    void testUnAutoPasaPorunControlPolicialYLeSumaTresMovimientos(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Evento evento = new ControlPolicial();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, evento);

        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();
        esquinaA.insertarCuadra(Este, cuadra);
        esquinaB.insertarCuadra(Oeste, cuadra);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        jugador.moverEnDireccion(Este);

    }

    @Test
    public void testControlPolicial(){
        ControlPolicial controlPolicial = new ControlPolicial();
        Jugador jugador = new Jugador(new Vehiculo(new EstadoCuatroPorCuatro()));
        controlPolicial.afectarJugador(jugador,new Esquina(), new Esquina());

        assertEquals(controlPolicial.getName(), "controlpolicial");
    }
    @Test
    public void testPiquete(){
        Piquete piquete = new Piquete();
        Jugador jugador = new Jugador(new Vehiculo(new EstadoCuatroPorCuatro()));
        piquete.afectarJugador(jugador,new Esquina(), new Esquina());

        assertEquals(piquete.getName(), "piquete");
    }
}
