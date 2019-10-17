package ie.ul.hbs2.booking;



public abstract class Command {
    public MainBookingView click;

    Command(MainBookingView click) {
        this.click = click;
    }

    public abstract boolean execute();
}
