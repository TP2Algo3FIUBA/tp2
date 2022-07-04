package edu.fiuba.algo3.modeloOpcional;

public interface Observable {
    public void addObserver(Observer observer);

    public void notifyObservers();
}