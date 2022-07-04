package edu.fiuba.algo3.vista;

import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Formulario extends Group {

    private final VBox box;
    public double width;
    public double heigth;
    private double tileWidth = 64;
    private double tileHeigth = 64;
    private GridPane table;

    public Formulario(VBox escenarioInicial) {
        this.box = escenarioInicial;
    }

    public void imputPlayer(PlayerView player) {

    }
}
