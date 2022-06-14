package edu.fiuba.algo3.modelo;
import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.EsquinaNoValidaException;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

class testVehiculo {
	@Test
	void testUnVehiculoDeberiaInicializarseConUnaEsquina() {
		Moto moto = new Moto();

		assertTrue(moto.getEsquinaActual() instanceof Esquina);
	}
	@Test
	void testSePuedeInicializarUnVehiculoConSuEsquinaValida() {
		Moto moto = new Moto();

		moto.setEsquinaActual(new Esquina());

		assertTrue(moto.getEsquinaActual() instanceof Esquina);
	}

	@Test
	void testNoSePuedeInicializarUnVehiculoConUnaEsquinaNull(){
		Moto moto = new Moto();

		assertThrows(EsquinaNoValidaException.class, ()-> moto.setEsquinaActual(null));
	}

	@Test
	void testVehiculoPuedeMoverseDeUnaEsquinaAOtraEincrementaLosMovimientosDelJugador(){
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Cuadra cuadra = new Cuadra(inicio, destino);
		inicio.insertarCuadra("Este", cuadra);

		Moto moto = new Moto();
		Jugador jugador = new Jugador(moto);
		moto.setEsquinaActual(inicio);
		moto.moverseAEsquina(jugador, "Este");

		assertEquals(moto.getEsquinaActual(), destino);
		assertEquals(jugador.getMovimientos(), 1);
	}


}
