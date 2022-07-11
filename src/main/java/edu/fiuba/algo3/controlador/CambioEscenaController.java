package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.vista.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.WHITE;

public class CambioEscenaController {

    private Stage ventana;

    private Scene escenaInicio, escenaJuego, escenaVictoria;

    private JugadorView jugadorView;
    private TableroView tableroView;

    public Scene generarEscenarioInicio(Stage ventana){
        this.ventana = ventana;

        VBox layout = new VBox();
        layout.setPadding(new Insets(40, 20, 20, 20));
        layout.setSpacing(20);
        layout.setAlignment(Pos.TOP_CENTER);
        escenaInicio = new Scene(layout, 400, 300);
        layout.setStyle("-fx-background-color:#2b2b2b; -fx-font-size: 15");

        // SOLICITAR NOMBRE JUGADOR
        Label label = new Label("Insertar nombre");
        label.setTextFill(WHITE);
        TextField nombreJugador = new TextField();
        nombreJugador.setAlignment(Pos.CENTER);

        // SOLICITAR TAMANIO MAPA AL JUGADOR
        Label labelMapa = new Label("Tamaño mapa");
        labelMapa.setTextFill(WHITE);
        Slider tamanioMapa = new Slider(4, 16, 2);
        tamanioMapa.setShowTickMarks(true);
        tamanioMapa.setShowTickLabels(true);
        tamanioMapa.setSnapToTicks(true);
        tamanioMapa.setMajorTickUnit(2);
        tamanioMapa.setMinorTickCount(0);
        tamanioMapa.setBlockIncrement(1);

        Button button = new Button("Iniciar Juego");
        button.setOnAction(e->{
            if (nombreJugador.getText() != "") { // cambiar por mejor chequeo
                generarEscenarioJuego(nombreJugador.getText(), tamanioMapa.getValue());
                ventana.setScene(escenaJuego);
            }
        });

        layout.getChildren().addAll(label, nombreJugador, labelMapa, tamanioMapa, button);
        return this.escenaInicio;
    }


    private void generarEscenarioJuego(String nombreJugador, double tamanioMapa) {
        Tablero unTablero = new Tablero((int) tamanioMapa, (int) tamanioMapa);
        unTablero.generarTablero();
        tableroView = new TableroView(unTablero, nombreJugador);

        Jugador jugador = new Jugador(new Vehiculo( new EstadoAuto()) );
        jugadorView = new JugadorView(tableroView, jugador);
        unTablero.addObserver(jugadorView);

        agregarViewEsquinas(unTablero, jugador);
        agregarViewCuadras(unTablero, jugador);

        VBox vbox = new VBox();

        Juego juego = new Juego(jugador, unTablero);
        juego.setNombreJugador(nombreJugador);

        jugador.spawnearVehiculoEn(unTablero.obtenerEsquina(0, 0));
        vbox.getChildren().add(tableroView);
        vbox.setOnKeyPressed(new MainKeyboardController(juego, tableroView, ventana));

        vbox.getChildren().add(new ContenedorDeBotones(juego, tableroView));
        vbox.setOnKeyPressed(new MainKeyboardController(juego, tableroView, ventana));

        escenaJuego = new Scene(vbox);
    }

    private void agregarViewEsquinas(Tablero tablero, Jugador jugador) {
        for (int filaActual = 0; filaActual < tablero.getHeigth(); filaActual++) {
            for (int columnaActual = 0; columnaActual < tablero.getWidth(); columnaActual++) {
                new EsquinaView(tableroView, tablero.obtenerEsquina(filaActual, columnaActual), jugador);
            }
        }
    }

    private void agregarViewCuadras(Tablero tablero, Jugador jugador) {
        for (int cuadraActual = 0; cuadraActual < tablero.cantididadCuadras(); cuadraActual++) {
            CuadraView cuadraCreada = new CuadraView(tableroView, tablero.obtenerCuadra(cuadraActual), jugador);
            tablero.addObserver(cuadraCreada);
        }

    }
}
