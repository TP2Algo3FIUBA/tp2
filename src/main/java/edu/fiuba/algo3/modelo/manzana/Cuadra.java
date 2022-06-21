package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Cuadra {
	private final Esquina esquinaA;
	private final Esquina esquinaB;
    private Evento evento = new EventoVacio();


	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB, Evento unEvento) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.evento = unEvento;
	}

	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
	}

	private Esquina obtenerEsquinaOpuesta(Esquina esquinaRecibida) {
		Esquina esquinaADestino = esquinaA;
		if (esquinaA.equals(esquinaRecibida)) { // Checkear si esto viola "tell don't ask"
			esquinaADestino = esquinaB;
		}
		return esquinaADestino;
	}

	public void moverVehiculo(Jugador jugador, Esquina esquinaInicio) {

		evento.afectarJugador(jugador);  // <-- exception piquete
		if (1 > 0) { // aca estaba el if puedeavanzar
			Esquina esquinaADestino = this.obtenerEsquinaOpuesta(esquinaInicio);
			Vehiculo vehiculoActual = jugador.getVehiculo();
			vehiculoActual.setEsquinaActual(esquinaADestino);
		}
	}
}
