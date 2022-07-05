package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;

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
		if (esquinaA.equals(esquinaRecibida)) { 
			esquinaADestino = esquinaB;
		}
		return esquinaADestino;
	}

	public void moverVehiculo(Jugador jugador, Esquina esquinaInicio) {

		//Esquina esquinaDestino = this.obtenerEsquinaOpuesta(esquinaInicio);
		//jugador.setEsquinaActual(evento.afectarJugador(jugador, esquinaInicio, esquinaDestino));

		Esquina esquinaOpuesta = this.obtenerEsquinaOpuesta(esquinaInicio);
		Esquina esquinaDestino = evento.afectarJugador(jugador, esquinaInicio, esquinaOpuesta);
		jugador.setEsquinaActual(esquinaDestino);
		jugador.setPosition(esquinaDestino.getPosition());
		System.out.println("Nueva ubicacion del jugador: X:" + esquinaDestino.getPosition().getX() + " Y:" + esquinaDestino.getPosition().getY());
	}

    public Evento getObstaculo() {
		return this.evento;
    }
}
