package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerSimpleGun;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.scene.control.Button;


public class ButtonSimpleGun extends Button {


	public ButtonSimpleGun(Jugador player) {
		super();
		this.setText("Activate Simple Gun");
		this.setMinHeight(20);
		this.setOnAction(new HandlerSimpleGun(player));
	}
}
