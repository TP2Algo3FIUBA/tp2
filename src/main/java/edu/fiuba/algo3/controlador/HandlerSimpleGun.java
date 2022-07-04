package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modeloOpcional.Player;
import edu.fiuba.algo3.modeloOpcional.SimpleGun;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class HandlerSimpleGun implements EventHandler<ActionEvent> {

  private Jugador player;

  public HandlerSimpleGun(Jugador player) {
    this.player = player;
  }

  public void handle(ActionEvent event) {
    SimpleGun gun = new SimpleGun();
    //player.changeVehiculo(gun);

  }
}