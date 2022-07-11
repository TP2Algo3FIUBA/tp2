package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CuadraView implements Observer, Drawable {
	private double esquinaScale = 0.85;
	private TableroView tableroView;
	ImageView cuadraImage;

	private Cuadra cuadra;

	private double lastXPosition;
	private double lastYPosition;
	private Jugador jugador;

	public CuadraView(TableroView tableroView, Cuadra cuadra, Jugador jugador) {
		this.tableroView = tableroView;
		this.cuadra = cuadra;
		this.jugador = jugador;

		this.lastXPosition = cuadra.getPosition().getFil();
		this.lastYPosition = cuadra.getPosition().getCol();

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
		//cuadraImage.setImage(new Image("oscuridad.png"));
	}

	//@Override
	public void change() {
		changeCuadraSkin(cuadra.getTipoCuadraName());
		double actualCol = cuadra.getPosition().getCol();
		double actualFil = cuadra.getPosition().getFil();
		/*if (lastXPosition > actualCol) {
			this.playerImage.setScaleX( -
					Math.abs(playerImage.getScaleX()));
		}

		else if (lastXPosition < actualCol) {
			this.playerImage.setScaleX(
					Math.abs(playerImage.getScaleX()));
		}*/
		this.lastXPosition = (int) cuadra.getPosition().getFil();
		this.lastYPosition = (int) cuadra.getPosition().getCol();
		tableroView.addViewOnMap(this.cuadraImage, (int) actualCol, (int) actualFil);

	}

}
