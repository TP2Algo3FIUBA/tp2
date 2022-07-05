package edu.fiuba.algo3.modelo;

public class Position {
    private int fil;
    private int col;

    public Position(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }

    @Override
    public String toString() {
        return "("+fil+", "+col+")";
    }

    public int getFil() {
        return fil;
    }

    public int getCol() {
        return col;
    }
}