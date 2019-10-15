package ie.ul.hbs2.booking;

import ie.ul.hbs2.booking.Command;

public class SubmitCommand extends Command {
        public SubmitCommand(BookingView button)
        {
    	super(button);
        }
        
        @Override
        public boolean execute() {
            //add logic here when submitting booking or cancel
    	return true;
        }
    }


