package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.MainBookingView;

public class NextCommand extends Command {


    public NextCommand(MainBookingView button)
    {
        super(button);
    }
    @Override
    public boolean execute() {
        return false;
    }

}


