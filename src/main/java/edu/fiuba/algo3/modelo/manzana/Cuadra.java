package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.sorpresa.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Cuadra {
    //private Obstaculo obstaculo;
    //private Sorpresa sorpresa;
    private Esquina esquinaA;
    private Esquina esquinaB;
    private Obstaculo obstaculo;
    private Sorpresa sorpresa;

    public Cuadra(Esquina unaEsquinaA, String claveEsqA, Esquina unaEsquinaB, String claveEsqB, Obstaculo unObstaculo, Sorpresa unaSorpresa) {
        this.esquinaA = unaEsquinaA;
        this.esquinaB = unaEsquinaB;
        this.obstaculo = unObstaculo;
        this.sorpresa = unaSorpresa;

        esquinaA.insertarCuadra(claveEsqA, this);
        esquinaB.insertarCuadra(claveEsqB, this);
    }


    public int desplazar(Vehiculo unVehiculo, Esquina esquinaInicio) {
        int modificacionMovimientos = 1 + unVehiculo.atravezarObstaculo(obstaculo) + unVehiculo.atravezarSorpresa(sorpresa);

        if (esquinaA.equals(esquinaInicio) ) {
            esquinaB.posicionarVehiculo( unVehiculo );
            return modificacionMovimientos;
        }
        esquinaA.posicionarVehiculo( unVehiculo );
        return modificacionMovimientos;
    }
}
