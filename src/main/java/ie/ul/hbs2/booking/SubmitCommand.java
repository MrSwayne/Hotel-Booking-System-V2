package ie.ul.hbs2.booking;


import ie.ul.hbs2.GUI.BookingSummaryView;

public class SubmitCommand extends CommandSummary {
    public SubmitCommand(BookingSummaryView button)
    {
        super(button);
    }
    @Override
    public void execute() {
        //Go to charge??

        System.out.println("Going to Charge Screen!");
    }
}
