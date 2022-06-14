package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.manzana.GeneradorTablero;
import edu.fiuba.algo3.modelo.manzana.Tablero;

class testGeneradorTablero {

	@Test
	void testGenerarTablero() {
		GeneradorTablero generadorTableroTest = new GeneradorTablero();
		int dimensions = 3;
		Tablero tableroTest = generadorTableroTest.generarTablero(dimensions);

		assertTrue(tableroTest instanceof Tablero);
	}
}