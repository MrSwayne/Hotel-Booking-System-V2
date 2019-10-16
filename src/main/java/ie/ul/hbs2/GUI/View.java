package ie.ul.hbs2.GUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

import ie.ul.hbs2.controllers.Controller;

public abstract class View extends JPanel{

     Controller controller;
     Frame parent;

     View next = null;
     View prev = null;

    View(String name, Frame parent) {
        this.parent = parent;
        this.parent.add(name, this);
    }

    View(Frame parent, View previous, View next) {

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setNext(View view) {
        this.next = view;
    }

    public void setPrevious(View view) {
        this.prev = view;
    }

    public abstract void setMessage(String message);
}