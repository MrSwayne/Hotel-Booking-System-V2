package ie.ul.hbs2.payments.interceptors;

import ie.ul.hbs2.payments.BookingCharge;
import ie.ul.hbs2.payments.IPaymentCallback;
import ie.ul.hbs2.payments.IPaymentMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CardPayment implements IPaymentMethod {

    JButton submitButton = null;
    BookingCharge context;

    @Override
    public void processPayment(final IPaymentCallback callback) {
        JPanel panel = new JPanel();

        JPanel num = new JPanel(new GridLayout(3,1));
        JLabel numL = new JLabel("Visa Card Number");
        JTextField numF = new JTextField("", 20);
        num.add(numL, 0, 0);
        num.add(numF, 0, 1);

        JPanel name = new JPanel(new GridLayout(3,1));
        JLabel nameL = new JLabel("Cardholder Name");
        JTextField nameF = new JTextField("", 15);
        name.add(nameL, 0, 0);
        name.add(nameF, 0, 1);

        JPanel details = new JPanel(new GridLayout( 4, 2));
        JLabel expiryL = new JLabel("Card Expiry");
        JTextField expiryF = new JTextField("", 5);

        JLabel ccvL = new JLabel("CCV");
        JTextField ccvF = new JTextField("", 5);

        details.add(expiryL, 0, 0);
        details.add(expiryF, 0, 1);
        details.add(ccvL, 0, 2);
        details.add(ccvF, 0, 3);

        panel.add(num, 0, 0);
        panel.add(name, 1, 0);
        panel.add(details, 2, 0);

        JPanel controlPanel = new JPanel();
        submitButton = new JButton("Submit");
        controlPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Processing Card Payment");
                boolean proccessed = validatePayment();
                callback.workDone(proccessed);
            }
        });

        panel.add(controlPanel, 3);
        JFrame frame = new JFrame("Visa Card Payment");
        frame.setPreferredSize(new Dimension(600,400));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);//setting to the center of the screen
        frame.setVisible(true);
        frame.pack();
    }


    @Override
    public ImageIcon getIcon() throws IOException {
      //  Image img = ImageIO.read(getClass().getResource("res/Visa.png"));
        ImageIcon icon = new ImageIcon("res/Visa.png");

        return icon;
    }


    private boolean validatePayment() {
        //Process details from terminal
        //Return True or False depending
        return true;
    }

    @Override
    public void setContextObject(BookingCharge charge) {
        this.context = charge;
    }
}
