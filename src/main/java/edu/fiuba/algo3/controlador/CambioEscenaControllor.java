package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CambioEscenaControllor {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void cambiarAEscenaJuego(){

    }

    public void cambiarAEScenaVictoria(ActionEvent evento) throws IOException {
        stage = (Stage) ((Node)evento.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
