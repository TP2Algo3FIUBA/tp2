package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import static javafx.scene.paint.Color.*;

public class TableroView extends Group {

    public double width;
    public double heigth;
    private double tileWidth = 64;
    private double tileHeigth = 64;

    private GridPane table;
    private Pane[][] panes;

    private VBox ui;
    private Label nombreJugador;
    private Label movimientosJugador;

    public TableroView(Tablero tablero, String nombreJugador){
        ui = new VBox();

        table = new GridPane();
        width = tileWidth * tablero.getWidth();
        heigth = tileHeigth * tablero.getHeigth();

        panes = new Pane[ (int)width][(int)heigth];
        for (int i = 0; i < tablero.getWidth(); i++) {
            for (int j = 0; j < tablero.getHeigth(); j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                panes[i][j] = v;
                table.add(v , i, j);
            }
        }

        Background bi = new Background(new BackgroundImage(new Image("fondo.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.width, this.heigth, false, false, false, false)));
        table.setBackground(bi);
        ui.getChildren().add(table);

        this.agregarUI(nombreJugador);

        this.addView(ui);
    }

    // interfaceV3 ///////////////////////////////////////////
    public void updateMovimientos(Juego juego) {
        int movimientos = juego.cantMovJugador();
        movimientosJugador.setText("Cantidad Movimientos: " + juego.cantMovJugador());
    }

    private void agregarUI(String strNombreJugador) {
        HBox BoxNJ = new HBox();
        BoxNJ.setStyle("-fx-background-color:#2b2b2b; -fx-font-size: 15;");
        nombreJugador = new Label("Nombre Jugador: " + strNombreJugador);
        nombreJugador.setTextFill(WHITE);
        BoxNJ.getChildren().add(nombreJugador);
        ui.getChildren().add(BoxNJ);

        HBox BoxMJ = new HBox();
        BoxMJ.setStyle("-fx-background-color:#2b2b2b; -fx-font-size: 15;");
        movimientosJugador = new Label("Cantidad Movimientos: 0");
        movimientosJugador.setTextFill(WHITE);
        BoxMJ.getChildren().add(movimientosJugador);
        ui.getChildren().add(BoxMJ);

    }
    //////////////////////////////////////////////////////////

    public void addViewOnMap(Node view, int col, int fil) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[col][fil].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
		getChildren().remove(view);
		getChildren().add(view);
    }

}