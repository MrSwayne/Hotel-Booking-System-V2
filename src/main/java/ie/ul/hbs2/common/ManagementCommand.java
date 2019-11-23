package ie.ul.hbs2.common;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.ManagementView;

public class ManagementCommand implements Command {
    Frame parent;

    public ManagementCommand(Frame parent) {
        this.parent = parent;
    }

    @Override
    public void execute() {
        parent.getContentPane().removeAll();
        ManagementView view = new ManagementView("management",parent);
        parent.show(view);
    }
}
