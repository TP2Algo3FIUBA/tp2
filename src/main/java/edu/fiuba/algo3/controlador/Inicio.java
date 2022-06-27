package edu.fiuba.algo3.controlador;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Inicio {

    @FXML
    private Label bienvenida;

    @FXML
    private Button playBtn;

    @FXML
    private Label titulo;

    @FXML
    void onActionPlayBotton() {
        bienvenida.setText(" Creacion del juego en proceso, gracias por la espera");
        bienvenida.setAlignment(Pos.valueOf("center"));
    }

}