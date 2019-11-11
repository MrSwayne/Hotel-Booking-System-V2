package ie.ul.hbs2.booking;


import ie.ul.hbs2.GUI.MainBookingView;

public class BackCommand extends Command{
    public BackCommand(MainBookingView button)
    {
        super(button);
    }
    @Override
    public void execute() {
        System.out.println("Back View");
    }
}
