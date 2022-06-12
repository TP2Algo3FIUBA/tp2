package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.sorpresa.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Cuadra {
	private Esquina esquinaA;
	private Esquina esquinaB;
//    private Evento evento;
	private Obstaculo obstaculo;
	private Sorpresa sorpresa;

	public Cuadra(Esquina unaEsquinaA, Esquina unaEsquinaB, Obstaculo unObstaculo, Sorpresa unaSorpresa) {
		this.esquinaA = unaEsquinaA;
		this.esquinaB = unaEsquinaB;
		this.obstaculo = unObstaculo;
		this.sorpresa = unaSorpresa;
	}
	
	public void moverVehiculo(Vehiculo vehiculoEnLaCuadra, Esquina esquinaInicio) { 
//		evento.afectarVehiculo(vehiculoEnLaCuadra);
		Esquina esquinaADestino = esquinaA;
		if (esquinaA.equals(esquinaInicio)) { // Checkear si esto viola "tell don't ask"
			esquinaADestino = esquinaB;
		}
		esquinaADestino.posicionarVehiculo(vehiculoEnLaCuadra);
	}
}
