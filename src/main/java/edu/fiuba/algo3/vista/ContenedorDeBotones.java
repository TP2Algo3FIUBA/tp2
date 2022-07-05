package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class ContenedorDeBotones extends HBox {

	public ContenedorDeBotones(Jugador jugador) {
		super();
		this.setHeight(20);
		this.getChildren().add(new Button());
	}
}
