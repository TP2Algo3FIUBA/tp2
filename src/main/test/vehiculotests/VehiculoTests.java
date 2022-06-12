package vehiculotests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class VehiculoTests {

	@Test
	void testSettearUnConductor() {
		Moto moto = new Moto();
		Jugador conductor = new Jugador(moto);
		moto.setConductor(conductor);
		
		assertEquals(moto.getConductor(), conductor);
	}

}
