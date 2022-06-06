package edu.fiuba.algo3.modelo;

public class Interseccion {

    private Esquina esquinaUno;
    private Esquina esquinaDos;
    private Obstaculo obstaculo;

    public Interseccion(Obstaculo obs){ // recibir obstaculo/sorpresa
        obstaculo = obs;
    }

    public void unirEsquinas(Esquina esquinaA, Esquina esquinaB) {
        esquinaUno = esquinaA;
        esquinaDos = esquinaB;
    }

    private Esquina opuesta(Esquina origen) {
        if(origen.equals(esquinaUno)){
            return esquinaDos;
        }
        return esquinaUno;
    }

    public Esquina moverAOpuesto(Esquina esquina, Jugador jugador) {
        Esquina destino = this.opuesta(esquina);

        // penalizaciones por interseccion
        obstaculo.aplicarPenalizacion(jugador);

        // movemos jugador a posicion nueva
        return destino;
    }
}
