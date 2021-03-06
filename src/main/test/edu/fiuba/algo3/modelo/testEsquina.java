package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;

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

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquina00);

        // Act
        jugador.moverEnDireccion(Este);

        // Assert
        assertEquals(jugador.posicionActual(), esquina01);
	}
	
	@Test
	void testPosicionarVehiculo() {
		Esquina esquina = new Esquina();
        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
		jugador.spawnearVehiculoEn(esquina);

		assertEquals(jugador.posicionActual(), esquina);
	}

	
	@Test
	void testMoverVehiculoYVolverAEsquinaDeInicio() {
		Esquina inicio = new Esquina();
		Esquina destino = new Esquina();
		Cuadra cuadra = new Cuadra(inicio, destino);
        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );

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
        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );

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

	@Test
	public void positionEsquina(){
		Esquina esquina = new Esquina();
		Position pos = new Position(0,0);
		Position pos2 = new Position(1,0);

		assertEquals(esquina.getPosition().getCol(),pos.getCol());
		esquina.setPosition(pos2);
		assertEquals(esquina.getPosition().getFil(),pos2.getFil());
	}

}
