package edu.fiuba.algo3.modelo.vehiculo;

public class Moto extends Vehiculo {

	public Moto() {
		super();
	}

	@Override
	public void chocarContraPozo(){
		conductor.incrementarMovimientos(3);
	}

	@Override
	public void chocarContraPiquete(){ conductor.incrementarMovimientos(2); }

//	@Override
//	public int atravezarObstaculo(Obstaculo unObstaculo) {
//		return 0;
//	}
//
//	@Override
//	public int atravezarSorpresa(Sorpresa sorpresa) {
//		return 0;
//	}

}
