package edu.fiuba.algo3.modelo.evento;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;

public class GeneradorEventos {
	public GeneradorEventos() {
	}

	public static Evento generarEvento() {
		int tipoEvento = (int) (Math.random() * 10) + 1;
		int SubTipoEvento = (int) (Math.random() * 10) + 1;

		Evento eventoGenerado = null;
		if ( tipoEvento < 7 ) {
			eventoGenerado = new EventoVacio();
		}
		else if ( tipoEvento < 8 ) {
			if (SubTipoEvento < 5) {
				eventoGenerado = (Evento) new SorpresaFavorable();
			}
			else if (SubTipoEvento < 8) {
				eventoGenerado = (Evento) new SorpresaDesfavorable();
			}
			else eventoGenerado = (Evento) new SorpresaCambioDeVehiculo();
		}
		else {
			if (SubTipoEvento < 5) {
				eventoGenerado = (Evento) new Pozo();
			}
			else if (SubTipoEvento < 8) {
				eventoGenerado = (Evento) new ControlPolicial();
			}
			else eventoGenerado = (Evento) new Piquete();
		}
		return eventoGenerado;
	}
}