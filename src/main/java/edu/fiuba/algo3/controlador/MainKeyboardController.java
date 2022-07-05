package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.TableroView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainKeyboardController implements EventHandler<KeyEvent> {

  private final Juego juego;
  private final TableroView tableroView;
  private final Stage stage;

  public MainKeyboardController(Juego juego, TableroView tableroView, Stage stage) {
    this.juego = juego;
    this.tableroView = tableroView;
    this.stage = stage;
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

      if (juego.Ganado()) {
        System.out.println("Victoria");
        Stage primaryStage = new Stage();

        primaryStage.setTitle("VICTORIA");

        Label cantidadMovimientosLabel = new Label();
        int valCantMov = juego.cantMovJugador();
        String strCantMov = Integer.toString(valCantMov);
        cantidadMovimientosLabel.setText("Puntuacion: " + strCantMov);

        StackPane root = new StackPane();
        root.getChildren().add(cantidadMovimientosLabel);
        primaryStage.setScene(new Scene(root, 300, 50));
        primaryStage.show();

      }
      event.consume();      
    } catch (Exception e) {
      //Cant move exception
    }

  }

}