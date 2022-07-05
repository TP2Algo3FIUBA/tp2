package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JugadorView implements Observer, Drawable {
	private double playerScale = 1;
	private TableroView tableroView;
	ImageView playerImage;

	private Jugador jugador;

	private int lastXPosition;
	private int lastYPosition;

	public JugadorView(TableroView tableroView, Jugador jugador) {
		this.tableroView = tableroView;
		this.jugador = jugador;

		this.lastXPosition = jugador.getPosition().getX();
		this.lastYPosition = jugador.getPosition().getY();

		jugador.addObserver(this);

		playerImage = new ImageView();
		playerImage.setScaleX(playerScale);
		playerImage.setScaleY(playerScale);
		playerImage.setFitHeight(64);
		playerImage.setFitWidth(64);

		playerImage.setImage(new Image("auto.png"));
		tableroView.addViewOnMap(playerImage, jugador.getPosition().getX(), jugador.getPosition().getY());
		draw();

	}

	@Override
	public void draw() {
		playerImage.setTranslateX(-4);
		playerImage.setTranslateY(15);
		tableroView.updateView(playerImage);
	}

	private void changePlayerSkin(String fileName) {
		System.out.println(fileName);
		playerImage.setImage(new Image(fileName + ".png"));
	}

	//@Override
	public void change() {
		changePlayerSkin(jugador.getVehiculoName());
		int actualX = jugador.getPosition().getX();
		int actualY = jugador.getPosition().getY();
		if (lastXPosition > actualX) {
			this.playerImage.setScaleX( - 
			Math.abs(playerImage.getScaleX()));
		}

		else if (lastXPosition < actualX) {
			this.playerImage.setScaleX(
			Math.abs(playerImage.getScaleX()));
		}
		this.lastXPosition = jugador.getPosition().getX();
		this.lastYPosition = jugador.getPosition().getY();
		tableroView.addViewOnMap(this.playerImage, actualX, actualY);
	}

}
