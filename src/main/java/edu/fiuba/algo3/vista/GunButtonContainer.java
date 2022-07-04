package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import javafx.scene.layout.HBox;


public class GunButtonContainer extends HBox {

	public GunButtonContainer(Jugador player) {
		super();
		this.setHeight(20);
		this.getChildren().add(new ButtonSimpleGun(player));
		this.getChildren().add(new ButtonHeavyMachineGun(player));
		this.getChildren().add(new ButtonNoGun(player));

	}
}
