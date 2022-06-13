package edu.fiuba.algo3.modelo.obstaculo;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Evento{
    public Piquete(){

    }

    @Override
    public void afectarVehiculo(Vehiculo vehiculoEnLaCuadra){
        vehiculoEnLaCuadra.chocarContraPiquete();
    }
}
