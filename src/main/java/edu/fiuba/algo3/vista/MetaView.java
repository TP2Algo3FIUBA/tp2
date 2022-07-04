package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modeloOpcional.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MetaView implements Observer, Drawable {
	private double metaScale = 0.5;
	private MapView stage;
	ImageView metaImage;

	private Jugador player;
	private Esquina meta;
	private int lastXPosition;

	public MetaView(MapView stage, Esquina meta) {
		this.stage = stage;
		this.player = player;
		this.meta = meta;

		metaImage = new ImageView();
		metaImage.setScaleX(metaScale);
		metaImage.setScaleY(metaScale);
		metaImage.setFitHeight(64);
		metaImage.setFitWidth(64);

		metaImage.setImage(new Image("meta.png"));
		stage.addViewOnMap(metaImage, 5, 5);

		draw();

	}

	@Override
	public void draw() {
		metaImage.setTranslateX(335);
		metaImage.setTranslateY(160);
		stage.updateView(metaImage);
	}

	private void changePlayerSkin(String fileName) {
		System.out.println(fileName);
		metaImage.setImage(new Image(fileName + ".png"));
	}

	@Override
	public void change() {
		changePlayerSkin(player.getVehiculoName());
		int actualX = player.getPosition().getX();
		int actualY = player.getPosition().getY();
		if (lastXPosition > actualX) {
			this.metaImage.setScaleX( -
			Math.abs(metaImage.getScaleX()));
		}

		else if (lastXPosition < actualX) {
			this.metaImage.setScaleX(
			Math.abs(metaImage.getScaleX()));
		}
		this.lastXPosition = player.getPosition().getX();
		stage.addViewOnMap(this.metaImage, actualX, actualY);
	}

}
