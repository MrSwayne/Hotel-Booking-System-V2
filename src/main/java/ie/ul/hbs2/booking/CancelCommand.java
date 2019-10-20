package ie.ul.hbs2.booking;


import ie.ul.hbs2.GUI.BookingSummaryView;

public class CancelCommand extends CommandSummary {
    public CancelCommand(BookingSummaryView button)
    {
        super(button);
    }
    @Override
    public boolean execute() {
        //Go back to Booking screen
        System.out.println("Going back to Booking Screen!");
        return false;
    }
}
