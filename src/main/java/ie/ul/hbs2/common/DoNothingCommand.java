package ie.ul.hbs2.common;

public class DoNothingCommand implements Command {

    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}