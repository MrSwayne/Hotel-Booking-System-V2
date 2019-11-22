package ie.ul.hbs2.GUI;

import ie.ul.hbs2.common.Command;

import javax.swing.*;

public class CommandJButton extends JButton implements Command {
    private Command command;

    public CommandJButton(Command command){
        super();
        this.command=command;
    }

    public void setCommand(Command command){
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }
}
