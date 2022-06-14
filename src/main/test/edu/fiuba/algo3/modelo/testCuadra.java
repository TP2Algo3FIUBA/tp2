package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testCuadra {
    @Test
    public void unAutoSePuedeMoverDeUnaEsquinaAOtraAtravezandoUnaCuadra() {
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB);

        Jugador jugador = new Jugador(new Auto());
        jugador.spawnearVehiculoEn(esquinaA);

        cuadra.moverVehiculo(jugador, esquinaA);
        assertEquals(esquinaB, jugador.posicionActual());
    }

    @Test
    public void unAutoQueSeMuevePorUnaCuadraConUnPozoEsPenalizadoEnTresMovimientos(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, new Pozo());

        Jugador jugador = new Jugador(new Auto());
        jugador.spawnearVehiculoEn(esquinaA);

        cuadra.moverVehiculo(jugador, esquinaA);
        assertEquals(3, jugador.getMovimientos());
    }

    @Test
    public void unAutoQueSeMuevePorUnaCuadraConUnaSorpresaCambioDeVehiculoHaceQueSeCambieAUn4x4(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, new SorpresaCambioDeVehiculo());

        Jugador jugador = new Jugador(new Auto());
        jugador.spawnearVehiculoEn(esquinaA);

        cuadra.moverVehiculo(jugador, esquinaA);
        assertTrue(jugador.getVehiculo() instanceof CuatroPorCuatro);
    }
}
