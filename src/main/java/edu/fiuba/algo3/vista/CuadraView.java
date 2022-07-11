package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CuadraView implements Observer, Drawable {
	private double esquinaScale = 0.6;
	private TableroView tableroView;
	ImageView cuadraImage;

	private Cuadra cuadra;
	private double col;
	private double fil;

	private Jugador jugador;

	public CuadraView(TableroView tableroView, Cuadra cuadra, Jugador jugador) {
		this.tableroView = tableroView;
		this.cuadra = cuadra;
		this.col = cuadra.getPosition().getCol();
		this.fil = cuadra.getPosition().getFil();
		this.jugador = jugador;

		this.cuadra.addObserver(this);
		this.jugador.addObserver(this);

		cuadraImage = new ImageView();
		cuadraImage.setScaleX(esquinaScale);
		cuadraImage.setScaleY(esquinaScale);
		cuadraImage.setFitHeight(64);
		cuadraImage.setFitWidth(64);

		String fileName = cuadra.getTipoCuadraName();
		cuadraImage.setImage(new Image( fileName + ".png"));
		tableroView.addViewOnMap(cuadraImage, (int) cuadra.getPosition().getCol(), (int) cuadra.getPosition().getFil());
		change();
		draw();
	}

	@Override
	public void draw() {
		cuadraImage.setTranslateX(64 * this.cuadra.getPosition().getCol());
		cuadraImage.setTranslateY(64 * this.cuadra.getPosition().getFil());
		tableroView.updateView(cuadraImage);
	}

	@Override
	public void change() {

		cuadraImage.setOpacity(100);
		if ( Math.abs(jugador.getPosition().getCol() - this.col) > 1 ) {
			cuadraImage.setOpacity(0);
		}

		if ( Math.abs(jugador.getPosition().getFil() - this.fil) > 1 ) {
			cuadraImage.setOpacity(0);
		}

		draw();
	}

}
