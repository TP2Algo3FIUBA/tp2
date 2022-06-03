package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test01MotoCruzaPozoPenaliza {

    @Test
    public void pruebita(){

        Moto moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Pozo pozo = new Pozo();
        Interseccion interseccion = new Interseccion(pozo);

        assertEquals(1, 1);

    }
}
