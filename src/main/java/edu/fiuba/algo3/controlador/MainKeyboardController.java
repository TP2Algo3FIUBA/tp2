package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MainKeyboardController implements EventHandler<KeyEvent> {

  private final Juego juego;

  public MainKeyboardController(Juego juego) {
    this.juego = juego;
  }

  public void handle(KeyEvent event) {

    // La linea Nueva ubicacion del jugador: X: Y: esta dentro de la clase Cuadra
    try {
      if (event.getCode() == KeyCode.W) {
        this.juego.moverJugadorEnDireccion(new DirNorte());
        System.out.println("Cantinad movimientos jugador: " + juego.cantMovJugador());
      }
      if (event.getCode() == KeyCode.S) {
        this.juego.moverJugadorEnDireccion(new DirSur());
        System.out.println("Cantinad movimientos jugador: " + juego.cantMovJugador());
      }
      if (event.getCode() == KeyCode.D) {
        this.juego.moverJugadorEnDireccion(new DirEste());
        System.out.println("Cantinad movimientos jugador: " + juego.cantMovJugador());
      }
      if (event.getCode() == KeyCode.A) {
        this.juego.moverJugadorEnDireccion(new DirOeste());
        System.out.println("Cantinad movimientos jugador: " + juego.cantMovJugador());
      }
      event.consume();      
    } catch (Exception e) {
      //Cant move exception
    }

  }

}