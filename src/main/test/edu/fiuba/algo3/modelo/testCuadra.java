package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.EstadoCuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testCuadra {
    @Test
    public void unAutoSePuedeMoverDeUnaEsquinaAOtraAtravezandoUnaCuadra() {
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        cuadra.moverVehiculo(jugador, esquinaA);
        assertEquals(esquinaB, jugador.posicionActual());
    }

    @Test
    public void unAutoQueSeMuevePorUnaCuadraConUnPozoEsPenalizadoEnTresMovimientos(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, new Pozo());

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        cuadra.moverVehiculo(jugador, esquinaA);
        assertEquals(3, jugador.getMovimientos());
    }

    @Test
    public void unAutoQueSeMuevePorUnaCuadraConUnaSorpresaCambioDeVehiculoHaceQueSeCambieAUn4x4(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, new SorpresaCambioDeVehiculo());

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        cuadra.moverVehiculo(jugador, esquinaA);
        assertTrue(jugador.getEstadoVehiculo() instanceof EstadoCuatroPorCuatro);

        assertTrue( cuadra.getObstaculo() instanceof SorpresaCambioDeVehiculo);
    }
    @Test
    public void getEventoPozo(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, new Pozo());

        assertTrue( cuadra.getObstaculo() instanceof Pozo);
        assertEquals(cuadra.getTipoCuadraName(),"pozo");
        assertTrue( cuadra.getPosition() instanceof Position);
    }
}
