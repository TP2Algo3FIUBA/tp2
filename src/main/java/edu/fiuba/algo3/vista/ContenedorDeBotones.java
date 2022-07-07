package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

public class ContenedorDeBotones extends HBox {

	private Juego juego;
	private TableroView tableroView;

	private static final String IDLE_BUTTON_STYLE = "-fx-background-color: #f1efef;";
	private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: #dc0000;-fx-border-color: WHITE; -fx-border-width: 2";

	public ContenedorDeBotones(Juego juego, TableroView tablero) {
		super();
		this.juego = juego;
		this.tableroView = tablero;

		this.setStyle("-fx-background-color:#2b2b2b; -fx-font-size: 15;");
		this.setAlignment(Pos.CENTER);
		this.setHeight(5);
		Button botonReinicio = new Button("Reiniciar");
		botonReinicio.setStyle(IDLE_BUTTON_STYLE);

		botonReinicio.setOnMouseEntered(e -> botonReinicio.setStyle(HOVERED_BUTTON_STYLE));
		botonReinicio.setOnMouseExited(e -> botonReinicio.setStyle(IDLE_BUTTON_STYLE));

		botonReinicio.setOnAction(e->{
			this.juego.reiniciar();
			this.tableroView.updateMovimientos(juego);
		});

		this.getChildren().add(botonReinicio);
	}


}
