package ie.ul.hbs2.memento;

import ie.ul.hbs2.booking.Booking;

import javax.swing.*;

public class Memento {
    private Booking state;

    public Memento(Booking state){
        this.state = state;
    }

    public Booking getState(){
        return state;
    }
}
