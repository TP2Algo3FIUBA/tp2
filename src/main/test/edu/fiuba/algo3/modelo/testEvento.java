package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.evento.EventoVacio;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.manzana.Esquina;
import edu.fiuba.algo3.modelo.vehiculo.EstadoAuto;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testEvento {

    @Test
    public void eventoVacio(){
        EventoVacio evento = new EventoVacio();

        assertEquals(evento.getName(), "cuadra");
        Esquina esquina = new Esquina();

        assertEquals(evento.afectarJugador(new Jugador(new Vehiculo(new EstadoAuto())), new Esquina(),esquina),esquina);
    }
}
