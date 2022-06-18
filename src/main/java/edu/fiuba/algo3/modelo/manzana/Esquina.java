package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.HashMap;

public class Esquina {
	private final HashMap<String, Cuadra> cuadras;
//	private Jugador jugadorEnLaEsquina;

	public Esquina() {
		this.cuadras = new HashMap<>();
//		jugadorEnLaEsquina = null;
	}

	public void moverVehiculo(Jugador jugador, Direccion direccion) {

		Cuadra cuadraAdirijirse = cuadras.get(String.valueOf(direccion));
		if (cuadraAdirijirse == null) {
			throw new CuadraInexistenteException();
//			return;
		}

		jugador.incrementarMovimientos(1);

		cuadraAdirijirse.moverVehiculo(jugador, this);
	}

	public void insertarCuadra(Direccion direccion, Cuadra cuadra) {
		cuadras.put(String.valueOf(direccion), cuadra);
	}

}
