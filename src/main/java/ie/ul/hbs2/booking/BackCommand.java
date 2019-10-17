package ie.ul.hbs2.booking;


public class BackCommand extends Command{
    public BackCommand(MainBookingView button)
    {
        super(button);
    }
    @Override
    public boolean execute() {
        System.out.println("Back View");
        return false;
    }
}
