package ie.ul.hbs2.payments;

import javax.swing.*;
import java.io.IOException;

public interface IPaymentMethod {

    void processPayment(final IPaymentCallback callback);
    ImageIcon getIcon() throws IOException;
    void setContextObject(BookingCharge charge);
}
