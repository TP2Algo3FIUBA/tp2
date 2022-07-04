package edu.fiuba.algo3.modeloOpcional;

import java.util.ArrayList;
import java.util.HashMap;

public class Map implements Observable {
    private static final int heigth = 6;
    private static final int width = 6;
    private HashMap<String, Cell> cells;
    private ArrayList<Observer> observers;

    public Map() {
        super();
        observers = new ArrayList<Observer>();
        cells = new HashMap<String, Cell>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                cells.put(new Position(i, j).toString(), new Cell());
            }

        }
    }

    public void positionate(Positionable positionable, Position position) {
        cells.get(position.toString()).occupy(positionable);
        positionable.setPosition(position);
    }

    public int getHeigth() {
        return heigth;
    }

    public int getWidth() {
        return width;
    }

    public void movePositionableToLeft(Positionable positionable) {
        movePositionableTo(positionable,
                new Position(positionable.getPosition().getX() - 1, positionable.getPosition().getY()));
    }

    public void movePositionableToRigth(Positionable positionable) {
        movePositionableTo(positionable,
                new Position(positionable.getPosition().getX() + 1, positionable.getPosition().getY()));
    }

    public void movePositionableToUp(Positionable positionable) {
        movePositionableTo(positionable,
                new Position(positionable.getPosition().getX(), positionable.getPosition().getY() - 1));
    }

    public void movePositionableToDown(Positionable positionable) {
        movePositionableTo(positionable,
                new Position(positionable.getPosition().getX(), positionable.getPosition().getY() + 1));
    }

    private void movePositionableTo(Positionable positionable, Position position) {
        Cell fromMove = cells.get(positionable.getPosition().toString());
        if (!fromMove.hasOccupant(positionable)) {
            throw new RuntimeException("There is no target!");
        }
        positionate(positionable, position);
        fromMove.dropOccupant();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.change());
    }
}