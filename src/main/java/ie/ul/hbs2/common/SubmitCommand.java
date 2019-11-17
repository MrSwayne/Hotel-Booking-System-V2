package ie.ul.hbs2.common;


import ie.ul.hbs2.GUI.BookingSummaryView;

public class SubmitCommand implements Command {
    public SubmitCommand()
    {

    }
    @Override
    public void execute() {
        //Go to charge??

        System.out.println("Going to Charge Screen!");
    }
}
