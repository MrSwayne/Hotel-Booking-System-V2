package ie.ul.hbs2.controllers;

import java.util.ArrayList;

import ie.ul.hbs2.GUI.View;

public abstract class Controller {

    protected ArrayList<View> observers;

    protected Controller() {
        observers = new ArrayList<>();
    }


    public void addObserver(View view) {
        this.observers.add(view);
    }

    public void removeObserver(View view) {
        this.observers.remove(view);
    }

}