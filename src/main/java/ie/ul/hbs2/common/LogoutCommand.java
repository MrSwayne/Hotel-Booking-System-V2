package ie.ul.hbs2.common;

import ie.ul.hbs2.GUI.Frame;
import ie.ul.hbs2.GUI.ManagementView;

public class LogoutCommand implements Command {

    private Frame parent;

    public LogoutCommand(Frame parent) {
        this.parent = parent;
    }
    @Override
    public void execute() {
        ManagementView managementView = new ManagementView("management", parent);

        parent.show(managementView);
    }
}
