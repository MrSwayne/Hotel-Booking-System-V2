package ie.ul.hbs2.booking;

public abstract class Command {
    public Button click;
    
    Command(Button click){
	this.click = click;
    }
    
    public abstract boolean execute();
}
