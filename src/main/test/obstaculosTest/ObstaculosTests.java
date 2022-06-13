package obstaculosTest;

import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.*;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObstaculosTests {

    @Test
    public void UnaMotoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){
        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Pozo unPozo = new Pozo();
        Cuadra cuadra = new Cuadra(inicio, destino, unPozo);
        Moto moto = new Moto();
        Jugador conductor = new Jugador(moto);
        moto.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(moto);

        assertEquals(0, conductor.getMovimientos());

        inicio.moverVehiculo("Sur");

        assertEquals(4, conductor.getMovimientos());
    }

    @Test
    public void UnaAutoAtraviesaCiudadYSeEncuentraConUnPozoYEsPenalizadaTresMovimientos(){
        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Pozo unPozo = new Pozo();
        Cuadra cuadra = new Cuadra(inicio, destino, unPozo);
        Auto auto = new Auto();
        Jugador conductor = new Jugador(auto);
        auto.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(auto);

        assertEquals(0, conductor.getMovimientos());

        inicio.moverVehiculo("Sur");

        assertEquals(4, conductor.getMovimientos());
    }

    @Test
    public void Una4x4AtraviesaCiudadYSeEncuentraConUnPozoYNoEsPenalizada(){
        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Pozo unPozo = new Pozo();
        Cuadra cuadra = new Cuadra(inicio, destino, unPozo);
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
        Jugador conductor = new Jugador(cuatroPorCuatro);
        cuatroPorCuatro.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(cuatroPorCuatro);

        assertEquals(0, conductor.getMovimientos());

        inicio.moverVehiculo("Sur");

        assertEquals(1, conductor.getMovimientos());


    }

    @Test
    public void Una4x4AtraviesaTresPozoYEsPenalizadaDosMovimientos(){

        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Pozo unPozo = new Pozo();
        Cuadra cuadra = new Cuadra(inicio, destino, unPozo);
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
        Jugador conductor = new Jugador(cuatroPorCuatro);
        cuatroPorCuatro.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(cuatroPorCuatro);

        inicio.moverVehiculo("Sur");
        destino.moverVehiculo("Norte");
        inicio.moverVehiculo("Sur");

        assertEquals(5, conductor.getMovimientos());

    }

    @Test
    public void UnAutoAtraviesaCiudadYSeEncuentraConUnPiqueteYNoPuedePasar(){
        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Piquete unPiquete = new Piquete();
        Cuadra cuadra = new Cuadra(inicio, destino, unPiquete);
        Auto auto = new Auto();
        Jugador conductor = new Jugador(auto);
        auto.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(auto);

        assertThrows(HayUnPiqueteException.class, () -> {
            inicio.moverVehiculo("Sur");
        });
    }

    @Test
    public void UnCuatroPorCuatroAtraviesaCiudadYSeEncuentraConUnPiqueteYNoPuedePasar(){
        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Piquete unPiquete = new Piquete();
        Cuadra cuadra = new Cuadra(inicio, destino, unPiquete);
        CuatroPorCuatro cuatroPorCuatro = new CuatroPorCuatro();
        Jugador conductor = new Jugador(cuatroPorCuatro);
        cuatroPorCuatro.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(cuatroPorCuatro);

        assertThrows(HayUnPiqueteException.class, () -> {
            inicio.moverVehiculo("Sur");
        });
    }

    @Test
    public void UnaMotoAtraviesaUnPiqueteYEsPenalizadaEnTresMovimientos(){

        Esquina inicio = new Esquina();
        Esquina destino = new Esquina();
        Piquete unPiquete = new Piquete();
        Cuadra cuadra = new Cuadra(inicio, destino, unPiquete);
        Moto moto = new Moto();
        Jugador conductor = new Jugador(moto);
        moto.setConductor(conductor);

        inicio.insertarCuadra("Sur", cuadra);
        destino.insertarCuadra("Norte", cuadra);
        inicio.posicionarVehiculo(moto);

        inicio.moverVehiculo("Sur");

        assertEquals(3, conductor.getMovimientos());

    }
}
