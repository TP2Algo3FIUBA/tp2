package esquinatest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class EsquinaTest {

	@Test
	void testPosicionarVehiculo() {
		Esquina cuadra = new Esquina();
		Moto moto = new Moto();
		cuadra.posicionarVehiculo(moto);

		assertEquals(cuadra.getVehiculoEnLaEsquina(), moto);
	}

	@Test
	void testMoverVehiculo() {
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Pozo pozo = new Pozo();
		Cuadra cuadra = new Cuadra(inicio, destino, pozo);
		Moto moto = new Moto();
		Jugador conductor = new Jugador(moto);
		moto.setConductor(conductor);

		inicio.insertarCuadra("Sur", cuadra);
		destino.insertarCuadra("Norte", cuadra);
		inicio.posicionarVehiculo(moto);

		assertEquals(inicio.getVehiculoEnLaEsquina(), moto);
		assertEquals(destino.getVehiculoEnLaEsquina(), null);

		moto.moverseAEsquina("Sur");

		assertEquals(inicio.getVehiculoEnLaEsquina(), null);
		assertEquals(destino.getVehiculoEnLaEsquina(), moto);
	}

	@Test
	void testMoverVehiculoACuadraInvalida() {
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Cuadra cuadra = new Cuadra(inicio, destino,  null);
		Moto moto = new Moto();
		Jugador conductor = new Jugador(moto);
		moto.setConductor(conductor);

		inicio.insertarCuadra("Sur", cuadra);
		destino.insertarCuadra("Norte", cuadra);
		inicio.posicionarVehiculo(moto);

		assertThrows(CuadraInexistenteException.class, () -> {
			inicio.moverVehiculo("Este");
		});

	}

}