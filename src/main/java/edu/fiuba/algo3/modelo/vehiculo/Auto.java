package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.manzana.CuadraInexistenteException;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.HayUnPiqueteException;

public class Auto extends Vehiculo {

	public Auto() {
		super();
	}

	@Override
	public void chocarContraPozo(){
		conductor.incrementarMovimientos(3);
	}

	@Override
	public void chocarContraPiquete(){
		throw new HayUnPiqueteException();
	}

//	@Override
//	public int atravezarObstaculo(Obstaculo unObstaculo) {
//		return 3;
//	}
//
//	@Override
//	public int atravezarSorpresa(Sorpresa sorpresa) {
//		return 0;
//	}

}
