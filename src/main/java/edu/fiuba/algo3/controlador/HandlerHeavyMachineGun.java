package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modeloOpcional.HeavyMachineGun;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


;

public class HandlerHeavyMachineGun implements EventHandler<ActionEvent> {

    private Jugador player;

    public HandlerHeavyMachineGun(Jugador player) {
        this.player = player;
    }

    public void handle(ActionEvent event) {
        HeavyMachineGun gun = new HeavyMachineGun();
        //player.changeAttackStrategy(gun);

    }
}