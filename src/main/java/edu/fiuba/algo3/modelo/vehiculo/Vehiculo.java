package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.sorpresa.Sorpresa;

public abstract class Vehiculo {
	
			public Jugador conductor;
			private Esquina esquinaActual;
			
			public Vehiculo() {
				conductor = null;
				esquinaActual = null;
			}
			
			public void incrementarMovimientos(int movimientos) {
				conductor.incrementarMovimientos(movimientos);
			}
					
			public Jugador getConductor() {
				return conductor;
			}

			public void setConductor(Jugador conductor) {
				this.conductor = conductor;
			}

			public void setEsquinaActual(Esquina esquinaActual) {
				this.esquinaActual = esquinaActual;
			}
			
			public void moverseAEsquina(String direccion) {
				this.esquinaActual.moverVehiculo(direccion);
			}

			public Esquina getEsquinaActual() {
				return esquinaActual;
			}
			

			
    

//		public abstract int atravezarObstaculo(Obstaculo unObstaculo);
//
//    public abstract int atravezarSorpresa(Sorpresa sorpresa);

}
