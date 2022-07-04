package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerNoGun;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.scene.control.Button;


public class ButtonNoGun extends Button {

	public ButtonNoGun(Jugador player) {
		super();
		this.setText("Activate No Gun");
		this.setMinHeight(20);
		this.setOnAction(new HandlerNoGun(player));
	}

}
