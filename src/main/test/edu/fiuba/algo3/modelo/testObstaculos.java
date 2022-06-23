package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.direcciones.DirEste;
import edu.fiuba.algo3.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicialMockeado;
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
        Evento evento = new ControlPolicialMockeado();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, evento);

        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();
        esquinaA.insertarCuadra(Este, cuadra);
        esquinaB.insertarCuadra(Oeste, cuadra);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        jugador.moverEnDireccion(Este);
        assertEquals(jugador.getMovimientos(), 4);
    }
}
