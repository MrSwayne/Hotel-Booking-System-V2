package ie.ul.hbs2.booking;


public class NextCommand extends Command {

    public NextCommand(MainBookingView button)
    {
        super(button);
    }
    @Override
    public boolean execute() {
        System.out.println("Next View");
        return false;
    }
}


