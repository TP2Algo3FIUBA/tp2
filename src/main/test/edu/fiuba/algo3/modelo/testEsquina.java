package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.evento.EventoVacio;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Moto;

class testEsquina {

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

    /*@Test
    void testmoverVehiculoADireccionInvalida() {
        // implementar
    }*/
}
