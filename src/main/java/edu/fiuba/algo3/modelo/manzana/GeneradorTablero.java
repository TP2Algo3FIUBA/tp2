package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.direcciones.DirEste;
import edu.fiuba.algo3.direcciones.DirNorte;
import edu.fiuba.algo3.direcciones.DirOeste;
import edu.fiuba.algo3.direcciones.DirSur;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.evento.GeneradorEventos;

//import Eventos.Evento;

//import Eventos.GeneradorEventos;

public class GeneradorTablero { // TO DO: que esto una clase con solo metodos de clase.
	
	static final DirNorte NORTE = new DirNorte();
	static final DirSur SUR = new DirSur();
	static final DirEste ESTE = new DirEste();
	static final DirOeste OESTE = new DirOeste();

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
				Evento evento = GeneradorEventos.generarEvento();

				if (filaActual != 0) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual - 1, columnaActual);
					Cuadra nuevaCuadraInicioADestino = new Cuadra(esquinaInicio, esquinaDestino, evento); // y aca en lugar de un obstaculo le pasas un evento
					esquinaInicio.insertarCuadra(NORTE, nuevaCuadraInicioADestino);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio, evento);
					esquinaDestino.insertarCuadra(SUR, nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != 0) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual, columnaActual - 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento);
					esquinaInicio.insertarCuadra(OESTE, nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento);
					esquinaDestino.insertarCuadra(ESTE, nuevaCuadraDestinoAInicio);
				}

				if (filaActual != dimensiones - 1) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual + 1, columnaActual);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento);
					esquinaInicio.insertarCuadra(SUR, nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento);
					esquinaDestino.insertarCuadra(NORTE, nuevaCuadraDestinoAInicio);
				}

				if (columnaActual != dimensiones - 1) {
					esquinaDestino = nuevoTablero.obtenerEsquina(filaActual, columnaActual + 1);
					Cuadra nuevaCuadra = new Cuadra(esquinaInicio, esquinaDestino,  evento);
					esquinaInicio.insertarCuadra(ESTE, nuevaCuadra);

					Cuadra nuevaCuadraDestinoAInicio = new Cuadra(esquinaDestino, esquinaInicio,  evento);
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