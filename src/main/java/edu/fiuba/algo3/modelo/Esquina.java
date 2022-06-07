package edu.fiuba.algo3.modelo;

public class Esquina {

    private final Cuadra cuadra;


    public Esquina(Cuadra unaCuadra) {
        this.cuadra = unaCuadra;
    }

    public void arribar(Moto moto) {
        this.cuadra.trancita(moto);
    }
}
