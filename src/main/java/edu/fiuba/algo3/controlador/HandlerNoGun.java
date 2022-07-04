package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modeloOpcional.NoGun;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class HandlerNoGun implements EventHandler<ActionEvent> {

  private Jugador player;

  public HandlerNoGun(Jugador player) {
    this.player = player;
  }

  public void handle(ActionEvent event) {
    NoGun gun = new NoGun();
   // player.changeAttackStrategy(gun);

  }
}