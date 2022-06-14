package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testcasodeuso02Entrega02 {


    @Test
    public void unVehículoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable(){
        // Arrange
        Esquina esquina00 = new Esquina();          //   00 --*-- 01
        Esquina esquina01 = new Esquina();          //    |       |
        Esquina esquina10 = new Esquina();          //    $       *
        Esquina esquina11 = new Esquina();          //    |       |
        Tablero tablero = new Tablero();            //   10 --*-- 11
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Pozo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new SorpresaFavorable());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Jugador jugador = new Jugador(new Auto());

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Este");
        juego.moverJugadorEnDireccion("Sur");
        juego.moverJugadorEnDireccion("Oeste");
        juego.moverJugadorEnDireccion("Norte");
        // Assert
        assertEquals(9, jugador.getMovimientos());

    }

    @Test
    public void unVehículoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable(){
        // Arrange
        Esquina esquina00 = new Esquina();          //   00 --*-- 01
        Esquina esquina01 = new Esquina();          //    |       |
        Esquina esquina10 = new Esquina();          //    $       *
        Esquina esquina11 = new Esquina();          //    |       |
        Tablero tablero = new Tablero();            //   10 --*-- 11
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Pozo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new SorpresaDesfavorable());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Jugador jugador = new Jugador(new Auto());

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Este");
        juego.moverJugadorEnDireccion("Sur");
        juego.moverJugadorEnDireccion("Oeste");
        juego.moverJugadorEnDireccion("Norte");
        // Assert
        assertEquals(16, jugador.getMovimientos());

    }

    @Test
    public void unVehículoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehículo(){

        // Arrange
        Esquina esquina00 = new Esquina();          //   00 --$-- 01
        Esquina esquina01 = new Esquina();          //    |       |
        Esquina esquina10 = new Esquina();          //    *       *
        Esquina esquina11 = new Esquina();          //    |       |
        Tablero tablero = new Tablero();            //   10 --*-- 11
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Pozo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Jugador jugador = new Jugador(new Auto());

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Este");
        juego.moverJugadorEnDireccion("Sur");
        juego.moverJugadorEnDireccion("Oeste");
        juego.moverJugadorEnDireccion("Norte");
        // Assert
        assertTrue(jugador.getVehiculo() instanceof CuatroPorCuatro);
    }
    @Test
    public void jugadorConMotoAtraviezaCiudadYSeEncuentraConSorpresaCambioDeVehiculo(){

        // Arrange
        Esquina esquina00 = new Esquina();          //   00 --$-- 01
        Esquina esquina01 = new Esquina();          //    |       |
        Esquina esquina10 = new Esquina();          //    |       *
        Esquina esquina11 = new Esquina();          //    |       |
        Tablero tablero = new Tablero();            //   10 --*-- 11
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10);
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Jugador jugador = new Jugador(new Moto());

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Este");
        juego.moverJugadorEnDireccion("Sur");
        juego.moverJugadorEnDireccion("Oeste");
        juego.moverJugadorEnDireccion("Norte");
        // Assert
        assertTrue(jugador.getVehiculo() instanceof Auto);

    }

    @Test
    public void jugadorConAutoAtraviezaCiudadSeEncuentraConPiqueteYNoAvanza(){
        // Arrange
        Esquina esquina00 = new Esquina();          //   00 ---- 01
        Esquina esquina01 = new Esquina();          //    |       |
        Esquina esquina10 = new Esquina();          //    |       |
        Esquina esquina11 = new Esquina();          //   10 ---- 11
        Tablero tablero = new Tablero();
        tablero.agregarEsquina(0, esquina00);
        tablero.agregarEsquina(0, esquina01);
        tablero.agregarEsquina(1, esquina10);
        tablero.agregarEsquina(1, esquina11);

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Piquete());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11);
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10);
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11);
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Jugador jugador = new Jugador(new Auto());

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Este");
        assertEquals(esquina00,jugador.posicionActual());

        juego.moverJugadorEnDireccion("Sur");
        // Assert
        assertEquals(esquina10,jugador.posicionActual());


    }

}

