package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.HashMap;

public class Esquina {
	private HashMap<String, Cuadra> cuadras;
	Vehiculo vehiculoEnLaEsquina;

	public Esquina() {
		this.cuadras = new HashMap<>();
		vehiculoEnLaEsquina = null;
	}

	public void moverVehiculo(String direccion) {
		Cuadra cuadraAdirijirse = cuadras.get(direccion);

		if (cuadraAdirijirse == null)
			throw new CuadraInexistenteException();

		vehiculoEnLaEsquina.incrementarMovimientos(1);
		cuadraAdirijirse.moverVehiculo(vehiculoEnLaEsquina, this);
		vehiculoEnLaEsquina = null;
	}

	public void posicionarVehiculo(Vehiculo unVehiculo) {
		vehiculoEnLaEsquina = unVehiculo;
	}

	public Vehiculo getVehiculoEnLaEsquina() {
		return vehiculoEnLaEsquina;
	}

	public void insertarCuadra(String direccion, Cuadra cuadra) {
		cuadras.put(direccion, cuadra);
	}
	
	public HashMap<String, Cuadra> getCuadras() { // TO-DO: remove later.
		return cuadras;
	}
}
