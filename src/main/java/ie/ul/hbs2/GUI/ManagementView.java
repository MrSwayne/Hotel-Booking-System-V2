package ie.ul.hbs2.GUI;

import javax.swing.*;
import java.awt.*;

public class ManagementView extends View {


    public ManagementView(String name, Frame parent) {
        super(name, parent);

        JPanel details = new JPanel(new GridLayout(5, 2));
        details.add(new JLabel("First Name"),0);
        details.add(new JTextField("", 20),1);
        details.add(new JLabel("Last Name"),2);
        details.add(new JTextField("", 20),3);
        details.add(new JLabel("Password"),4);
        details.add(new JTextField("", 20),5);
        this.add(details);
    }

    @Override
    public void setMessage(String message) {

    }
}
