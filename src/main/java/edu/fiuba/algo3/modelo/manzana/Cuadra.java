package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Cuadra {
	private Esquina esquinaA;
	private Esquina esquinaB;
    private Evento evento;


	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB, Evento unEvento) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.evento = unEvento;
	}

	private Esquina obtenerEsquinaOpuesta(Esquina esquinaRecibida) {
		Esquina esquinaADestino = esquinaA;
		if (esquinaA.equals(esquinaRecibida)) { // Checkear si esto viola "tell don't ask"
			esquinaADestino = esquinaB;
		}
		return esquinaADestino;
	}

	public void moverVehiculo(Jugador jugador, Esquina esquinaInicio) {

		/*
			Pozo: suma movimientos
			!!! Piquete: autos y 4x4 no pueden atravezar !!!
			Control policial: suma movimientos

			Sorpresa favorable: resta movimientos
			Sorpresa desfavorable: suma movimientos
			!!! Cambio de vehiculo: se explica solo !!! jugador.cambiarVehiculo();
		 */

		boolean puedeAvanzar = evento.afectarJugador(jugador);  // <-- exception piquete
		if (puedeAvanzar) {
			Esquina esquinaADestino = this.obtenerEsquinaOpuesta(esquinaInicio);
			Vehiculo vehiculoActual = jugador.getVehiculo();
			vehiculoActual.setEsquinaActual(esquinaADestino);
		}
	}
}
