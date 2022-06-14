package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.juego.Juego;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.GeneradorTablero;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class testTablero {

	@Test
	void testAgregarUnaEsquinas() {
		Tablero tableroTest = new Tablero();
		Esquina esquinaTest = new Esquina();

		tableroTest.agregarEsquina(0, esquinaTest);

		assertEquals(tableroTest.obtenerEsquina(0, 0), esquinaTest);
	}

	@Test
	void testAgregarVariasEsquinas() {
		Tablero tableroTest = new Tablero();
		Esquina esquina1Test = new Esquina();
		Esquina esquina2Test = new Esquina();
		Esquina esquina3Test = new Esquina();

		tableroTest.agregarEsquina(0, esquina1Test);
		tableroTest.agregarEsquina(0, esquina2Test);
		tableroTest.agregarEsquina(1, esquina3Test);

		assertEquals(tableroTest.obtenerEsquina(0, 0), esquina1Test);
		assertEquals(tableroTest.obtenerEsquina(0, 1), esquina2Test);
		assertEquals(tableroTest.obtenerEsquina(1, 0), esquina3Test);
	}

	@Test
	void testPosicionarVehiculoEnElInicio() {
		Tablero tableroTest = GeneradorTablero.generarTablero(3);

        Jugador jugador = new Jugador(new Moto());

        Juego juego = new Juego(jugador, tableroTest);
        juego.spawnearJugadorEn(0,0);

		assertEquals(jugador.posicionActual(), tableroTest.obtenerEsquina(0,0));
	}
	
	@Test
	void testMoverVehiculo() {
        Tablero tableroTest = GeneradorTablero.generarTablero(3);

        Jugador jugador = new Jugador(new Moto());

        Juego juego = new Juego(jugador, tableroTest);
        juego.spawnearJugadorEn(0,0);

        juego.moverJugadorEnDireccion("Este");
        assertEquals(jugador.posicionActual(), tableroTest.obtenerEsquina(0,1));
	}
}
