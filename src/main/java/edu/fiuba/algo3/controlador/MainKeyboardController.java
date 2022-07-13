package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vista.TableroView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

import static javafx.scene.paint.Color.WHITE;

public class MainKeyboardController implements EventHandler<KeyEvent> {

  private final Juego juego;
  private final TableroView tableroView;
  private final Stage ventana;
  private Scene escenaVictoria;

  public MainKeyboardController(Juego juego, TableroView tableroView, Stage ventana) {
    this.juego = juego;
    this.tableroView = tableroView;
    this.ventana = ventana;
  }

  public void handle(KeyEvent event) {

    // La linea Nueva ubicacion del jugador: X: Y: esta dentro de la clase Cuadra
    try {
      if (event.getCode() == KeyCode.W) {
        this.juego.moverJugadorEnDireccion(new DirNorte());
        tableroView.updateMovimientos(juego);
      }
      if (event.getCode() == KeyCode.S) {
        this.juego.moverJugadorEnDireccion(new DirSur());
        tableroView.updateMovimientos(juego);
      }
      if (event.getCode() == KeyCode.D) {
        this.juego.moverJugadorEnDireccion(new DirEste());
        tableroView.updateMovimientos(juego);
      }
      if (event.getCode() == KeyCode.A) {
        this.juego.moverJugadorEnDireccion(new DirOeste());
        tableroView.updateMovimientos(juego);
      }

      if (juego.Ganado()) {
      	juego.finalizarPartida();
        generarEscenarioVictoria();
        ventana.setScene(escenaVictoria);

      }
      event.consume();      
    } catch (Exception e) {
      //Cant move exception
    }

  }

  private void generarEscenarioVictoria(){
    VBox layout = new VBox();
    layout.setPadding(new Insets(40, 20, 20, 20));
    layout.setSpacing(20);
    layout.setAlignment(Pos.TOP_CENTER);
    escenaVictoria = new Scene(layout, 400, 300);
    layout.setStyle("-fx-background-color:#2b2b2b; -fx-font-size: 15");

    // VICTORIA
    Label labelVictoria = new Label("Victoria!");
    labelVictoria.setTextFill(WHITE);

    // JUGADOR
    Label labelJugador = new Label("Jugador: " + juego.getNombreJugador());
    labelJugador.setTextFill(WHITE);

    // PUNTAJE
    Label labelMovimientos = new Label("Movimientos: " + juego.cantMovJugador());
    labelMovimientos.setTextFill(WHITE);

    // BOTON SALIR
    Button botonSalir = new Button("Salir");
    botonSalir.setOnAction(e->{
      Platform.exit();
    });

    layout.getChildren().addAll(labelVictoria, labelJugador, labelMovimientos, botonSalir);
  }
}