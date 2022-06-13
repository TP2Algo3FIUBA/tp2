package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
	private int movimientos = 0;
	private Vehiculo vehiculo;

	public Jugador(Vehiculo unVehiculo) {
		vehiculo = unVehiculo;
	}

	public int getMovimientos() {
		return movimientos;
	}

	public void incrementarMovimientos(int movimientos) {
		this.movimientos += movimientos;
	}

	public void moverEnDireccion(String direccion) {
		vehiculo.moverseAEsquina(this, direccion); // ! raro
	}

	public Esquina posicionActual() {
		return vehiculo.getEsquinaActual();
	}

	public void spawnearVehiculoEn(Esquina unaEsquina) {
		vehiculo.setEsquinaActual(unaEsquina);
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void aplicarSorpresaCambioVehiculo() {
		Esquina posicionActual = vehiculo.getEsquinaActual(); //
		vehiculo = vehiculo.aplicarSorpresaCambioVehiculo();  // Raro? se resuelve poniendo la posicion dentro del jugador
		vehiculo.setEsquinaActual(posicionActual);		      //
	}
}
