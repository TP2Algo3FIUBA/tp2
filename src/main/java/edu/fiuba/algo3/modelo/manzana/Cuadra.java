package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.evento.Evento;
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

	public void moverVehiculo(Vehiculo vehiculoEnLaCuadra, Esquina esquinaInicio) {
		evento.afectarVehiculo(vehiculoEnLaCuadra);
		Esquina esquinaADestino = esquinaA;
		if (esquinaA.equals(esquinaInicio)) { // Checkear si esto viola "tell don't ask"
			esquinaADestino = esquinaB;
		}
		esquinaADestino.posicionarVehiculo(vehiculoEnLaCuadra);
	}
}
