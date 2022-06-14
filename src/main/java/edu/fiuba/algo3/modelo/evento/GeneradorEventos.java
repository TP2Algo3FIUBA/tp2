package edu.fiuba.algo3.modelo.evento;

import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;

public class GeneradorEventos {
	public GeneradorEventos() {
	}

	public static Evento generarEvento() {
		int tipoEvento = (int) (Math.random() * 3) + 1;
		int SubTipoEvento = (int) (Math.random() * 3) + 1;
		System.out.println("evento: " + tipoEvento);

		Evento eventoGenerado = null;
		switch (tipoEvento) {
		case 1:
			switch (SubTipoEvento) {
			case 1:
				eventoGenerado = (Evento) new SorpresaFavorable();
				break;
			case 2:
				eventoGenerado = (Evento) new SorpresaDesfavorable();
				break;

			}

		case 2:
			switch (SubTipoEvento) {
			case 1:
				eventoGenerado = (Evento) new Pozo();
			case 2:
				eventoGenerado = (Evento) new Piquete();
				break;
			case 3:
				eventoGenerado = (Evento) new ControlPolicial();
				break;
			}
			
		case 3:
			eventoGenerado = new EventoVacio();
			break;
		}

		return eventoGenerado;
	}
}