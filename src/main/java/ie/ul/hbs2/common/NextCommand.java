package ie.ul.hbs2.common;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.MainBookingView;
import ie.ul.hbs2.booking.Booking;
import ie.ul.hbs2.booking.BookingManager;

import java.util.ArrayList;

public class NextCommand implements Command {

    private Booking book;
    private ArrayList<Object[]> selectedData;
    private Frame parent;
    int type;


    public NextCommand(Booking book, Frame parent) {
        this.book = book;
        this.parent = parent;
        type = 0;
    }

    public NextCommand(ArrayList<Object[]> selectedData, Frame parent) {
        this.selectedData = selectedData;
        this.parent = parent;
        type= 1;
    }

    @Override
    public void execute() {
        if(type == 1)
        {
            MainBookingView bookingView = new MainBookingView("booking",parent);
            bookingView.getRoomsBooked(selectedData);
            parent.show(bookingView);
        }else if(type==0){
            BookingManager manager = new BookingManager();
            manager.checkBooking(book,parent);
        }


    }

}


