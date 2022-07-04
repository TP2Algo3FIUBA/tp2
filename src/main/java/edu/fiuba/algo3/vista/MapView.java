package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modeloOpcional.Map;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MapView extends Group {

    public double width;
    public double heigth;
    private double tileWidth = 64;
    private double tileHeigth = 64;

    private GridPane table;

    private Pane[][] panes;

    public MapView(Tablero map){
        table = new GridPane();
        width = tileWidth * map.getWidth();
        heigth = tileHeigth * map.getHeigth();
        panes = new Pane[ (int)width][(int)heigth];
        
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeigth(); j++) {
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

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
		getChildren().remove(view);
		getChildren().add(view);
    }
}