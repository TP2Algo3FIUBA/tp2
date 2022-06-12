package edu.fiuba.algo3.modelo.manzana;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Tablero {
	ArrayList<ArrayList<Esquina>> filas = new ArrayList(); // TO DO cambiar nombre a esquinas o algo mejor

	public Tablero() {
	}

	public Esquina obtenerEsquina(int fila, int columna) {
		return ((filas.get(fila)).get(columna));
	}

	public void agregarEsquina(int fila, Esquina nuevaEsquina) {
		if (filas.size() < fila + 1)
			filas.add(new ArrayList<Esquina>());

		filas.get(fila).add(nuevaEsquina);
	}

	public void posicionarEnInicioVehiculo(Vehiculo vehiculo) {
		Esquina esquinaInicio = (filas.get(0)).get(0);
		esquinaInicio.posicionarVehiculo(vehiculo);
		vehiculo.setEsquinaActual(esquinaInicio); 
	}
}
