package edu.fiuba.algo3.modelo.manzana;

//import Eventos.Evento;

//import Eventos.GeneradorEventos;

public class GeneradorTablero { // TO DO: que esto una clase con solo metodos de clase.
	
	static final String NORTE = "Norte";
	static final String SUR = "Sur";
	static final String ESTE = "Este";
	static final String OESTE = "Oeste";

	private static void generarEsquinas(int dimensiones, Tablero nuevoTablero) {

		for (int filaActual = 0; filaActual < dimensiones; filaActual++) {
			for (int columnaActual = 0; columnaActual < dimensiones; columnaActual++) {
				Esquina esquina = new Esquina();
				nuevoTablero.agregarEsquina(filaActual, esquina);
			}
		}
	}
	
	private static void generarCuadras(int dimensiones, Tablero nuevoTablero) {

		for (int filaActual = 0; filaActual < dimensiones; filaActual++) {
			for (int columnaActual = 0; columnaActual < dimensiones; columnaActual++) {
				Esquina esquinaInicio = nuevoTablero.obtenerEsquina(filaActual, columnaActual);
				Esquina esquinaDestino;
//				Evento evento = generadorEventos.generarEvento();

				if (filaActual != 0) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual - 1, columnaActual);
					Cuadra nuevaCuadraInicioADestino = new Cuadra(esquinaInicio, esquinaDestino, null); // y aca en lugar de un obstaculo le pasas un evento
					esquinaInicio.insertarCuadra(NORTE, nuevaCuadraInicioADestino);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio, null);
					esquinaDestino.insertarCuadra(SUR, nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != 0) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual, columnaActual - 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  null);
					esquinaInicio.insertarCuadra(OESTE, nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  null);
					esquinaDestino.insertarCuadra(ESTE, nuevaCuadraDestinoAInicio);
				}

				if (filaActual != dimensiones - 1) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual + 1, columnaActual);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  null);
					esquinaInicio.insertarCuadra(SUR, nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  null);
					esquinaDestino.insertarCuadra(NORTE, nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != dimensiones - 1) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual, columnaActual + 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  null);
					esquinaInicio.insertarCuadra(ESTE, nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  null);
					esquinaDestino.insertarCuadra(OESTE, nuevaCuadraDestinoAInicio);
				}
			}
		}
	}

	public static Tablero generarTablero(int dimensiones) {
		Tablero nuevoTablero = new Tablero();
		generarEsquinas(dimensiones, nuevoTablero);
		generarCuadras(dimensiones, nuevoTablero);

		return nuevoTablero;
	}
}