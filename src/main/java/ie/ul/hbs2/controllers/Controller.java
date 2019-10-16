package ie.ul.hbs2.controllers;

import java.util.ArrayList;

import ie.ul.hbs2.GUI.View;

public abstract class Controller {

    protected ArrayList<View> observers;

    protected Controller() {
        observers = new ArrayList<>();
    }


    public abstract void addObserver(View view);

    public abstract void removeObserver(View view);

    public abstract void notifyObservers();
}