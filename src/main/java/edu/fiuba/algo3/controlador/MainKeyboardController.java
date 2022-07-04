package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modeloOpcional.Map;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainKeyboardController implements EventHandler<KeyEvent> {

  private final Juego juego;
  private Jugador player;
  private Tablero map;


  public MainKeyboardController(Jugador player, Tablero map, Juego juego) {
    this.player = player;
    this.map = map;
    this.juego = juego;
  }

  public void handle(KeyEvent event) {

    try {
      if (event.getCode() == KeyCode.W) {
        map.movePositionableToUp(this.player);
        this.juego.moverJugadorEnDireccion(new DirNorte());
      }
      if (event.getCode() == KeyCode.S) {
        map.movePositionableToDown(this.player);
        this.juego.moverJugadorEnDireccion(new DirSur());
      }
      if (event.getCode() == KeyCode.D) {
        map.movePositionableToRigth(this.player);
        this.juego.moverJugadorEnDireccion(new DirEste());
      }
      if (event.getCode() == KeyCode.A) {
        map.movePositionableToLeft(this.player);
        this.juego.moverJugadorEnDireccion(new DirOeste());
      }
      event.consume();      
    } catch (Exception e) {
      //Cant move exception
    }


  }

}