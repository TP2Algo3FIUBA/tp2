package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.manzana.*;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;

class testTablero {

	@Test
	void testAgregarUnaEsquinas() {
		Tablero tableroTest = new Tablero();
		Esquina esquinaTest = new Esquina();

		tableroTest.agregarEsquina(0, esquinaTest);

		assertEquals(tableroTest.obtenerEsquina(0, 0), esquinaTest);
	}
	@Test
	void testAgregarUnaEsquinas2() {
		Tablero tableroTest = new Tablero(2,2);
		Esquina esquinaTest = new Esquina();

		tableroTest.agregarEsquina(0, esquinaTest);
		tableroTest.generarTablero();
		assertEquals(tableroTest.obtenerEsquina(0, 0), esquinaTest);

		assertTrue(tableroTest.obtenerCuadra(2) instanceof Cuadra);

		tableroTest.agregarEsquina(2,new Esquina(new NoMeta(),3,3));
		tableroTest.agregarCuadra(new Cuadra(new Esquina(),new Esquina()));

		assertEquals(tableroTest.cantididadCuadras(),5);

		assertEquals(tableroTest.getHeigth(),2);
		assertEquals(tableroTest.getWidth(),2);
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

		Jugador jugador = new Jugador(new Vehiculo( new EstadoAuto() ));

		Juego juego = new Juego(jugador, tableroTest);
		juego.spawnearJugadorEn(0, 0);

		assertEquals(jugador.posicionActual(), tableroTest.obtenerEsquina(0, 0));
	}

	@Test
	void testMoverVehiculo() {
		Tablero tableroTest = GeneradorTablero.generarTablero(3);

		Jugador jugador = new Jugador(new Vehiculo( new EstadoMoto() ));

		Juego juego = new Juego(jugador, tableroTest);
		juego.spawnearJugadorEn(0, 0);

		// Creo direcciones
		DirEste Este = new DirEste();

		juego.moverJugadorEnDireccion(Este);
		assertEquals(jugador.posicionActual(), tableroTest.obtenerEsquina(0, 1));
	}
}
