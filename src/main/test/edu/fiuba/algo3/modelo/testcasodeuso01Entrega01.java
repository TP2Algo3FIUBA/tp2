package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Cuadra;
import edu.fiuba.algo3.modelo.manzana.Esquina;
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

        // Arrrange
        Jugador jugaddor = new Jugador();
        Moto moto = new Moto(jugaddor);

        Cuadra cuadra = new Cuadra( new Pozo());

        Esquina esquina = new Esquina(cuadra);

        moto.mover(esquina);

        // Assert
        assertEquals(4, moto.cantidadDeMovimientos());

    }

    @Test
    public void AutoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){

        // Arrrange
        Jugador jugaddor = new Jugador();
        Auto auto = new Auto(jugaddor);

        Cuadra cuadra = new Cuadra( new Pozo());

        Esquina esquina = new Esquina(cuadra);

        auto.mover(esquina);


        // Assert
        assertEquals(4, auto.cantidadDeMovimientos());

    }

    @Test
    public void Una4x4AtraviesaCiudadYSeEncuentraConUnPozoYNoEsPenalizada(){

        // Arrrange
        Jugador jugaddor = new Jugador();
        CuatroPorCuatro cuatroporcuatro = new CuatroPorCuatro(jugaddor);

        Cuadra cuadra = new Cuadra( new Pozo());

        Esquina esquina = new Esquina(cuadra);

        cuatroporcuatro.mover(esquina);


        // Assert
        assertEquals(1, cuatroporcuatro.cantidadDeMovimientos());

    }
    @Test
    public void Una4x4AtraviesaTresPozoYEsPenalizadaDosMovimientos(){

        // Arrrange
        Jugador jugaddor = new Jugador();
        CuatroPorCuatro cuatroporcuatro = new CuatroPorCuatro(jugaddor);

        Cuadra primerCuadra = new Cuadra( new Pozo());
        Esquina primerEsquina = new Esquina(primerCuadra);
        Cuadra segundaCuadra = new Cuadra( new Pozo());
        Esquina segundaEsquina = new Esquina(segundaCuadra);
        Cuadra tercerCuadra = new Cuadra( new Pozo());
        Esquina tercerEsquina = new Esquina(tercerCuadra);

        cuatroporcuatro.mover(primerEsquina);
        cuatroporcuatro.mover(segundaEsquina);
        cuatroporcuatro.mover(tercerEsquina);


        // Assert
        assertEquals(2, cuatroporcuatro.cantidadDeMovimientos());

    }
    @Test
    public void UnAutoAtraviesaCiudadYSeEncuentraConUnPiqueteYNoEsPenalizada(){

        // Arrrange
        Jugador jugaddor = new Jugador();
        Auto auto = new Auto(jugaddor);

        Cuadra cuadra = new Cuadra( new Piquete());

        Esquina esquina = new Esquina(cuadra);

        auto.mover(esquina);


        // Assert
        assertEquals(1, auto.cantidadDeMovimientos());

    }
}

