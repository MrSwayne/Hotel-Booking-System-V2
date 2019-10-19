package ie.ul.hbs2.GUI;

import javax.swing.*;
import java.awt.*;

//TODO, Still waiting on Booking to be completed before I can progress on this

public class PaymentView extends View {

    public PaymentView(String name, Frame parent) {
        super(name, parent);

        JPanel details = new JPanel(new GridLayout(5, 2));
        details.add(new JLabel("CC details"),0);
        details.add(new JTextField("", 20),1);
        this.add(details);
    }

    @Override
    public void setMessage(String message) {

    }
}
