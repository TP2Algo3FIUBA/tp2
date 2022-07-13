package edu.fiuba.algo3.vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.controlador.CambioEscenaController;


/**
 * JavaFX App
 */
public class App extends Application {

    private Stage ventana;
    Scene escenaInicio;

    private CambioEscenaController sceneController;

    @Override
    public void start(Stage ventanaInicial) throws Exception {
        ventanaInicial.setTitle("GPS Challenge");
        sceneController = new CambioEscenaController(); // raro

        ventana = ventanaInicial;
        escenaInicio = sceneController.generarEscenarioInicio(ventana);

        ventana.setScene(escenaInicio);
        ventana.show();

    }
    
    public static void main(String[] args) {
        launch();
    }

}