package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Meta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EsquinaView implements Observer, Drawable {
	private double esquinaScale = 1;
	private TableroView tableroView;
	ImageView esquinaImage;

	private Esquina esquina;

	private int lastXPosition;
	private int lastYPosition;

	public EsquinaView(TableroView tableroView, Esquina esquina) {
		this.tableroView = tableroView;
		this.esquina = esquina;

		this.lastXPosition = (int) esquina.getPosition().getFil();
		this.lastYPosition = (int) esquina.getPosition().getCol();

		esquina.addObserver(this);

		esquinaImage = new ImageView();
		esquinaImage.setScaleX(esquinaScale);
		esquinaImage.setScaleY(esquinaScale);
		esquinaImage.setFitHeight(64);
		esquinaImage.setFitWidth(64);

		if (esquina.checkearEstado() instanceof Meta) {
			esquinaImage.setImage(new Image("meta.png"));
		}
		else esquinaImage.setImage(new Image("esquina.png")); // cambiar por esquina.png
		tableroView.addViewOnMap(esquinaImage, (int) esquina.getPosition().getCol(), (int) esquina.getPosition().getFil()); // Del reves?
		System.out.println("Dibujando esquina de Fil:" + esquina.getPosition().getFil() + " Col:" + esquina.getPosition().getCol());
		draw();
	}

	@Override
	public void draw() {
		esquinaImage.setTranslateX(64 * this.esquina.getPosition().getCol());
		esquinaImage.setTranslateY(64 * this.esquina.getPosition().getFil());
		tableroView.updateView(esquinaImage);
	}

	private void changeEsquinaSkin(String fileName) {
		System.out.println(fileName);
		esquinaImage.setImage(new Image(fileName + ".png"));
	}

	//@Override
	public void change() {
		changeEsquinaSkin(esquina.getEsquinaName());
		int actualCol = (int) esquina.getPosition().getCol();
		int actualFil = (int) esquina.getPosition().getFil();
		if (lastXPosition > actualCol) {
			this.esquinaImage.setScaleX( -
			Math.abs(esquinaImage.getScaleX()));
		}

		else if (lastXPosition < actualCol) {
			this.esquinaImage.setScaleX(
			Math.abs(esquinaImage.getScaleX()));
		}
		this.lastXPosition = (int) esquina.getPosition().getFil();
		this.lastYPosition = (int) esquina.getPosition().getCol();
		tableroView.addViewOnMap(this.esquinaImage, actualCol, actualFil);
	}

}
