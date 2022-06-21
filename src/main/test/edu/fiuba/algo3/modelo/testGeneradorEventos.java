package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.direcciones.DirEste;
import edu.fiuba.algo3.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
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
	void testEventoVacioPermiteAvanzarAJugador(){
        Esquina esquinaA = new Esquina();
        Esquina esquinaB = new Esquina();
        Evento evento = new EventoVacio();
        Cuadra cuadra = new Cuadra(esquinaA, esquinaB, evento);

        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();
        esquinaA.insertarCuadra(Este, cuadra);
        esquinaB.insertarCuadra(Oeste, cuadra);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquinaA);

        jugador.moverEnDireccion(Este);
		assertEquals(esquinaB, jugador.posicionActual());

	}
}
