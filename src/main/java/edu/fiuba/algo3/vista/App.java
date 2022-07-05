package edu.fiuba.algo3.vista;

//import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.MainKeyboardController;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private JugadorView jugadorView;
    private TableroView tableroView;
    @Override
    public void start(Stage escenarioInicial) throws Exception {
        escenarioInicial.setTitle("GPS Challenge");

        Tablero unTablero = new Tablero();
        tableroView = new TableroView(unTablero);

        Jugador jugador = new Jugador(new Vehiculo( new EstadoAuto()) );
        unTablero.addObserver(jugadorView);

        jugadorView = new JugadorView(tableroView, jugador);
        VBox vbox = new VBox();

        Juego juego = new Juego(jugador, unTablero);
        jugador.spawnearVehiculoEn(unTablero.obtenerEsquina(0, 0));
        vbox.getChildren().add(tableroView);

        vbox.getChildren().add(new ContenedorDeBotones(jugador));
        vbox.setOnKeyPressed(new MainKeyboardController(juego));

        Scene theScene = new Scene(vbox);
        escenarioInicial.setScene(theScene);
        escenarioInicial.show();

    }

    public static void main(String[] args) {
        launch();
    }

}