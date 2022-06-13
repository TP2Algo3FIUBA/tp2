package edu.fiuba.algo3.modelo.vehiculo;

import edu.fiuba.algo3.modelo.manzana.HayUnPiqueteException;

public class CuatroPorCuatro extends Vehiculo {

	private int pozosAtravezados;

	public CuatroPorCuatro() {
		super();
		this.pozosAtravezados = 0;
	}

	@Override
	public void chocarContraPozo(){
		this.pozosAtravezados++;
		if(this.pozosAtravezados==3){
			conductor.incrementarMovimientos(2);
		}
		conductor.incrementarMovimientos(0);
	}

	@Override
	public void chocarContraPiquete(){
		throw new HayUnPiqueteException();
	}

//	@Override
//	public int atravezarObstaculo(Obstaculo unObstaculo) {
//		return 0;
//	}
//
//	@Override
//	public int atravezarSorpresa(Sorpresa sorpresa) {
//		return 0;
//	}

	/*
	 * public int atravezarPozo() { this.pozosAtravezados ++;
	 * if(this.pozosAtravezados==3){ this.pozosAtravezados = 0; return 2; } return
	 * 0; }
	 */

}
