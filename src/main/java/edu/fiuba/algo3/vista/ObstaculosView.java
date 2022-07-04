package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.evento.Evento;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modeloOpcional.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ObstaculosView implements Observer, Drawable {
	private int  y;
	private  int x;
	private double metaScale = 1;
	private MapView stage;

	ImageView ObstaculoImage;

	private Jugador player;
	private Evento evento;
	private int lastXPosition;

	public ObstaculosView(Tablero tablero, MapView stage, Evento evento,int x,int j) {
		this.stage = stage;
		this.evento = evento;
		this.x = x;
		this.y = j;

		ObstaculoImage = new ImageView();
		ObstaculoImage.setScaleX(metaScale);
		ObstaculoImage.setScaleY(metaScale);
		ObstaculoImage.setFitHeight(64);
		ObstaculoImage.setFitWidth(64);

		ObstaculoImage.setImage(new Image("moto.png"));
		stage.addViewOnMap(ObstaculoImage, 5, 5);
		draw();
		tablero.addObserver(this);

	}

	@Override
	public void draw() {
		ObstaculoImage.setTranslateX(65 * x);
		ObstaculoImage.setTranslateY(65 * y);
		stage.updateView(ObstaculoImage);
	}

	public void changePlayerSkin(String fileName) {
		System.out.println(fileName);
		ObstaculoImage.setImage(new Image(fileName + ".png"));
	}

	@Override
	public void change() {
		changePlayerSkin(player.getVehiculoName());
		int actualX = player.getPosition().getX();
		int actualY = player.getPosition().getY();
		if (lastXPosition > actualX) {
			this.ObstaculoImage.setScaleX( -
			Math.abs(ObstaculoImage.getScaleX()));
		}

		else if (lastXPosition < actualX) {
			this.ObstaculoImage.setScaleX(
			Math.abs(ObstaculoImage.getScaleX()));
		}
		this.lastXPosition = player.getPosition().getX();
		stage.addViewOnMap(this.ObstaculoImage, actualX, actualY);
	}

}
