package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.manzana.Tablero;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class TableroView extends Group {

    public double width;
    public double heigth;
    private double tileWidth = 64;
    private double tileHeigth = 64;

    private GridPane table;
    private Pane[][] panes;


    public TableroView(Tablero tablero){
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

        this.addView(table);
    }

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