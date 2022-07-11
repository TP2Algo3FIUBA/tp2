package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Meta;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EsquinaView implements Observer, Drawable {
	private double esquinaScale = 1;
	private TableroView tableroView;
	ImageView esquinaImage;

	private Esquina esquina;
	private Jugador jugador;

	public EsquinaView(TableroView tableroView, Esquina esquina, Jugador jugador) {
		this.tableroView = tableroView;
		this.esquina = esquina;
		this.jugador = jugador;

		this.esquina.addObserver(this);
		this.jugador.addObserver(this);

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
		change();
		draw();
	}

	@Override
	public void draw() {
		esquinaImage.setTranslateX(64 * this.esquina.getPosition().getCol());
		esquinaImage.setTranslateY(64 * this.esquina.getPosition().getFil());
		tableroView.updateView(esquinaImage);
	}

	@Override
	public void change() {
		esquinaImage.setOpacity(100);
		if (!(esquina.checkearEstado() instanceof Meta)) {
			int actualCol = (int) esquina.getPosition().getCol();
			if (Math.abs(jugador.getPosition().getCol() - actualCol) > 1) {
				esquinaImage.setOpacity(0);
			}

			int actualFil = (int) esquina.getPosition().getFil();
			if (Math.abs(jugador.getPosition().getFil() - actualFil) > 1) {
				esquinaImage.setOpacity(0);
			}
		}
		draw();
	}

}
