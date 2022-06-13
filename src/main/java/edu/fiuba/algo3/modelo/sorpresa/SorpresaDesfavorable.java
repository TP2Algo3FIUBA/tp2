package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class SorpresaDesfavorable implements Evento{
    public SorpresaDesfavorable() {

    }

		@Override
		public void afectarVehiculo(Vehiculo vehiculo) {
			vehiculo.sorpresaFavorable();
			
		}
}
