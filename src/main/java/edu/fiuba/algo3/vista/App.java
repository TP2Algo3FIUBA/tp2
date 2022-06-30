package edu.fiuba.algo3.vista;

//import edu.fiuba.algo3.SystemInfo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Stage escenario;

    @Override
    public void start(Stage escenarioInicial) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Paths.get("src/main/java/edu/fiuba/algo3/vista/plantillas/Main.fxml").toUri().toURL());
        Scene scene = new Scene(fxmlLoader.load());
        escenarioInicial.setTitle("GPS Challenge");
        escenarioInicial.setScene(scene);
        escenarioInicial.show();
    }

    public static void main(String[] args) {
        launch();
    }

}