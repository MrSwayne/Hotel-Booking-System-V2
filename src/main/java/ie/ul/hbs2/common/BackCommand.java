package ie.ul.hbs2.common;


import ie.ul.hbs2.GUI.MainBookingView;

public class BackCommand implements Command{
    public BackCommand()
    {

    }
    @Override
    public void execute() {
        System.out.println("Back View");
    }
}
