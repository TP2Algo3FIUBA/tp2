package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Impar;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.Movimiento;
import edu.fiuba.algo3.modelo.jugador.Par;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;

public class Sorpresata  implements Evento {
	private Jugador jugador;

	public Sorpresata() {

    }

	@Override
	public Esquina afectarJugador(Jugador jugador, Esquina esquinaInicio, Esquina esquinaDestino) {
		this.jugador = jugador;
		return jugador.aplicarSorpresata(this, esquinaInicio, esquinaDestino);
	}

	@Override
	public String getName() {
		return "sorpresata";//"sorpresacambiovehiculo";
	}

}
