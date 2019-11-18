package ie.ul.hbs2.common;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.MainBookingView;
import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.booking.BookingManager;

public class NextCommand implements Command {

    private Booking book;
    private Frame parent;

    public NextCommand()
    {

    }

    public NextCommand(Booking book, Frame parent) {
        this.book = book;
        this.parent = parent;
    }

    @Override
    public void execute() {
        BookingManager manager = new BookingManager();
        manager.checkBooking(book,parent);

    }

}


