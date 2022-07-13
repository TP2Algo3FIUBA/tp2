package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direcciones.DirEste;
import edu.fiuba.algo3.modelo.direcciones.DirOeste;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaCambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.EstadoCuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.EstadoMoto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSorpresas {
    @Test
    void unaMotoChocaContraUnaSorpresaDeCambioDeVehiculoYSeTransformaAUnAuto() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        assertTrue(jugador.getEstadoVehiculo() instanceof EstadoAuto);
    }


    @Test
    void unAutoChocaContraUnaSorpresaDeCambioDeVehiculoYSeTransformaAUnCuatroPorCuatro() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        assertTrue(jugador.getEstadoVehiculo() instanceof EstadoCuatroPorCuatro);
    }

    @Test
    void unCuatroPorCuatroChocaContraUnaSorpresaDeCambioDeVehiculoYSeTransformaAUnaMoto() {
        // Arrange
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaCambioDeVehiculo());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoCuatroPorCuatro()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        assertTrue(jugador.getEstadoVehiculo() instanceof EstadoMoto);
    }

    @Test
    void unaMotoChocaContraUnaSorpresaDesfavorableYLeSumaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaDesfavorable());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Oeste);
        assertEquals(3,jugador.getMovimientos());
    }

    @Test
    void unAutoChocaContraUnaSorpresaDesfavorableYLeSumaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaDesfavorable());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Oeste);
        assertEquals(3,jugador.getMovimientos());
    }

    @Test
    void unCuatroPorCuatroChocaContraUnaSorpresaDesfavorableYLeSumaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaDesfavorable());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoCuatroPorCuatro()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Oeste);
        assertEquals(3,jugador.getMovimientos());
    }

    @Test
    void unaMotoChocaContraUnaSorpresaFavorableYLeRestaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaFavorable());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoMoto()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Oeste);
        assertEquals(2,jugador.getMovimientos());
    }

    @Test
    void unAutoChocaContraUnaSorpresaFavorableYLeRestaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaFavorable());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoAuto()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Oeste);
        assertEquals(2,jugador.getMovimientos());
    }

    @Test
    void unCuatroPorCuatroChocaContraUnaSorpresaFavorableYLeRestaUn25PorcientoDeLosMovimientosHechos(){
        Esquina esquina00 = new Esquina();  //   00 --#-- 01
        Esquina esquina01 = new Esquina();

        // Creo direcciones
        DirEste Este = new DirEste();
        DirOeste Oeste = new DirOeste();

        // conecto 00 con 01
        Cuadra cuadra00_01 = new Cuadra(esquina00, esquina01, new SorpresaFavorable());
        esquina00.insertarCuadra(Este, cuadra00_01);
        esquina01.insertarCuadra(Oeste, cuadra00_01);

        Jugador jugador = new Jugador( new Vehiculo(new EstadoCuatroPorCuatro()) );
        jugador.spawnearVehiculoEn(esquina00);

        jugador.moverEnDireccion(Este);
        jugador.moverEnDireccion(Oeste);
        assertEquals(2,jugador.getMovimientos());
    }
    @Test
    public void testSorpresaFav(){
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        Jugador jugador = new Jugador(new Vehiculo(new EstadoCuatroPorCuatro()));
        sorpresaFavorable.afectarJugador(jugador,new Esquina(), new Esquina());

        assertEquals(sorpresaFavorable.getName(), "sorpresa");
    }
    @Test
    public void testSorDes(){
        SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
        Jugador jugador = new Jugador(new Vehiculo(new EstadoCuatroPorCuatro()));
        sorpresaDesfavorable.afectarJugador(jugador,new Esquina(), new Esquina());

        assertEquals(sorpresaDesfavorable.getName(), "sorpresa");
    }
    @Test
    public void testCamb(){
        SorpresaCambioDeVehiculo sorpresaCambioDeVehiculo = new SorpresaCambioDeVehiculo();
        Jugador jugador = new Jugador(new Vehiculo(new EstadoCuatroPorCuatro()));
        sorpresaCambioDeVehiculo.afectarJugador(jugador,new Esquina(), new Esquina());

        assertEquals(sorpresaCambioDeVehiculo.getName(), "sorpresa");
    }

}
