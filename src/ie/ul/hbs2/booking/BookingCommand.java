package src.ie.ul.hbs2.booking;

import src.ie.ul.hbs2.booking.Command;

public class BookingCommand extends Command{
    public BookingCommand(Button button) 
    {
	super(button);
    }
    
    @Override
    public boolean execute() {
	    return true;
    }
}
