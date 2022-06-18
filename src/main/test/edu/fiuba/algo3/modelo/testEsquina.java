package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.direcciones.DirEste;
import edu.fiuba.algo3.direcciones.DirNorte;
import edu.fiuba.algo3.direcciones.DirOeste;
import edu.fiuba.algo3.direcciones.DirSur;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class testEsquina {

	@Test
	void testmoverVehiculoADireccionValida() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 ---- 01
        Esquina esquina01 = new Esquina();

		// Creo direcciones
		DirEste Este = new DirEste();
		DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01);
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador(new Moto());
        jugador.spawnearVehiculoEn(esquina00);

        // Act
        jugador.moverEnDireccion(Este);

        // Assert
        assertEquals(jugador.posicionActual(), esquina01);
	}
	
	@Test
	void testPosicionarVehiculo() {
		Esquina esquina = new Esquina();
		Jugador jugador = new Jugador(new Moto());
		jugador.spawnearVehiculoEn(esquina);

		assertEquals(jugador.posicionActual(), esquina);
	}

	
	@Test
	void testMoverVehiculoYVolverAEsquinaDeInicio() {
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Cuadra cuadra = new Cuadra(inicio, destino);
		Jugador jugador = new Jugador(new Moto());

		// Creo direcciones
		DirNorte Norte = new DirNorte();
		DirSur Sur = new DirSur();

		inicio.insertarCuadra(Sur, cuadra);
		destino.insertarCuadra(Norte, cuadra);
		jugador.spawnearVehiculoEn(inicio);

		assertEquals(jugador.posicionActual(), inicio);

		jugador.moverEnDireccion(Sur);

		assertEquals(jugador.posicionActual(), destino);
		
		jugador.moverEnDireccion(Norte);
		
		assertEquals(jugador.posicionActual(), inicio);
	}

	@Test
	void testMoverVehiculoACuadraInvalida() {
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Cuadra cuadra = new Cuadra(inicio, destino);
		Jugador jugador = new Jugador(new Moto());

		// Creo direcciones
		DirNorte Norte = new DirNorte();
		DirSur Sur = new DirSur();
		DirEste Este = new DirEste();

		inicio.insertarCuadra(Sur, cuadra);
		destino.insertarCuadra(Norte, cuadra);
		jugador.spawnearVehiculoEn(inicio);

		assertThrows(CuadraInexistenteException.class, () -> {
			jugador.moverEnDireccion(Este);
		});

	}

}
