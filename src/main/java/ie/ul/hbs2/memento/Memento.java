package ie.ul.hbs2.memento;

import javax.swing.*;

public class Memento {
    private JPanel state;

    public Memento(JPanel state){
        this.state = state;
    }

    public JPanel getState(){
        return state;
    }
}
