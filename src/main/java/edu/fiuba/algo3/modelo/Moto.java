package edu.fiuba.algo3.modelo;

public class Moto extends Vehiculo{
    private final Jugador conductor;

    public Moto(Jugador jugaddor) {
        this.conductor = jugaddor;

    }

    @Override
    public int aplicarPenalizacion(Pozo obstaculo) {
        return -3;
    }

    @Override
    public void mover(Esquina esquina) {
        esquina.arribar(this);
    }

    @Override
    public void turnosPenalizadosAConductor(int i) {
        this.conductor.turnosPenalizados(i);

    }

    public int turnosPenalizados() {
        return conductor.turnosPenalizados();
    }
}
