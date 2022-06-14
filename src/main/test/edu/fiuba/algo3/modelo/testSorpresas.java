package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSorpresas {
    @Test
    void unaMotoChocaContraUnaSorpresaDeCambioDeVehiculoYSeTransformaAUnAuto() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Moto());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        assertTrue(jugador.getVehiculo() instanceof Auto);
    }


    @Test
    void unAutoChocaContraUnaSorpresaDeCambioDeVehiculoYSeTransformaAUnCuatroPorCuatro() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Auto());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        assertTrue(jugador.getVehiculo() instanceof CuatroPorCuatro);
    }

    @Test
    void unCuatroPorCuatroChocaContraUnaSorpresaDeCambioDeVehiculoYSeTransformaAUnaMoto() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new CuatroPorCuatro());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        assertTrue(jugador.getVehiculo() instanceof Moto);
    }

    @Test
    void unaMotoChocaContraUnaSorpresaDesfavorableYLeSumaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaDesfavorable());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Moto());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        jugador.moverEnDireccion("Oeste");
        assertEquals(3,jugador.getMovimientos());
    }

    @Test
    void unAutoChocaContraUnaSorpresaDesfavorableYLeSumaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaDesfavorable());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Auto());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        jugador.moverEnDireccion("Oeste");
        assertEquals(3,jugador.getMovimientos());
    }

    @Test
    void unCuatroPorCuatroChocaContraUnaSorpresaDesfavorableYLeSumaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaDesfavorable());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new CuatroPorCuatro());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        jugador.moverEnDireccion("Oeste");
        assertEquals(3,jugador.getMovimientos());
    }

    @Test
    void unaMotoChocaContraUnaSorpresaFavorableYLeRestaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaFavorable());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Moto());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        jugador.moverEnDireccion("Oeste");
        assertEquals(2,jugador.getMovimientos());
    }

    @Test
    void unAutoChocaContraUnaSorpresaFavorableYLeRestaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaFavorable());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new Auto());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        jugador.moverEnDireccion("Oeste");
        assertEquals(2,jugador.getMovimientos());
    }

    @Test
    void unCuatroPorCuatroChocaContraUnaSorpresaFavorableYLeRestaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaFavorable());
        esquina00.insertarCuadra("Este", cuadra00_01);
        esquina01.insertarCuadra("Oeste", cuadra00_01);

        Jugador jugador = new Jugador(new CuatroPorCuatro());
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion("Este");
        jugador.moverEnDireccion("Oeste");
        assertEquals(2,jugador.getMovimientos());
    }


}
