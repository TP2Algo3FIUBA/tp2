package edu.fiuba.algo3.modelo.esquinatest;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class EsquinaTest {

	@Test
	void testmoverVehiculoADireccionValida() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 ---- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new EventoVacio());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Moto());
        jugador.spawnearVehiculoEn(esquina00);

        // Act
        jugador.moverEnDireccion("Este");

        // Assert
        assertEquals(jugador.posicionActual(), esquina01);
	}

    void testmoverVehiculoADireccionInvalida() {
        // implementar
    }
}
