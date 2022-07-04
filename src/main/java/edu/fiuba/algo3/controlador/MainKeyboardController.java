package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modeloOpcional.Map;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainKeyboardController implements EventHandler<KeyEvent> {

  private Jugador player;
  private Tablero map;


  public MainKeyboardController(Jugador player, Tablero map) {
    this.player = player;
    this.map = map;
  }

  public void handle(KeyEvent event) {

    try {
      if (event.getCode() == KeyCode.W) {
        map.movePositionableToUp(this.player);          
      }
      if (event.getCode() == KeyCode.S) {
        map.movePositionableToDown(this.player);            
      }
      if (event.getCode() == KeyCode.D) {
        map.movePositionableToRigth(this.player);   
      }
      if (event.getCode() == KeyCode.A) {
        map.movePositionableToLeft(this.player);      
      }
      event.consume();      
    } catch (Exception e) {
      //Cant move exception
    }


  }

}