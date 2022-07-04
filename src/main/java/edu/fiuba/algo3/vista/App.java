package edu.fiuba.algo3.vista;

//import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.controlador.MainKeyboardController;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Meta;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import edu.fiuba.algo3.modeloOpcional.Map;
import edu.fiuba.algo3.modeloOpcional.Player;
import edu.fiuba.algo3.modeloOpcional.Position;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Stage escenario;
    boolean imputForm = false;

    private PlayerView player;
    private MetaView meta;
    private MapView mapView;
    @Override
    public void start(Stage escenarioInicial) throws Exception {
        //Juego juego = new Juego();
        //juego.correrJuego();


        escenarioInicial.setTitle("GPS Challenge");

        Tablero map = new Tablero();
        mapView = new MapView(map);

        Jugador playerModel = new Jugador(new Vehiculo(new EstadoAuto()));
        map.positionate(playerModel, new Position(0, 0));
        map.addObserver(player);

        player = new PlayerView(mapView, playerModel);

        Esquina metaModel = new Esquina(new Meta());
        map.positionate(metaModel,new Position(5,5));
        map.addObserver(meta);

        meta = new MetaView(mapView,metaModel);

        Juego juego = new Juego(playerModel,map,mapView) ;

       // ObstaculosView obstaculosView = new ObstaculosView(mapView, juego.obtenerEsquina(4,4) );

        //map.addObserver(obstaculosView);

        VBox vbox = new VBox();

        vbox.getChildren().add(mapView);
        vbox.getChildren().add(new GunButtonContainer(playerModel,juego));
        vbox.setOnKeyPressed(new MainKeyboardController(playerModel,  map,juego));


        Scene theScene = new Scene(vbox);
        escenarioInicial.setScene(theScene);
        escenarioInicial.show();
    }

    public static void main(String[] args) {
        launch();
    }

}