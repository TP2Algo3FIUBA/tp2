package edu.fiuba.algo3.modelo.manzana;

import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.HashMap;

public class Esquina {

    private int coordenada; // fila + columna*10
    private HashMap<String, Cuadra>cuadras;
    public Esquina(int unaCoordenada) {
        // Inicializo las Cuadras como vacias
        this.coordenada = unaCoordenada;
        this.cuadras = new HashMap<>();
    }

    public void arribar(Vehiculo unVehiculo) {
        //this.cuadra.trancita(unVehiculo);
    }

    public int coordenada() {
        return this.coordenada;
    }

    public int dirijirseAPos(String direccion,Vehiculo vehiculo) {
        Cuadra cuadraDireccion = cuadras.get(direccion);
        return cuadraDireccion.desplazar(vehiculo, this);
    }

    public void posicionarVehiculo(Vehiculo unVehiculo) {
        unVehiculo.actualizarPosicion(this);
    }

    public void insertarCuadra(String direccion, Cuadra cuadra) {
        cuadras.put(direccion, cuadra);
    }
}
