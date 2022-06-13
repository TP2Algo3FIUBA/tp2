package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.HashMap;

public class Esquina {
	private HashMap<String, Cuadra> cuadras;

	public Esquina() {
		this.cuadras = new HashMap<>();
	}

	public void moverVehiculo(Jugador jugador, String direccion) {

		Cuadra cuadraAdirijirse = cuadras.get(direccion);
		if (cuadraAdirijirse == null)
			throw new CuadraInexistenteException();

		jugador.incrementarMovimientos(1);

		cuadraAdirijirse.moverVehiculo(jugador, this);
	}

	public void insertarCuadra(String direccion, Cuadra cuadra) {
		cuadras.put(direccion, cuadra);
	}
	
	public HashMap<String, Cuadra> getCuadras() { // TO-DO: remove later.
		return cuadras;
	}
}
