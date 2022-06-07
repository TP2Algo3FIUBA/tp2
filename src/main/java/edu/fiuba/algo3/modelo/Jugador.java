package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Jugador {
    // supuesto
    private final ArrayList<Turno> turnos = new ArrayList<>();


    public Jugador (){
        for(int i = 0; i<10;i++){
            turnos.add(new Turno(new Habilitado()));
        }
    }

    public void turnosPenalizados(int i) {
        for(int j = 0; j<i;j++){
            turnos.add(new Turno(new Penalizado()));
        }
    }

    public int turnosPenalizados() {
        AtomicInteger turnosPenalizados= new AtomicInteger();
        turnos.forEach(turno -> {
            if (turno.estado().getPenalidad()){
                turnosPenalizados.getAndIncrement();
            }
        });
        return turnosPenalizados.intValue();
    }
}
