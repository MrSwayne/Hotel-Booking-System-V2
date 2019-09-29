package ie.ul.hbs2.booking;

public abstract class Command {
    public BookingView click;
    
    Command(BookingView click){
	this.click = click;
    }
    
    public abstract boolean execute();
}
