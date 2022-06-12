package jugadortest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class JugadorTest {

	@Test
	void testIncrementarMovimientos() {
		Moto moto = new Moto();
		Jugador conductor = new Jugador(moto);
		moto.setConductor(conductor);
		moto.incrementarMovimientos(5);
		
		assertEquals(conductor.getMovimientos(), 5);
	}

}
