package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testcasodeuso01Entrega01 {

    @Test
    public void UnaMotoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){

        // Arrrange
        Jugador jugaddor = new Jugador();
        Moto moto = new Moto(jugaddor);

        Cuadra cuadra = new Cuadra( new Pozo());

        Esquina esquina = new Esquina(cuadra);

        moto.mover(esquina);


        // Assert
        assertEquals(3, moto.turnosPenalizados());

    }
}
