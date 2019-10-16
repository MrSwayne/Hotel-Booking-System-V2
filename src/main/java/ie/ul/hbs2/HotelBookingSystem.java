package ie.ul.hbs2;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.HotelSelectView;
import ie.ul.hbs2.GUI.View;
import ie.ul.hbs2.payments.BookingCharge;

import javax.swing.*;

public class HotelBookingSystem {

    public HotelBookingSystem() {
        //Start login GUI
        Frame frame = new Frame();

        HotelSelectView hotelSelect = new HotelSelectView("Hotel Select", frame);
    }

    public void processPayment(BookingCharge charge) {

    }


}
