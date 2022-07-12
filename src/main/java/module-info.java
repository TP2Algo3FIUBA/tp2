module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
		requires org.yaml.snakeyaml;
    opens edu.fiuba.algo3 to javafx.fxml;
    exports edu.fiuba.algo3;
    opens edu.fiuba.algo3.vista to javafx.fxml;
    exports edu.fiuba.algo3.vista;
    opens edu.fiuba.algo3.controlador to javafx.fxml;
    exports edu.fiuba.algo3.controlador;
}