package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.HandlerHeavyMachineGun;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modeloOpcional.Player;
import javafx.scene.control.Button;


public class ButtonHeavyMachineGun extends Button {

	public ButtonHeavyMachineGun(Jugador player) {
		super();
		this.setText("Activate Heavy Machine Gun");
		this.setMinHeight(20);
		this.setOnAction(new HandlerHeavyMachineGun(player));
	}
}
