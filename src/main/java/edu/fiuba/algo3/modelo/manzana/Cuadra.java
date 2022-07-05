package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observer;

import java.util.ArrayList;

public class Cuadra implements Observable {
	private final Esquina esquinaA;
	private final Esquina esquinaB;
    private Evento evento = new EventoVacio();

	// Agregado para la interfaz
	private ArrayList<Observer> observers;
	private Position position;

	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB, Evento unEvento) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.evento = unEvento;
		this.position = new Position(0, 0);
		observers = new ArrayList<Observer>();
	}

	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.position = new Position(0, 0);
		observers = new ArrayList<Observer>();
	}

	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB, Evento unEvento, int posFil, int posCol) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.evento = unEvento;
		this.position = new Position(posFil, posCol);
		observers = new ArrayList<Observer>();
	}

	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB, int posFil, int posCol) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.position = new Position(posFil, posCol);
		observers = new ArrayList<Observer>();
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
		System.out.println("Nueva ubicacion del jugador: Fil:" + esquinaDestino.getPosition().getFil() + " Col:" + esquinaDestino.getPosition().getCol());
	}

    public Evento getObstaculo() {
		return this.evento;
    }

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
		notifyObservers();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers() {
		observers.stream().forEach(observer -> observer.change());
	}

	public String getCuadraName() {
		return "pozo"; // aca tiene que devolver el nombre del evento
	}
}
