package ie.ul.hbs2.booking;


import ie.ul.hbs2.GUI.MainBookingView;

public abstract class Command {
    public MainBookingView click;

    Command(MainBookingView click) {
        this.click = click;
    }

    public Command() {
    }

    public abstract void execute();
}
