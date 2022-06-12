package tablerostest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.GeneradorTablero;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

class TableroTest {

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
		Vehiculo moto = new Moto();
		tableroTest.posicionarEnInicioVehiculo(moto);

		Esquina esquinaInicio = tableroTest.obtenerEsquina(0, 0);

		assertEquals(esquinaInicio.getVehiculoEnLaEsquina(), moto);
	}
	
	@Test
	void testMoverVehiculo() {
		Tablero tableroTest = GeneradorTablero.generarTablero(3);
		
		Vehiculo moto = new Moto();
		Jugador conductor = new Jugador(moto);
		moto.setConductor(conductor);
		tableroTest.posicionarEnInicioVehiculo(moto);
		
		Esquina esquinaInicio = moto.getEsquinaActual();
		moto.moverseAEsquina("Este");
		Esquina esquinaDestino = moto.getEsquinaActual();
		
		assertEquals(esquinaInicio.getVehiculoEnLaEsquina(), null);
		assertEquals(esquinaDestino.getVehiculoEnLaEsquina(), moto);
	}
}
