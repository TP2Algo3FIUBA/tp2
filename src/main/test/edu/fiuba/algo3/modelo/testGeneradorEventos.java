package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.GeneradorEventos;

class testGeneradorEventos {

	@Test
	void testGenerarUnEvento() {
		GeneradorEventos generador = new GeneradorEventos();
		
		Evento evento = generador.generarEvento();
		
		assertTrue(evento instanceof Evento);
	}

	@Test
	void testEventoVacio(){

		Evento evento = new EventoVacio();
		Jugador jugador = new Jugador(new Auto());

		assertEquals(evento.afectarJugador(jugador), true);

	}
}
