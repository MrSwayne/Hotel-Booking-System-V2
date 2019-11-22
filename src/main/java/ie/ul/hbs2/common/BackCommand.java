package ie.ul.hbs2.common;


import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.memento.Memento;

import javax.swing.*;

public class BackCommand implements Command{
    private JPanel location;
    private Frame parent;

    public BackCommand(Memento location, Frame parent)
    {
        this.location = location.getState();
        this.parent = parent;
    }
    @Override
    public void execute() {
        System.out.println("Back View");
        parent.getContentPane().removeAll();
        parent.repaint();
        parent.add(location);
    }
}
