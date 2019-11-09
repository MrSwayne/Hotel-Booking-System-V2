package ie.ul.hbs2;

import ie.ul.hbs2.GUI.*;
import ie.ul.hbs2.payments.BookingCharge;
import ie.ul.hbs2.payments.PaymentDispatcher;
import ie.ul.hbs2.payments.PaymentMethod;

import javax.swing.*;

public class HotelBookingSystem {

    private PaymentDispatcher paymentDispatcher;
    private Frame frame;

    public HotelBookingSystem() {

        //Frame to hold our views
        this.frame = new Frame();

        //Create Dispatchers
        this.paymentDispatcher = new PaymentDispatcher();
    }

    public void run() {
        //Start the GUI
        HotelSelectView hotelSelect = new HotelSelectView("hotelSelect", frame);
        PaymentView payments = new PaymentView("payments", frame);
        ManagementView management = new ManagementView("management", frame);

        //Select whatever gui already defined above ^^
        this.frame.show("management");
    }

    //Intercept any payments
    public boolean processPayment(BookingCharge charge) {
        this.paymentDispatcher.setCharge(charge);
        return this.paymentDispatcher.processPayment();
    }

    public void addPaymentMethod(PaymentMethod method) {
        this.paymentDispatcher.addPaymentMethod(method);
    }
}
