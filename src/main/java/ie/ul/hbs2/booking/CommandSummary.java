package ie.ul.hbs2.booking;

import ie.ul.hbs2.GUI.*;


public abstract class CommandSummary {
    public BookingSummaryView click;

    CommandSummary(BookingSummaryView click) {
        this.click = click;
    }

    public abstract void execute();
}
