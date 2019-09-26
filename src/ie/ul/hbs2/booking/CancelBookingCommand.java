package src.ie.ul.hbs2.booking;

import src.ie.ul.hbs2.booking.Command;

public class CancelBookingCommand extends Command {
    public CancelBookingCommand(Button button)
    {
	super(button);
    }
    
    @Override
    public boolean execute() {
	return true;
    }
}
