package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.HashMap;

public class Esquina {
	private HashMap<String, Cuadra> cuadras;
	Vehiculo vehiculoEnLaEsquina;

	public Esquina(int unaCoordenada) {
		this.cuadras = new HashMap<>();
		vehiculoEnLaEsquina = null;
	}

	public void dirijirseACuadra(String direccion, Vehiculo vehiculo) {
		Cuadra cuadraAdirijirse;
		try {
			cuadraAdirijirse = cuadras.get(direccion);
			vehiculoEnLaEsquina.incrementarMovimientos(1);
			cuadraAdirijirse.moverVehiculo(vehiculoEnLaEsquina);
			vehiculoEnLaEsquina = null;
		} catch (Exception e) { // TO DO: checkear el tipo de exception exacto que tira esto
			// se intento mover fuera del tablero
		}
	}

	public void posicionarVehiculo(Vehiculo unVehiculo) {
		vehiculoEnLaEsquina = unVehiculo;
	}

	public void insertarCuadra(String direccion, Cuadra cuadra) {
		cuadras.put(direccion, cuadra);
	}
}
