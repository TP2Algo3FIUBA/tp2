package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Esquina {

    private final Cuadra cuadra;


    public Esquina(Cuadra unaCuadra) {
        this.cuadra = unaCuadra;
    }

    public void arribar(Vehiculo unVehiculo) {
        this.cuadra.trancita(unVehiculo);
    }
}
