package edu.fiuba.algo3.modelo;

public class Interseccion {

    private Esquina esquinaUno;
    private Esquina esquinaDos;
    private Pozo obstaculo; // Muy mal

    public Interseccion(Pozo pozo){ // recibir obstaculo/sorpresa
        obstaculo = pozo;
    }

    public void unirEsquinas(Esquina esquinaA, Esquina esquinaB) {
        esquinaUno = esquinaA;
        esquinaDos = esquinaB;
    }

    private Esquina opuesta(Esquina origen) {
        // cambiar
        return esquinaDos;
    }

    public Esquina moverAOpuesto(Esquina esquina, Jugador jugador) {
        Esquina destino = this.opuesta(esquina);

        // penalizaciones por interseccion
        obstaculo.aplicarPenalizacion(jugador);

        // movemos jugador a posicion nueva
        return destino;
    }
}
