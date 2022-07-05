package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CuadraView implements Observer, Drawable {
	private double esquinaScale = 1;
	private TableroView tableroView;
	ImageView cuadraImage;

	private Cuadra cuadra;

	private int lastXPosition;
	private int lastYPosition;

	public CuadraView(TableroView tableroView, Cuadra cuadra) {
		this.tableroView = tableroView;
		this.cuadra = cuadra;

		this.lastXPosition = cuadra.getPosition().getFil();
		this.lastYPosition = cuadra.getPosition().getCol();

		cuadra.addObserver(this);

		cuadraImage = new ImageView();
		cuadraImage.setScaleX(esquinaScale);
		cuadraImage.setScaleY(esquinaScale);
		cuadraImage.setFitHeight(64);
		cuadraImage.setFitWidth(64);

		if (cuadra.getObstaculo() instanceof EventoVacio) {
			cuadraImage.setImage(new Image("casa.png"));
		}
		else cuadraImage.setImage(new Image("pozo.png")); // cambiar por cuadra.png

		tableroView.addViewOnMap(cuadraImage, cuadra.getPosition().getCol(), cuadra.getPosition().getFil()); // Del reves?
		System.out.println("Dibujando esquina de Fil:" + cuadra.getPosition().getFil() + " Col:" + cuadra.getPosition().getCol());
		draw();
	}

	@Override
	public void draw() {
		cuadraImage.setTranslateX(64 * this.cuadra.getPosition().getCol());
		cuadraImage.setTranslateY(64 * this.cuadra.getPosition().getFil());
		tableroView.updateView(cuadraImage);
	}

	private void changeCuadraSkin(String fileName) {
		System.out.println(fileName);
		cuadraImage.setImage(new Image(fileName + ".png"));
	}

	//@Override
	public void change() {
		changeCuadraSkin(cuadra.getCuadraName());
		int actualCol = cuadra.getPosition().getCol();
		int actualFil = cuadra.getPosition().getFil();
		if (lastXPosition > actualCol) {
			this.cuadraImage.setScaleX( -
			Math.abs(cuadraImage.getScaleX()));
		}

		else if (lastXPosition < actualCol) {
			this.cuadraImage.setScaleX(
			Math.abs(cuadraImage.getScaleX()));
		}
		this.lastXPosition = cuadra.getPosition().getFil();
		this.lastYPosition = cuadra.getPosition().getCol();
		tableroView.addViewOnMap(this.cuadraImage, actualCol, actualFil);
	}

}
