package edu.fiuba.algo3.modeloOpcional;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}