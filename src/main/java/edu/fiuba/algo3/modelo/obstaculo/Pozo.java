package edu.fiuba.algo3.modelo.obstaculo;


import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Pozo implements Evento{


    public Pozo(){

    }

    @Override
    public void afectarVehiculo(Vehiculo vehiculo){
    	vehiculo.chocarContraPozo();
    }

}
