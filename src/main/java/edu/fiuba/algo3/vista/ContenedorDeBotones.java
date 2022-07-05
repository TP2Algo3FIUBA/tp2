package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;


public class ContenedorDeBotones extends HBox {

	public ContenedorDeBotones(Jugador jugador) {
		super();
		this.setHeight(5);
		this.getChildren().add(new Button()); // ??? no tocar

	}
}
