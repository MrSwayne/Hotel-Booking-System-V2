package ie.ul.hbs2.booking;

import ie.ul.hbs2.booking.Command;

public class CancelCommand extends Command {
    public CancelCommand(BookingView button)
    {
	super(button);
    }
    
    @Override
    public boolean execute() {
	return true;
    }
}
