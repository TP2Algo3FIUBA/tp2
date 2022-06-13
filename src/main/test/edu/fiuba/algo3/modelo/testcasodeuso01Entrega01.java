package edu.fiuba.algo3.modelo;
/*
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.Sorpresa;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testcasodeuso01Entrega01 {

    @Test
    public void UnaMotoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){

        // Arrrange
        Esquina esquina00 = new Esquina(00); //   00 ---- 01
        Esquina esquina01 = new Esquina(01); //    |       |
        Esquina esquina10 = new Esquina(10); //    |       |
        Esquina esquina11 = new Esquina(11); //   10 ----  11

        Cuadra cuadra00_01 = new Cuadra(esquina00, "derecha", esquina01, "izquierda", new Pozo(), new Sorpresa());
        Cuadra cuadra00_10 = new Cuadra(esquina00, "abajo", esquina10, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra01_11 = new Cuadra(esquina01, "abajo", esquina11, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra10_11 = new Cuadra(esquina10, "derecha", esquina11, "izquierda", new Pozo(), new Sorpresa());

        // init jugador en posicion 00
        Jugador jugador = new Jugador(new Moto(esquina00));

        // Act
        jugador.movDerecha();

        // Assert
        assertEquals(4, jugador.cantidadDeMovimientos());
        assertEquals(01, jugador.posicion());
    }

    @Test
    public void AutoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){

        // Arrrange
        Esquina esquina00 = new Esquina(00); //   00 ---- 01
        Esquina esquina01 = new Esquina(01); //    |       |
        Esquina esquina10 = new Esquina(10); //    |       |
        Esquina esquina11 = new Esquina(11); //   10 ----  11

        Cuadra cuadra00_01 = new Cuadra(esquina00, "derecha", esquina01, "izquierda", new Pozo(), new Sorpresa());
        Cuadra cuadra00_10 = new Cuadra(esquina00, "abajo", esquina10, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra01_11 = new Cuadra(esquina01, "abajo", esquina11, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra10_11 = new Cuadra(esquina10, "derecha", esquina11, "izquierda", new Pozo(), new Sorpresa());

        // init jugador en posicion 00
        Jugador jugador = new Jugador(new Auto(esquina00));

        // Act
        jugador.movDerecha();

        // Assert
        assertEquals(4, jugador.cantidadDeMovimientos());
        assertEquals(01, jugador.posicion());

    }

    @Test
    public void Una4x4AtraviesaCiudadYSeEncuentraConUnPozoYNoEsPenalizada(){

        // Arrrange
        Esquina esquina00 = new Esquina(00); //   00 ---- 01
        Esquina esquina01 = new Esquina(01); //    |       |
        Esquina esquina10 = new Esquina(10); //    |       |
        Esquina esquina11 = new Esquina(11); //   10 ----  11

        Cuadra cuadra00_01 = new Cuadra(esquina00, "derecha", esquina01, "izquierda", new Pozo(), new Sorpresa());
        Cuadra cuadra00_10 = new Cuadra(esquina00, "abajo", esquina10, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra01_11 = new Cuadra(esquina01, "abajo", esquina11, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra10_11 = new Cuadra(esquina10, "derecha", esquina11, "izquierda", new Pozo(), new Sorpresa());

        // init jugador en posicion 00
        Jugador jugador = new Jugador(new CuatroPorCuatro(esquina00));

        // Act
        jugador.movDerecha();

        // Assert
        assertEquals(1, jugador.cantidadDeMovimientos());
        assertEquals(01, jugador.posicion());

    }
    @Test
    public void Una4x4AtraviesaTresPozoYEsPenalizadaDosMovimientos(){

        // Arrrange
        Esquina esquina00 = new Esquina(00); //   00 ---- 01
        Esquina esquina01 = new Esquina(01); //    |       |
        Esquina esquina10 = new Esquina(10); //    |       |
        Esquina esquina11 = new Esquina(11); //   10 ----  11

        Cuadra cuadra00_01 = new Cuadra(esquina00, "derecha", esquina01, "izquierda", new Pozo(), new Sorpresa());
        Cuadra cuadra00_10 = new Cuadra(esquina00, "abajo", esquina10, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra01_11 = new Cuadra(esquina01, "abajo", esquina11, "arriba", new Pozo(), new Sorpresa());
        Cuadra cuadra10_11 = new Cuadra(esquina10, "derecha", esquina11, "izquierda", new Pozo(), new Sorpresa());

        // init jugador en posicion 00
        Jugador jugador = new Jugador(new CuatroPorCuatro(esquina00));

        // Act
        jugador.movDerecha();
        jugador.movAbajo();
        jugador.movIzquierda();

        // Assert
        assertEquals(5, jugador.cantidadDeMovimientos());

    }
    @Test
    public void UnAutoAtraviesaCiudadYSeEncuentraConUnPiqueteYNoEsPenalizada(){

        // Arrrange
        Esquina esquina00 = new Esquina(00); //   00 ---- 01
        Esquina esquina01 = new Esquina(01); //    |       |
        Esquina esquina10 = new Esquina(10); //    |       |
        Esquina esquina11 = new Esquina(11); //   10 ----  11

        Cuadra cuadra00_01 = new Cuadra(esquina00, "derecha", esquina01, "izquierda", new Piquete(), new Sorpresa());
        Cuadra cuadra00_10 = new Cuadra(esquina00, "abajo", esquina10, "arriba", new Piquete(), new Sorpresa());
        Cuadra cuadra01_11 = new Cuadra(esquina01, "abajo", esquina11, "arriba", new Piquete(), new Sorpresa());
        Cuadra cuadra10_11 = new Cuadra(esquina10, "derecha", esquina11, "izquierda", new Piquete(), new Sorpresa());

        // init jugador en posicion 00
        Jugador jugador = new Jugador(new CuatroPorCuatro(esquina00));

        // Act
        jugador.movDerecha();

        // Assert
        assertEquals(1, jugador.cantidadDeMovimientos());
        assertEquals(01, jugador.posicion());
    }
}

*/