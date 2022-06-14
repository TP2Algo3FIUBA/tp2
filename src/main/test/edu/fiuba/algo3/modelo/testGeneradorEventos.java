package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

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

}
