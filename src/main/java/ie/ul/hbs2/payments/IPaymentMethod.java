package ie.ul.hbs2.payments;

import javax.swing.*;
import java.awt.*;
import java.awt.print.Book;
import java.io.IOException;

public interface IPaymentMethod {

    boolean processPayment();
    ImageIcon getIcon() throws IOException;
    JPanel getContentPanel(IPaymentCallback callback);
    void setContextObject(BookingCharge charge);
}
