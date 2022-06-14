package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.manzana.Tablero;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testcasodeuso01Entrega01 {

    @Test
    public void UnaMotoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){
        // Arrange
        Esquina esquina00 = new Esquina();          //   00 -*-- 01
        Esquina esquina01 = new Esquina();          //    |       |
                                                    //    *       *
        Esquina esquina10 = new Esquina();          //    |       |
        Esquina esquina11 = new Esquina();          //   10 -*-- 11
        Tablero tablero = new Tablero();
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
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Moto moto = new Moto();
        Jugador jugador = new Jugador(moto);

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Sur");
        Esquina esquinaDestino = juego.obtenerPosicionJugador();

        // Assert
        assertEquals(esquinaDestino, esquina10);
        assertEquals(4, juego.cantMovJugador());
    }

    @Test
    public void AutoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){

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
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Pozo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo());
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
        juego.moverJugadorEnDireccion("Sur");
        Esquina esquinaDestino = juego.obtenerPosicionJugador();

        // Assert
        assertEquals(4, jugador.getMovimientos());

    }

    @Test
    public void Una4x4AtraviesaCiudadYSeEncuentraConUnPozoYNoEsPenalizada(){

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
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Pozo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Jugador jugador = new Jugador(cxc);

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Sur");
        Esquina esquinaDestino = juego.obtenerPosicionJugador();

        // Assert
        assertEquals(1, jugador.getMovimientos());

    }
    @Test
    public void Una4x4AtraviesaTresPozoYEsPenalizadaDosMovimientos(){
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
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new Pozo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        // conecto 10 con 11
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Pozo());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Pozo());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Pozo());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        CuatroPorCuatro cxc = new CuatroPorCuatro();
        Jugador jugador = new Jugador(cxc);

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Sur");
        juego.moverJugadorEnDireccion("Norte");
        juego.moverJugadorEnDireccion("Sur");
        Esquina esquinaDestino = juego.obtenerPosicionJugador();

        // Assert
        assertEquals(5, jugador.getMovimientos());

    }
    @Test
    public void UnAutoAtraviesaCiudadYSeEncuentraConUnPiqueteYNoEsPenalizada(){
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
        Cuadra cuadra10_11 = new Cuadra(esquina10, esquina11, new Piquete());
        esquina10.insertarCuadra("Este", cuadra10_11);
        esquina11.insertarCuadra("Oeste", cuadra10_11);

        // conecto 00 con 10
        Cuadra cuadra00_10 = new Cuadra(esquina00, esquina10, new Piquete());
        esquina00.insertarCuadra("Sur", cuadra00_10);
        esquina10.insertarCuadra("Norte", cuadra00_10);

        // conecto 01 con 11
        Cuadra cuadra01_11 = new Cuadra(esquina01, esquina11, new Piquete());
        esquina01.insertarCuadra("Sur", cuadra01_11);
        esquina11.insertarCuadra("Norte", cuadra01_11);

        // creo Jugador con su Vehiculo
        Auto auto = new Auto();
        Jugador jugador = new Jugador(auto);

        // creo Juego con su Jugador y Tablero
        Juego juego = new Juego(jugador, tablero);
        juego.spawnearJugadorEn(0,0);

        // Act
        juego.moverJugadorEnDireccion("Sur");
        Esquina esquinaDestino = juego.obtenerPosicionJugador();

        // Assert
        assertEquals(esquinaDestino, esquina00);
        assertEquals(1, juego.cantMovJugador());
    }

}

