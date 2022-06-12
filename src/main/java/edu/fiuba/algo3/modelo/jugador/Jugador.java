package edu.fiuba.algo3.modelo.jugador;


import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Jugador {
    private int movimientos = 0;
    private Vehiculo vehiculo;

    public Jugador (Vehiculo unVehiculo){
        vehiculo = unVehiculo;
    }
    
    public int getMovimientos() {
			return movimientos;
		}

		public void incrementarMovimientos(int movimientos){
    	this.movimientos += movimientos;
    }

//    public void movArriba (){
//        movimientos = movimientos + vehiculo.movArriba();
//    }
//    public void movAbajo(){
//        movimientos = movimientos + vehiculo.movAbajo();
//    }
//
//    public void movDerecha(){
//        movimientos = movimientos + vehiculo.movDerecha();
//    }
//
//    public void movIzquierda(){
//        movimientos = movimientos + vehiculo.movIzquierda();
//    }
//
//    public int cantidadDeMovimientos() {
//        return this.movimientos;
//    }
//
//    public int posicion() {
//        return vehiculo.posicion();
//    }
}
