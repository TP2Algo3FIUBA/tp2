package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.direcciones.Direccion;
import edu.fiuba.algo3.modelo.jugador.Jugador;

import java.util.HashMap;

public class Esquina {
	private final HashMap<String, Cuadra> cuadras;
	private EstadoEsquina estado;
	
//	private Jugador jugadorEnLaEsquina;
	
	public Esquina() {
		this.cuadras = new HashMap<>();
		this.estado = new NoMeta();
//		jugadorEnLaEsquina = null;
	}

	public Esquina(EstadoEsquina estado) {
		this.cuadras = new HashMap<>();
		this.estado = estado;
//		jugadorEnLaEsquina = null;
	}

	public void moverVehiculo(Jugador jugador, Direccion direccion) {
//		System.out.println(direccion.toString());

		Cuadra cuadraAdirijirse = cuadras.get(direccion.toString());
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
	
	public EstadoEsquina checkearEstado() {
		return estado;
	}
}
