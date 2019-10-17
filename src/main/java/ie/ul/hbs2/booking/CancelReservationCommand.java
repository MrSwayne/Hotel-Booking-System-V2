package ie.ul.hbs2.booking;


public class CancelReservationCommand extends Command {
    public CancelReservationCommand(MainBookingView button)
    {
        super(button);
    }
    @Override
    public boolean execute() {
        return false;
    }
}
