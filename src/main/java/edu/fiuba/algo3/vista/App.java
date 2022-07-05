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
import edu.fiuba.algo3.modelo.manzana.Meta;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

        Tablero unTablero = new Tablero(12, 12); // tableroTest(); //
        unTablero.generarTablero();
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
        vbox.setOnKeyPressed(new MainKeyboardController(juego, tableroView, escenarioInicial));

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

    private void agregarViewCuadras(Tablero tablero) {
        for (int cuadraActual = 0; cuadraActual < tablero.cantididadCuadras(); cuadraActual++) {
            new CuadraView(tableroView, tablero.obtenerCuadra(cuadraActual));
        }

    }

    public static void main(String[] args) {
        launch();
    }

    public Tablero tableroTest() {

        //   00 ---- 01 --V- 02 -Pi- 03 ---- 04
        //    |       |      |       |        |
        //    P       |      F       |        F
        //    |       |      |       |        |
        //   10 ---- 11 ---- 12 --D--13 ---- 14
        //    |       |      |       |        |
        //    Po      Cp     |       |        |
        //    |       |      |       |        |
        //   20 ---- 21 ---- 22 --V--23 ---- 24

        Esquina esquina00 = new Esquina(0, 0);
        Esquina esquina01 = new Esquina(0, 1);
        Esquina esquina02 = new Esquina(0, 2);
        Esquina esquina03 = new Esquina(0, 3);
        Esquina esquina04 = new Esquina(0, 4);

        Esquina esquina10 = new Esquina(1, 0);
        Esquina esquina11 = new Esquina(1, 1);
        Esquina esquina12 = new Esquina(1, 2);
        Esquina esquina13 = new Esquina(1, 3);
        Esquina esquina14 = new Esquina(1, 4);

        Esquina esquina20 = new Esquina(2, 0);
        Esquina esquina21 = new Esquina(2, 1);
        Esquina esquina22 = new Esquina(2, 2);
        Esquina esquina23 = new Esquina(2, 3);
        Esquina esquina24 = new Esquina(new Meta(),2, 4 );

        Tablero tablero = new Tablero(5, 3);
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(0, esquina02);
        tablero.agregarEsquina(0, esquina03);
        tablero.agregarEsquina(0, esquina04);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);
        tablero.agregarEsquina(1, esquina12);
        tablero.agregarEsquina(1, esquina13);
        tablero.agregarEsquina(1, esquina14);
        tablero.agregarEsquina(2, esquina20);
        tablero.agregarEsquina(2, esquina21);
        tablero.agregarEsquina(2, esquina22);
        tablero.agregarEsquina(2, esquina23);
        tablero.agregarEsquina(2, esquina24);

        // Creo direcciones
        DirNorte Norte = new DirNorte();
        DirSur Sur = new DirSur();
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01);
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);
        tablero.agregarCuadra(cuadra00_01);

        // conecto 01 con 02
        Cuadra cuadra01_02 = new Cuadra(esquina01, esquina02, new SorpresaCambioDeVehiculo());
        esquina01.insertarCuadra(Este, cuadra01_02);
        esquina02.insertarCuadra(Oeste, cuadra01_02);
        tablero.agregarCuadra(cuadra01_02);

        // conecto 02 con 03
        Cuadra cuadra02_03 = new Cuadra(esquina02, esquina03, new Piquete());
        esquina02.insertarCuadra(Este, cuadra02_03);
        esquina03.insertarCuadra(Oeste, cuadra02_03);
        tablero.agregarCuadra(cuadra02_03);

        // conecto 03 con 04
        Cuadra cuadra03_04 = new Cuadra(esquina03, esquina04);
        esquina03.insertarCuadra(Este, cuadra03_04);
        esquina04.insertarCuadra(Oeste, cuadra03_04);
        tablero.agregarCuadra(cuadra03_04);

        // Conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo());
        esquina00.insertarCuadra(Sur, cuadra00_10);
        esquina10.insertarCuadra(Norte, cuadra00_10);
        tablero.agregarCuadra(cuadra00_10);

        // Conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11);
        esquina01.insertarCuadra(Sur, cuadra01_11);
        esquina11.insertarCuadra(Norte, cuadra01_11);
        tablero.agregarCuadra(cuadra01_11);

        // Conecto 02 con 12
        Cuadra cuadra02_12 = new Cuadra(esquina02, esquina12);
        esquina02.insertarCuadra(Sur, cuadra02_12);
        esquina12.insertarCuadra(Norte, cuadra02_12);
        tablero.agregarCuadra(cuadra02_12);

        // Conecto 03 con 13
        Cuadra cuadra03_13 = new Cuadra(esquina03, esquina13);
        esquina03.insertarCuadra(Sur, cuadra03_13);
        esquina13.insertarCuadra(Norte, cuadra03_13);
        tablero.agregarCuadra(cuadra03_13);

        // Conecto 04 con 14
        Cuadra cuadra04_14 = new Cuadra(esquina04, esquina14, new SorpresaFavorable());
        esquina04.insertarCuadra(Sur, cuadra04_14);
        esquina14.insertarCuadra(Norte, cuadra04_14);
        tablero.agregarCuadra(cuadra04_14);

        //////////////////////////////////////////////////////////

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11);
        esquina10.insertarCuadra(Este, cuadra10_11);
        esquina11.insertarCuadra(Oeste, cuadra10_11);
        tablero.agregarCuadra(cuadra10_11);

        // conecto 11 con 12
        Cuadra cuadra11_12 = new Cuadra(esquina11, esquina12);
        esquina11.insertarCuadra(Este, cuadra11_12);
        esquina12.insertarCuadra(Oeste, cuadra11_12);
        tablero.agregarCuadra(cuadra11_12);

        // conecto 12 con 13
        Cuadra cuadra12_13 = new Cuadra(esquina12, esquina13, new SorpresaDesfavorable());
        esquina12.insertarCuadra(Este, cuadra12_13);
        esquina13.insertarCuadra(Oeste, cuadra12_13);
        tablero.agregarCuadra(cuadra12_13);

        // conecto 13 con 14
        Cuadra cuadra13_14 = new Cuadra(esquina13, esquina14);
        esquina13.insertarCuadra(Este, cuadra13_14);
        esquina14.insertarCuadra(Oeste, cuadra13_14);
        tablero.agregarCuadra(cuadra13_14);

        // Conecto 10 con 20
        Cuadra cuadra10_20 = new Cuadra(esquina10, esquina20, new Pozo());
        esquina10.insertarCuadra(Sur, cuadra10_20);
        esquina20.insertarCuadra(Norte, cuadra10_20);
        tablero.agregarCuadra(cuadra10_20);

        // Conecto 11 con 21
        Cuadra cuadra11_21 = new Cuadra(esquina11, esquina21, new ControlPolicial());
        esquina11.insertarCuadra(Sur, cuadra11_21);
        esquina21.insertarCuadra(Norte, cuadra11_21);
        tablero.agregarCuadra(cuadra11_21);

        // Conecto 12 con 22
        Cuadra cuadra12_22 = new Cuadra(esquina12, esquina22);
        esquina12.insertarCuadra(Sur, cuadra12_22);
        esquina22.insertarCuadra(Norte, cuadra12_22);
        tablero.agregarCuadra(cuadra12_22);

        // Conecto 13 con 23
        Cuadra cuadra13_23 = new Cuadra(esquina13, esquina23);
        esquina13.insertarCuadra(Sur, cuadra13_23);
        esquina23.insertarCuadra(Norte, cuadra13_23);
        tablero.agregarCuadra(cuadra13_23);

        // Conecto 14 con 24
        Cuadra cuadra14_24 = new Cuadra(esquina14, esquina24);
        esquina14.insertarCuadra(Sur, cuadra14_24);
        esquina24.insertarCuadra(Norte, cuadra14_24);
        tablero.agregarCuadra(cuadra14_24);

        //////////////////////////////////////////////////////////

        // conecto 20 con 21
        Cuadra cuadra20_21 = new Cuadra(esquina20, esquina21);
        esquina20.insertarCuadra(Este, cuadra20_21);
        esquina21.insertarCuadra(Oeste, cuadra20_21);
        tablero.agregarCuadra(cuadra20_21);

        // conecto 21 con 22
        Cuadra cuadra21_22 = new Cuadra(esquina21, esquina22);
        esquina21.insertarCuadra(Este, cuadra21_22);
        esquina22.insertarCuadra(Oeste, cuadra21_22);
        tablero.agregarCuadra(cuadra21_22);

        // conecto 22 con 23
        Cuadra cuadra22_23 = new Cuadra(esquina22, esquina23, new SorpresaCambioDeVehiculo());
        esquina22.insertarCuadra(Este, cuadra22_23);
        esquina23.insertarCuadra(Oeste, cuadra22_23);
        tablero.agregarCuadra(cuadra22_23);

        // conecto 23 con 24
        Cuadra cuadra23_24 = new Cuadra(esquina23, esquina24);
        esquina23.insertarCuadra(Este, cuadra23_24);
        esquina24.insertarCuadra(Oeste, cuadra23_24);
        tablero.agregarCuadra(cuadra23_24);


        return tablero;
    }
}