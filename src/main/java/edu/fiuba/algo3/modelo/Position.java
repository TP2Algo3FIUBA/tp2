package edu.fiuba.algo3.modelo;

public class Position {
    private double fil;
    private double col;

    public Position(double fil, double col) {
        this.fil = fil;
        this.col = col;
    }

    @Override
    public String toString() {
        return "("+fil+", "+col+")";
    }

    public double getFil() {
        return fil;
    }

    public double getCol() {
        return col;
    }
}