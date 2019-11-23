package ie.ul.hbs2.common;


import ie.ul.hbs2.GUI.BookingSummaryView;
import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.PaymentView;
import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.booking.BookingManager;
import ie.ul.hbs2.memento.Memento;
import ie.ul.hbs2.payments.IPaymentCallback;

import java.text.ParseException;

public class SubmitCommand implements Command {
    private IPaymentCallback callback;
    private Booking book;
    private Frame parent;

    public SubmitCommand(IPaymentCallback callback, Booking book, Frame parent){
        this.callback = callback;
        this.book = book;
        this.parent = parent;
    }

    @Override
    public void execute() {
        try {
            BookingManager manager = new BookingManager();
            manager.addBooking(book.getDateIn(),book.getDateOut());
            if(manager.checkGuest(book.getFirstName(),book.getLastName()))
            {
                manager.addGuest(book.getFirstName(), book.getLastName(), book.getDateIn());
            }else{
                manager.updateGuest(book.getFirstName(),book.getLastName(),book.getTotalSpent(),book.getMemLvl());
            }
            manager.addPayment(book.getTotalSpent(),book.getBID());
            manager.updateRooms(book.getRID(),book.getBID());

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        PaymentView paymentView = (PaymentView) parent.get("payments");
        paymentView.showPaymentScreen(this.callback, book);

        System.out.println("Going to Charge Screen!");
    }
}
