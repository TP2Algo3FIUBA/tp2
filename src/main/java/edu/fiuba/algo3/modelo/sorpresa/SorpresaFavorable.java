package edu.fiuba.algo3.modelo.sorpresa;
import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class SorpresaFavorable implements Evento{
    public SorpresaFavorable () {

    }

		@Override
		public void afectarVehiculo(Vehiculo vehiculo) {
			vehiculo.sorpresaFavorable();
			
		}
}
