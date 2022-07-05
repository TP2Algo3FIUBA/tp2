package edu.fiuba.algo3.vista;

//import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.MainKeyboardController;
import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirNorte;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.direcciones.DirSur;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
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

        Tablero unTablero = tableroTest(); // new Tablero(); //
        //unTablero.generarTablero();
        tableroView = new TableroView(unTablero);

        Jugador jugador = new Jugador(new Vehiculo( new EstadoAuto()) );
        unTablero.addObserver(jugadorView);

        jugadorView = new JugadorView(tableroView, jugador);

        EsquinaView esquina00view = new EsquinaView(tableroView, unTablero.obtenerEsquina(0,0));
        EsquinaView esquina01view = new EsquinaView(tableroView, unTablero.obtenerEsquina(0,1));
        EsquinaView esquina02view = new EsquinaView(tableroView, unTablero.obtenerEsquina(0,2));

        EsquinaView esquina10view = new EsquinaView(tableroView, unTablero.obtenerEsquina(1,0));
        EsquinaView esquina11view = new EsquinaView(tableroView, unTablero.obtenerEsquina(1,1));
        EsquinaView esquina12view = new EsquinaView(tableroView, unTablero.obtenerEsquina(1,2));


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

    public Tablero tableroTest() {
        Esquina esquina00 = new Esquina(0, 0);          //   00 ---- 01 ---- 02
        Esquina esquina01 = new Esquina(0, 1);          //    |       |      |
                                                                     //    *       |      |
        Esquina esquina10 = new Esquina(1, 0);          //    |       |      |
        Esquina esquina11 = new Esquina(1, 1);          //   10 ---- 11 ---- 12

        Esquina esquina02 = new Esquina(0, 2);
        Esquina esquina12 = new Esquina(1, 2);

        Tablero tablero = new Tablero(3, 2);
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(0, esquina02);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);
        tablero.agregarEsquina(1, esquina12);

        // Creo direcciones
        DirNorte Norte = new DirNorte();
        DirSur Sur = new DirSur();
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01);
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11);
        esquina10.insertarCuadra(Este, cuadra10_11);
        esquina11.insertarCuadra(Oeste, cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo());
        esquina00.insertarCuadra(Sur, cuadra00_10);
        esquina10.insertarCuadra(Norte, cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11);
        esquina01.insertarCuadra(Sur, cuadra01_11);
        esquina11.insertarCuadra(Norte, cuadra01_11);

        // conecto 01 con 02
        Cuadra cuadra01_02 = new Cuadra(esquina01, esquina02);
        esquina01.insertarCuadra(Este, cuadra01_02);
        esquina02.insertarCuadra(Oeste, cuadra01_02);

        // conecto 11 con 12
        Cuadra cuadra11_12 = new Cuadra(esquina11, esquina12);
        esquina11.insertarCuadra(Este, cuadra11_12);
        esquina12.insertarCuadra(Oeste, cuadra11_12);

        // conecto 02 con 12
        Cuadra cuadra02_12 = new Cuadra(esquina02, esquina12);
        esquina02.insertarCuadra(Sur, cuadra02_12);
        esquina12.insertarCuadra(Norte, cuadra02_12);

        return tablero;
    }
}