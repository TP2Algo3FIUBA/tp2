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
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
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

        Tablero unTablero = tableroTest(); // new Tablero(8, 8); //
        //unTablero.generarTablero();
        tableroView = new TableroView(unTablero);

        Jugador jugador = new Jugador(new Vehiculo( new EstadoAuto()) );
        unTablero.addObserver(jugadorView);

        jugadorView = new JugadorView(tableroView, jugador);

        agregarViewEsquinas(unTablero);
        agregarViewCuadras(unTablero);

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

    private void agregarViewEsquinas(Tablero tablero) {
        for (int filaActual = 0; filaActual < tablero.getHeigth(); filaActual++) {
            for (int columnaActual = 0; columnaActual < tablero.getWidth(); columnaActual++) {
                new EsquinaView(tableroView, tablero.obtenerEsquina(filaActual, columnaActual));
            }
        }
    }

    private void agregarViewCuadras(Tablero unTablero) {
        for (int filaActual = 0; filaActual < unTablero.getHeigth() -1; filaActual++) {
            for (int columnaActual = 0; columnaActual < unTablero.getWidth() -1; columnaActual++) {
                new CuadraView(tableroView, unTablero.obtenerCuadra(filaActual, columnaActual));
            }
        }
    }


    public static void main(String[] args) {
        launch();
    }

    public Tablero tableroTest() {
        Esquina esquina00 = new Esquina(0, 0);          //   00 ---- 01 --$- 02 ---- 03
        Esquina esquina01 = new Esquina(0, 1);          //    |       |      |       |
                                                                     //    *       |      |       |
        Esquina esquina10 = new Esquina(1, 0);          //    |       |      |       |
        Esquina esquina11 = new Esquina(1, 1);          //   10 ---- 11 ---- 12 -----13

        Esquina esquina02 = new Esquina(0, 2);
        Esquina esquina12 = new Esquina(1, 2);

        Esquina esquina03 = new Esquina(0, 3);
        Esquina esquina13 = new Esquina(1, 3);

        Tablero tablero = new Tablero(4, 2);
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(0, esquina02);
        tablero.agregarEsquina(0, esquina03);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);
        tablero.agregarEsquina(1, esquina12);
        tablero.agregarEsquina(1, esquina13);

        // Creo direcciones
        DirNorte Norte = new DirNorte();
        DirSur Sur = new DirSur();
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, 0, 0);
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, 1, 0);
        esquina10.insertarCuadra(Este, cuadra10_11);
        esquina11.insertarCuadra(Oeste, cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo(), 2, 0);
        esquina00.insertarCuadra(Sur, cuadra00_10);
        esquina10.insertarCuadra(Norte, cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, 2, 1);
        esquina01.insertarCuadra(Sur, cuadra01_11);
        esquina11.insertarCuadra(Norte, cuadra01_11);

        // conecto 01 con 02
        Cuadra cuadra01_02 = new Cuadra(esquina01, esquina02, new SorpresaCambioDeVehiculo(), 0, 1);
        esquina01.insertarCuadra(Este, cuadra01_02);
        esquina02.insertarCuadra(Oeste, cuadra01_02);

        // conecto 11 con 12
        Cuadra cuadra11_12 = new Cuadra(esquina11, esquina12, 1, 1);
        esquina11.insertarCuadra(Este, cuadra11_12);
        esquina12.insertarCuadra(Oeste, cuadra11_12);

        // conecto 02 con 12
        Cuadra cuadra02_12 = new Cuadra(esquina02, esquina12,2,2);
        esquina02.insertarCuadra(Sur, cuadra02_12);
        esquina12.insertarCuadra(Norte, cuadra02_12);

        // conecto 02 con 03
        Cuadra cuadra02_03 = new Cuadra(esquina02, esquina03,0,2);
        esquina02.insertarCuadra(Este, cuadra02_03);
        esquina03.insertarCuadra(Oeste, cuadra02_03);

        // conecto 12 con 13
        Cuadra cuadra12_13 = new Cuadra(esquina12, esquina13,1,2);
        esquina12.insertarCuadra(Este, cuadra12_13);
        esquina13.insertarCuadra(Oeste, cuadra12_13);

        // conecto 03 con 13
        Cuadra cuadra03_13 = new Cuadra(esquina03, esquina13,2,3);
        esquina03.insertarCuadra(Sur, cuadra03_13);
        esquina13.insertarCuadra(Norte, cuadra03_13);

        tablero.agregarCuadra(0, cuadra00_01);
        tablero.agregarCuadra(0, cuadra01_02);
        tablero.agregarCuadra(0, cuadra02_03);

        tablero.agregarCuadra(1, cuadra10_11);
        tablero.agregarCuadra(1, cuadra11_12);
        tablero.agregarCuadra(1, cuadra12_13);

        tablero.agregarCuadra(2, cuadra00_10);
        tablero.agregarCuadra(2, cuadra01_11);
        tablero.agregarCuadra(2, cuadra02_12);
        tablero.agregarCuadra(2, cuadra03_13);

        return tablero;
    }
}