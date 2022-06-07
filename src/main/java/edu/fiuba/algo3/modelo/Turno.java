package edu.fiuba.algo3.modelo;

public class Turno {

    private Estado estado;

    public Turno(Estado habilitado) {
        this.estado = habilitado;
    }

    public void estadoPenalizado(int i) {
        estado = new Penalizado();

    }
    public Estado estado(){
        return estado;
    }
}
