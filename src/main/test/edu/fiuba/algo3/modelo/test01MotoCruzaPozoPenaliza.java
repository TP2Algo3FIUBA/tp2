package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test01MotoCruzaPozoPenaliza {

    @Test
    public void prueba01(){
        // Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.

        // Arrrange
        Moto moto = new Moto();
        Pozo pozo = new Pozo();

        // Creacion calle
        Interseccion interseccion = new Interseccion(pozo);
        Esquina esquinaInicio = new Esquina();
        Esquina esquinaDestiono = new Esquina();

        // Union elementos de la calle
        interseccion.unirEsquinas(esquinaInicio, esquinaDestiono);
        esquinaInicio.asignarInterseccionDerecha(interseccion);
        esquinaDestiono.asignarInterseccionIzquierda(interseccion);

        // Creacion de jugador
        Jugador jugador = new Jugador(moto);
        jugador.cambiarPosicion(esquinaInicio);

        // Act
        jugador.moverHaciaLaDerecha();

        // Assert
        assertEquals(jugador.movimientosRestantes(), 7);

    }
}
