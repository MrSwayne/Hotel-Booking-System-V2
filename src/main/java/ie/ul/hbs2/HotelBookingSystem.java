package ie.ul.hbs2;

import ie.ul.hbs2.GUI.*;
import ie.ul.hbs2.controllers.PaymentController;
import ie.ul.hbs2.payments.BookingCharge;
import ie.ul.hbs2.payments.IPaymentMethod;
import ie.ul.hbs2.payments.PaymentDispatcher;
import ie.ul.hbs2.payments.IPaymentMethod;

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
        payments.attachDispatcher(this.paymentDispatcher);

        ManagementView management = new ManagementView("management", frame);
        MainBookingView booking = new MainBookingView("booking", frame);

        BookingSummaryView bs = new BookingSummaryView("Booking Summary", frame);


        //payment test
        bs.summary("test", "123", "25/09/2019", "17/10/2019", "3", "double", 15, 1000);
        this.frame.show(bs);
    }

    public void addPaymentMethod(IPaymentMethod method) {
        this.paymentDispatcher.addPaymentMethod(method);
    }
}
