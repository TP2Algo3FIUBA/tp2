package edu.fiuba.algo3.modelo;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.EsquinaNoValidaException;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.EstadoCuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

class testVehiculo {
	@Test
	void testUnVehiculoDeberiaInicializarseConUnaEsquina() {
		Vehiculo vehiculo = new Vehiculo(new EstadoMoto() );
		assertTrue(vehiculo.getEsquinaActual() instanceof Esquina);
	}

	@Test
	void testSePuedeInicializarUnVehiculoConSuEsquinaValida() {
        Vehiculo vehiculo = new Vehiculo(new EstadoMoto() );

		vehiculo.setEsquinaActual(new Esquina());

		assertTrue(vehiculo.getEsquinaActual() instanceof Esquina);
	}

	@Test
	void testNoSePuedeInicializarUnVehiculoConUnaEsquinaNull(){
        Vehiculo vehiculo = new Vehiculo(new EstadoMoto() );

		assertThrows(EsquinaNoValidaException.class, ()-> vehiculo.setEsquinaActual(null));
	}

	@Test
	void testVehiculoPuedeMoverseDeUnaEsquinaAOtraEincrementaLosMovimientosDelJugador(){
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Cuadra cuadra = new Cuadra(inicio, destino);

		// Creo direcciones
		DirEste Este = new DirEste();

		inicio.insertarCuadra(Este, cuadra);

		Vehiculo vehiculo = new Vehiculo(new EstadoMoto());
        Jugador jugador = new Jugador( vehiculo );
		vehiculo.setEsquinaActual(inicio);
		vehiculo.moverseAEsquina(jugador, Este);

		assertEquals(vehiculo.getEsquinaActual(), destino);
		assertEquals(jugador.getMovimientos(), 1);
	}

	@Test
	public void testName4x4(){
		Vehiculo vehiculo = new Vehiculo(new EstadoCuatroPorCuatro());
		assertEquals(vehiculo.getEstadoName(), "4x4");
	}
	@Test
	public void testNamemoto(){
		Vehiculo vehiculo = new Vehiculo(new EstadoMoto());
		assertEquals(vehiculo.getEstadoName(), "moto");
	}
	@Test
	public void testNameauto(){
		Vehiculo vehiculo = new Vehiculo(new EstadoAuto());
		assertEquals(vehiculo.getEstadoName(), "auto");
	}
}
