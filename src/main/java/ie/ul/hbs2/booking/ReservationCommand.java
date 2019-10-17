package ie.ul.hbs2.booking;

public class ReservationCommand extends Command {

    public ReservationCommand(MainBookingView button)
    {
        super(button);
    }
    @Override
    public boolean execute() {
        MainBookingView view = new MainBookingView();
        view.ReserveViewWindow1();

        System.out.println("Next View");
        return false;
    }
}
