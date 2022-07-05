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

		this.lastXPosition = (int) jugador.getPosition().getFil();
		this.lastYPosition = (int) jugador.getPosition().getCol();

		jugador.addObserver(this);

		playerImage = new ImageView();
		playerImage.setScaleX(playerScale);
		playerImage.setScaleY(playerScale);
		playerImage.setFitHeight(64);
		playerImage.setFitWidth(64);

		playerImage.setImage(new Image("auto.png"));
		tableroView.addViewOnMap(playerImage, (int) jugador.getPosition().getFil(), (int) jugador.getPosition().getCol());
		draw();

	}

	@Override
	public void draw() {
		playerImage.setTranslateX(64 * this.jugador.getPosition().getCol());
		playerImage.setTranslateY(64 * this.jugador.getPosition().getFil());
		tableroView.updateView(playerImage);
	}

	private void changePlayerSkin(String fileName) {
		System.out.println(fileName);
		playerImage.setImage(new Image(fileName + ".png"));
	}

	//@Override
	public void change() {
		changePlayerSkin(jugador.getVehiculoName());
		double actualCol = jugador.getPosition().getCol();
		double actualFil = jugador.getPosition().getFil();
		if (lastXPosition > actualCol) {
			this.playerImage.setScaleX( - 
			Math.abs(playerImage.getScaleX()));
		}

		else if (lastXPosition < actualCol) {
			this.playerImage.setScaleX(
			Math.abs(playerImage.getScaleX()));
		}
		this.lastXPosition = (int) jugador.getPosition().getFil();
		this.lastYPosition = (int) jugador.getPosition().getCol();
		tableroView.addViewOnMap(this.playerImage, (int) actualCol, (int) actualFil);
	}

}
