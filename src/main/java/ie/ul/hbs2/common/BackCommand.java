package ie.ul.hbs2.common;


import ie.ul.hbs2.GUI.MainBookingView;

public class BackCommand implements Command{
    public BackCommand(MainBookingView button)
    {

    }
    @Override
    public void execute() {
        System.out.println("Back View");
    }
}
