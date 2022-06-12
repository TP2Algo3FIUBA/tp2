package tablerostest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.manzana.GeneradorTablero;
import edu.fiuba.algo3.modelo.manzana.Tablero;

class GeneradorTableroTest {

	@Test
	void testGenerarTablero() {
		GeneradorTablero generadorTableroTest = new GeneradorTablero();
		int dimensions = 3;
		Tablero tableroTest = generadorTableroTest.generarTablero(dimensions);
		
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				System.out.println("Esquina: (" + i + ", " + j + "):");
				System.out.println((tableroTest.obtenerEsquina(i, j)).getCuadras());
			}
		}
		// TO-DO: add assertion later.
	}

}
